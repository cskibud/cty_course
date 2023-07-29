package print_company.unit4;
import java.text.*;
import java.util.Scanner;

public class ReturnFeedback {
    public static void main(String [] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("What is the product you would like to buy?");
        String productRequested = input.nextLine();

        System.out.println("How many units of " + productRequested + " would you like to buy?");
        int quantityRequested = input.nextInt();
        double costPerUnit = 7.00;
        double cost = costPerUnit * quantityRequested;

        if (quantityRequested < 0) {
            System.out.println("Please enter a natural number.");
        } else if (quantityRequested > 10) {
            System.out.println("The number of units requested, " + quantityRequested + ", is not currently in stock.");
            System.out.println("Please try ordering " + productRequested + " when supplies are in stock.");
        } else if (quantityRequested == 10) {
            DecimalFormat decFormat = new DecimalFormat("$#,###.00");
            System.out.println("We have 10 units of " + productRequested + " available in stock.");
            System.out.println("Your total cost is " + decFormat.format(cost));
        } else {
            DecimalFormat decFormat = new DecimalFormat("$#,###.00");
            System.out.println("You have requested " + quantityRequested + " units of " + productRequested + ".");
            System.out.println("Your total cost is " + decFormat.format(cost));
            int unitsRemaining = 10 - quantityRequested;
            System.out.println("There are " + unitsRemaining + " units remaining in stock.");
        }
    }
}
