package print_company;
import java.util.Scanner;

public class ManipulateString {
    public static void main(String[] args) {
        String newString = "";
        String userString = getString();
        int menuChoice = printMenu();
        if (menuChoice == 1) {
            newString = addToString(userString);
        } else if (menuChoice == 2) {
            // does the must input 2 twice thing again
            newString = insertInString(userString);
        }
        System.out.println("\n");
        System.out.println("Your original string was: " + userString);
        System.out.println("Your new string is: " + newString);
    }
    public static String getString() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a string to manipulate:");
        String userString = input.nextLine();
        return userString;
    }
    public static int printMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Please choose how you would like to manipulate the string:");
        System.out.println("1 - Add");
        System.out.println("2 - Insert");
        int choice = input.nextInt();
        return choice;
    }
    public static String addToString(String userString) {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter what you would like to add to the string:");
        String stringAddition = input.nextLine();
        StringBuilder str = new StringBuilder(userString);
        str.append(stringAddition);
        String newString = str.toString();
        return newString;
    }
    public static String insertInString(String userString) {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter what you would like to insert into the string:");
        String stringInsert = input.nextLine();
        System.out.println();
        System.out.println("Please enter the index after which you would like to insert your input:");
        int insertIndex = input.nextInt();
        StringBuilder str = new StringBuilder(userString);
        str.insert(insertIndex, stringInsert);
        String newString = str.toString();
        return newString;
    }
}

