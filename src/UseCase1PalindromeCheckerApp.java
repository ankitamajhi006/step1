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
