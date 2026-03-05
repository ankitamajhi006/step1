import java.util.*;

// Main class
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Palindrome Checker App ===");
        System.out.print("Enter a word or phrase to check: ");
        String input = scanner.nextLine();

        System.out.println("\n--- UC1: Welcome Message ---");
        System.out.println("Palindrome Checker App v1.0");

        System.out.println("\n--- UC2: Hardcoded Palindrome Result ---");
        String hardcoded = "madam";
        System.out.println("\"" + hardcoded + "\" is " + (hardcoded.equals(new StringBuilder(hardcoded).reverse().toString()) ? "" : "NOT ") + "a palindrome.");

        System.out.println("\n--- UC3: String Reverse Method ---");
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) reversed += input.charAt(i);
        System.out.println("\"" + input + "\" is " + (input.equals(reversed) ? "" : "NOT ") + "a palindrome.");

        System.out.println("\n--- UC4: Character Array Method ---");
        char[] chars = input.toCharArray();
        boolean uc4 = true;
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) { uc4 = false; break; }
        }
        System.out.println("\"" + input + "\" is " + (uc4 ? "" : "NOT ") + "a palindrome.");

        System.out.println("\n--- UC5: Stack Method ---");
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);
        String uc5rev = "";
        while (!stack.isEmpty()) uc5rev += stack.pop();
        System.out.println("\"" + input + "\" is " + (input.equals(uc5rev) ? "" : "NOT ") + "a palindrome.");

        System.out.println("\n--- UC6: Queue + Stack Method ---");
        Queue<Character> queue = new LinkedList<>();
        stack.clear();
        for (char c : input.toCharArray()) { queue.add(c); stack.push(c); }
        boolean uc6 = true;
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) { uc6 = false; break; }
        }
        System.out.println("\"" + input + "\" is " + (uc6 ? "" : "NOT ") + "a palindrome.");

        System.out.println("\n--- UC7: Deque Method ---");
        Deque<Character> deque = new LinkedList<>();
        for (char c : input.toCharArray()) deque.addLast(c);
        boolean uc7 = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) { uc7 = false; break; }
        }
        System.out.println("\"" + input + "\" is " + (uc7 ? "" : "NOT ") + "a palindrome.");

        System.out.println("\n--- UC8: Linked List Method ---");
        Node head = null, tail = null;
        for (char c : input.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) head = tail = newNode; else { tail.next = newNode; tail = newNode; }
        }
        boolean uc8 = checkLinkedListPalindrome(head);
        System.out.println("\"" + input + "\" is " + (uc8 ? "" : "NOT ") + "a palindrome.");

        System.out.println("\n--- UC9: Recursive Method ---");
        boolean uc9 = isPalindromeRecursive(input, 0, input.length() - 1);
        System.out.println("\"" + input + "\" is " + (uc9 ? "" : "NOT ") + "a palindrome.");

        System.out.println("\n--- UC10: Case-Insensitive & Space-Ignored ---");
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        String reversedNorm = new StringBuilder(normalized).reverse().toString();
        System.out.println("\"" + input + "\" is " + (normalized.equals(reversedNorm) ? "" : "NOT ") + "a palindrome.");

        System.out.println("\n--- UC11: Object-Oriented Palindrome Service ---");
        PalindromeChecker checker = new PalindromeChecker();
        System.out.println("\"" + input + "\" is " + (checker.checkPalindrome(input) ? "" : "NOT ") + "a palindrome.");

        System.out.println("\n--- UC12: Strategy Pattern ---");
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        System.out.println("StackStrategy: \"" + input + "\" is " + (stackStrategy.isPalindrome(input) ? "" : "NOT ") + "a palindrome.");
        System.out.println("DequeStrategy: \"" + input + "\" is " + (dequeStrategy.isPalindrome(input) ? "" : "NOT ") + "a palindrome.");
    }

    // UC8 Node class
    static class Node { char data; Node next; Node(char d) { data = d; } }

    // UC8: Linked list palindrome
    private static boolean checkLinkedListPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) { slow = slow.next; fast = fast.next.next; }
        Node secondHalf = reverseList(slow.next);
        Node firstHalf = head; Node tempSecond = secondHalf;
        boolean result = true;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) { result = false; break; }
            firstHalf = firstHalf.next; tempSecond = tempSecond.next;
        }
        slow.next = reverseList(secondHalf);
        return result;
    }

    private static Node reverseList(Node head) {
        Node prev = null, current = head;
        while (current != null) {
            Node nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    // UC9: Recursive palindrome
    private static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // UC11: Object-oriented PalindromeChecker
    static class PalindromeChecker {
        public boolean checkPalindrome(String str) {
            int i = 0, j = str.length() - 1;
            while (i < j) {
                if (str.charAt(i) != str.charAt(j)) return false;
                i++; j--;
            }
            return true;
        }
    }

    // UC12: Strategy pattern interface and classes
    interface PalindromeStrategy { boolean isPalindrome(String word); }

    static class StackStrategy implements PalindromeStrategy {
        public boolean isPalindrome(String word) {
            Stack<Character> stack = new Stack<>();
            for (char c : word.toCharArray()) stack.push(c);
            for (char c : word.toCharArray()) if (c != stack.pop()) return false;
            return true;
        }
    }

    static class DequeStrategy implements PalindromeStrategy {
        public boolean isPalindrome(String word) {
            Deque<Character> deque = new LinkedList<>();
            for (char c : word.toCharArray()) deque.addLast(c);
            while (deque.size() > 1) if (!deque.removeFirst().equals(deque.removeLast())) return false;
            return true;
        }
    }
}
import java.util.*;

// Main application class
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Strategy Pattern Palindrome Checker ===");
        System.out.print("Enter a word or phrase: ");
        String word = scanner.nextLine();

        // Dynamically choose a strategy
        PalindromeStrategy strategy;

        // Use Stack-based strategy
        strategy = new StackStrategy();
        checkWithStrategy(word, strategy);

        // Use Deque-based strategy
        strategy = new DequeStrategy();
        checkWithStrategy(word, strategy);
    }

    // Helper method to execute a strategy
    private static void checkWithStrategy(String word, PalindromeStrategy strategy) {
        boolean result = strategy.isPalindrome(word);
        System.out.println("Using " + strategy.getClass().getSimpleName() +
                ": \"" + word + "\" is " + (result ? "" : "NOT ") + "a palindrome.");
    }
}

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String word);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String word) {
        Stack<Character> stack = new Stack<>();
        for (char ch : word.toCharArray()) stack.push(ch);
        for (char ch : word.toCharArray()) if (ch != stack.pop()) return false;
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String word) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : word.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}
import java.util.*;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Palindrome Performance Comparison ===");
        System.out.print("Enter a word or phrase: ");
        String word = scanner.nextLine();

        // UC3: Reverse String Method
        long start = System.nanoTime();
        boolean reverseResult = checkPalindromeReverse(word);
        long end = System.nanoTime();
        System.out.println("[Reverse String] Result: " + reverseResult + ", Time: " + (end - start) + " ns");

        // UC4: Character Array Method
        start = System.nanoTime();
        boolean charArrayResult = checkPalindromeCharArray(word);
        end = System.nanoTime();
        System.out.println("[Char Array] Result: " + charArrayResult + ", Time: " + (end - start) + " ns");

        // UC5: Stack Method
        start = System.nanoTime();
        boolean stackResult = checkPalindromeStack(word);
        end = System.nanoTime();
        System.out.println("[Stack] Result: " + stackResult + ", Time: " + (end - start) + " ns");

        // UC7: Deque Method
        start = System.nanoTime();
        boolean dequeResult = checkPalindromeDeque(word);
        end = System.nanoTime();
        System.out.println("[Deque] Result: " + dequeResult + ", Time: " + (end - start) + " ns");

        // UC9: Recursive Method
        start = System.nanoTime();
        boolean recursiveResult = checkPalindromeRecursive(word, 0, word.length() - 1);
        end = System.nanoTime();
        System.out.println("[Recursive] Result: " + recursiveResult + ", Time: " + (end - start) + " ns");
    }

    // UC3: Reverse String Method
    private static boolean checkPalindromeReverse(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) reversed += str.charAt(i);
        return str.equals(reversed);
    }

    // UC4: Character Array Method
    private static boolean checkPalindromeCharArray(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) return false;
        }
        return true;
    }

    // UC5: Stack Method
    private static boolean checkPalindromeStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        for (char c : str.toCharArray()) if (c != stack.pop()) return false;
        return true;
    }

    // UC7: Deque Method
    private static boolean checkPalindromeDeque(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) if (!deque.removeFirst().equals(deque.removeLast())) return false;
        return true;
    }

    // UC9: Recursive Method
    private static boolean checkPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return checkPalindromeRecursive(str, start + 1, end - 1);
    }
}