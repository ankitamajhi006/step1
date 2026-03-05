public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // ------------------ UC1: Welcome Message ------------------
        System.out.println("======================================");
        System.out.println("     Welcome to Palindrome Checker");
        System.out.println("======================================");
        System.out.println("Application Name : Palindrome Checker App");
        System.out.println("Application Version : 1.0");
        System.out.println();

        // ------------------ UC2: Hardcoded Palindrome ------------------
        String uc2Word = "madam";
        String uc2Reversed = "";
        for (int i = uc2Word.length() - 1; i >= 0; i--) {
            uc2Reversed += uc2Word.charAt(i);
        }
        if (uc2Word.equals(uc2Reversed)) {
            System.out.println("UC2 Result: The word \"" + uc2Word + "\" is a palindrome.");
        } else {
            System.out.println("UC2 Result: The word \"" + uc2Word + "\" is NOT a palindrome.");
        }
        System.out.println();

        //
        //  UC3: Palindrome Check Using String Reverse

        String uc3Word = "racecar";
        String uc3Reversed = "";
        for (int i = uc3Word.length() - 1; i >= 0; i--) {
            uc3Reversed += uc3Word.charAt(i);
        }
        if (uc3Word.equals(uc3Reversed)) {
            System.out.println("UC3 Result: The word \"" + uc3Word + "\" is a palindrome.");
        } else {
            System.out.println("UC3 Result: The word \"" + uc3Word + "\" is NOT a palindrome.");
        }
    }
    public class UseCase4PalindromeCheckerApp {
        public static void main(String[] args) {
            // The word we want to check
            String word = "level";

            // Convert the string into a character array
            char[] chars = word.toCharArray();

            // Two pointers: start and end
            int start = 0;
            int end = chars.length - 1;

            // Flag to keep track if it's a palindrome
            boolean isPalindrome = true;

            // Compare characters from both ends
            while (start < end) {
                if (chars[start] != chars[end]) {
                    isPalindrome = false;
                    break; // Stop if any mismatch found
                }
                start++;
                end--;
            }

            // Display the result in a human-friendly way
            if (isPalindrome) {
                System.out.println("The word \"" + word + "\" is a palindrome.");
            } else {
                System.out.println("The word \"" + word + "\" is NOT a palindrome.");
            }
        }
    }
    import java.util.Stack;

    public class UseCase5PalindromeCheckerApp {
        public static void main(String[] args) {
            // Word to check
            String word = "deed";

            // Create a stack to store characters
            Stack<Character> stack = new Stack<>();

            // Push all characters into the stack
            for (int i = 0; i < word.length(); i++) {
                stack.push(word.charAt(i));
            }

            // Pop characters and build reversed word
            String reversed = "";
            while (!stack.isEmpty()) {
                reversed += stack.pop();
            }

            // Compare original and reversed
            if (word.equals(reversed)) {
                System.out.println("The word \"" + word + "\" is a palindrome.");
            } else {
                System.out.println("The word \"" + word + "\" is NOT a palindrome.");
            }
        }
    }
    import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

    public class UseCase6PalindromeCheckerApp {
        public static void main(String[] args) {
            // Word to check
            String word = "level";

            // Create a queue (FIFO) and a stack (LIFO)
            Queue<Character> queue = new LinkedList<>();
            Stack<Character> stack = new Stack<>();

            // Enqueue and push all characters
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                queue.add(ch);  // enqueue
                stack.push(ch); // push to stack
            }

            // Compare dequeue vs pop
            boolean isPalindrome = true;
            while (!queue.isEmpty()) {
                char fromQueue = queue.remove(); // dequeue
                char fromStack = stack.pop();    // pop from stack
                if (fromQueue != fromStack) {
                    isPalindrome = false;
                    break;
                }
            }

            // Display result
            if (isPalindrome) {
                System.out.println("The word \"" + word + "\" is a palindrome using Queue+Stack check.");
            } else {
                System.out.println("The word \"" + word + "\" is NOT a palindrome using Queue+Stack check.");
            }
        }
    }
    import java.util.Deque;
import java.util.LinkedList;

    public class UseCase7PalindromeCheckerApp {
        public static void main(String[] args) {
            // Word to check
            String word = "rotor";

            // Create a deque and add all characters
            Deque<Character> deque = new LinkedList<>();
            for (char ch : word.toCharArray()) {
                deque.addLast(ch);
            }

            // Check palindrome by comparing front and rear
            boolean isPalindrome = true;
            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast())) {
                    isPalindrome = false;
                    break;
                }
            }

            // Print result
            if (isPalindrome) {
                System.out.println("The word \"" + word + "\" is a palindrome using Deque.");
            } else {
                System.out.println("The word \"" + word + "\" is NOT a palindrome using Deque.");
            }
        }
    }
    public class UseCase8PalindromeCheckerApp {

        // Node class for singly linked list
        static class Node {
            char data;
            Node next;
            Node(char data) { this.data = data; }
        }

        public static void main(String[] args) {
            // Word to check
            String word = "madam";

            // Convert string to linked list
            Node head = null, tail = null;
            for (char ch : word.toCharArray()) {
                Node newNode = new Node(ch);
                if (head == null) {
                    head = tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }

            // Check if palindrome
            boolean isPalindrome = checkPalindrome(head);

            // Print result
            if (isPalindrome) {
                System.out.println("The word \"" + word + "\" is a palindrome using Linked List.");
            } else {
                System.out.println("The word \"" + word + "\" is NOT a palindrome using Linked List.");
            }
        }

        // Method to check palindrome using linked list
        private static boolean checkPalindrome(Node head) {
            if (head == null || head.next == null) return true;

            // Find middle using fast and slow pointers
            Node slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Reverse second half
            Node secondHalf = reverseList(slow.next);

            // Compare first and second halves
            Node firstHalf = head;
            Node tempSecond = secondHalf;
            boolean result = true;
            while (tempSecond != null) {
                if (firstHalf.data != tempSecond.data) {
                    result = false;
                    break;
                }
                firstHalf = firstHalf.next;
                tempSecond = tempSecond.next;
            }

            // Optional: Restore the list (not necessary here)
            slow.next = reverseList(secondHalf);

            return result;
        }

        // Helper method to reverse a linked list
        private static Node reverseList(Node head) {
            Node prev = null;
            Node current = head;
            while (current != null) {
                Node nextTemp = current.next;
                current.next = prev;
                prev = current;
                current = nextTemp;
            }
            return prev;
        }
    }
    public class UseCase9PalindromeCheckerApp {

        public static void main(String[] args) {
            // Word to check
            String word = "level";

            // Check palindrome using recursion
            boolean isPalindrome = isPalindromeRecursive(word, 0, word.length() - 1);

            // Print result
            if (isPalindrome) {
                System.out.println("The word \"" + word + "\" is a palindrome using recursion.");
            } else {
                System.out.println("The word \"" + word + "\" is NOT a palindrome using recursion.");
            }
        }

        // Recursive method to check palindrome
        private static boolean isPalindromeRecursive(String str, int start, int end) {
            // Base case: if pointers cross or meet
            if (start >= end) return true;

            // If characters at start and end don't match
            if (str.charAt(start) != str.charAt(end)) return false;

            // Recursive call for the next inner pair
            return isPalindromeRecursive(str, start + 1, end - 1);
        }
    }