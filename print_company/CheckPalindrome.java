package print_company;
import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
         // Create a Scanner
        Scanner input = new Scanner(System.in);
        String first = "";
        String second = "";
        String third = "";
        for (int i = 0; i < 3; i++) {
            // Prompt the user to enter a string
            System.out.print("Enter a string: ");
            String s = input.nextLine();
        
            // The index of the first character in the string
            int low = 0;
        
            // The index of the last character in the string
            int high = s.length() - 1;
        
            boolean isPalindrome = true;
            while (low < high) {
                if (s.charAt(low) != s.charAt(high)) {
                isPalindrome = false;
                break;
            }
                low++;
                high--;
            }
            if (i == 0) {
                if (isPalindrome) {
                    first = s + " is a palindrome";
                } else {
                    first = s + " is not a palindrome";
                }
            } else if (i == 1) {
                if (isPalindrome) {
                    second = s + " is a palindrome";
                } else {
                    second = s + " is not a palindrome";
                }
            } else if (i == 2) {
                if (isPalindrome) {
                    third = s + " is a palindrome";
                } else {
                    third = s + " is not a palindrome";
                }
            }
        }
        System.out.println("\n");
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }
}
