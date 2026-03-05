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

        // ------------------ UC3: Palindrome Check Using String Reverse ------------------
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
}