package print_company;
import java.util.*;

public class WrapperChallenge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program will compare the value of two numeric values");
        System.out.println("\n" + "Please enter the first value:");
        int firstValue = input.nextInt();
        System.out.println("\n" + "Please enter the second value:");
        int secondValue = input.nextInt();
        int result = (Integer.compare(firstValue, secondValue));
        if (result == 0) {
            System.out.println("The values are equal.");
        } else if (result == -1) {
            System.out.println("\n" + "The first value is less than the second value.");
        } else if (result == 1) {
            System.out.println("\n" + "The first value is greater than the second value.");
        }
    }
}
