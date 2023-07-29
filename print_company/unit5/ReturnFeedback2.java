package print_company.unit5;
import java.util.Scanner;
import java.text.*;

public class ReturnFeedback2 {
    public static void main(String [] args) {
        // initial output
        System.out.println("      *  *            *  *      ");
        System.out.println("  *          *    *          *  ");
        System.out.println("   *            *            *   ");
        System.out.println("       *        B        *       ");
        System.out.println("           *         *           ");
        System.out.println("                *                ");
        System.out.println("Welcome to Blue Heart!");
        System.out.println("Here is what is available in out store today:");
        System.out.println("1. Paintings - $25.00 (per unit)");
        System.out.println("2. Sketches - $18.00 (per unit)");
        System.out.println("3. Medium-sized Frames - $10.00 (per unit)");
        System.out.println("4. Small-sized Frames - $6.00 (per unit)");

        // first product
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Please make your first selection from the options provided in the product menu (type just the product name exactly as shown):");
        String productRequested1 = input.nextLine();

        System.out.println("How many " + productRequested1 + " would you like to buy?");
        int quantityRequested1 = input.nextInt();
        input.nextLine();

        // second product
        System.out.println("\n");
        System.out.println("Please make your second selection from the options provided in the product menu (type just the product name exactly as shown):");
        String productRequested2 = input.nextLine();

        System.out.println("How many " + productRequested2 + " would you like to buy?");
        int quantityRequested2 = input.nextInt();

        // cost calculations for first selection
        double cost1 = 0;
        if (productRequested1.equals("Paintings")) {
            cost1 = quantityRequested1 * 25.0;
        } else if (productRequested1.equals("Sketches")) {
            cost1 = quantityRequested1 * 18.0;
        } else if (productRequested1.equals("Medium-sized Frames")) {
            cost1 = quantityRequested1 * 10.0;
        } else if (productRequested1.equals("Small-sized Frames")) {
            cost1 = quantityRequested1 * 6.0;
        }
        // cost calculations for second selection
        double cost2 = 0;
        if (productRequested2.equals("Paintings")) {
            cost2 = quantityRequested2 * 25.0;
        } else if (productRequested2.equals("Sketches")) {
            cost2 = quantityRequested2 * 18.0;
        } else if (productRequested2.equals("Medium-sized Frames")) {
            cost2 = quantityRequested2 * 10.0;
        } else if (productRequested2.equals("Small-sized Frames")) {
            cost2 = quantityRequested2 * 6.0;
        }
        double totalCost = cost1 + cost2;      
        System.out.println("\n");

        // discounts + price outputs
        DecimalFormat decFormat = new DecimalFormat("$#,###.00");
        if ((productRequested1.equals("Paintings") && productRequested2.equals("Sketches")) || (productRequested1.equals("Sketches") && productRequested2.equals("Paintings"))) {
            if (quantityRequested1 > 10 || quantityRequested2 > 10) {
                double subtrahend1 = cost1/15;
                double discountedCost1 = cost1 - subtrahend1;
                double subtrahend2 = cost2/15;
                double discountedCost2 = cost2 - subtrahend2;
                double discountedTotal = discountedCost1 + discountedCost2;
                System.out.println("You get a 10% discount for choosing to purchase the first 2 items on our menu, and a 5% discount for choosing to purchase more than 10 units for both selections!");
                System.out.println("The discounted price for " + quantityRequested1 + " " + productRequested1 + " is: " + decFormat.format(discountedCost1));
                System.out.println("The discounted price for " + quantityRequested2 + " " + productRequested2 + " is: " + decFormat.format(discountedCost2));
                System.out.println("Your total price is: " + decFormat.format(discountedTotal));
            } else {
                double subtrahend1 = cost1/10;
                double discountedCost1 = cost1 - subtrahend1;
                double subtrahend2 = cost2/10;
                double discountedCost2 = cost2 - subtrahend2;
                double discountedTotal = discountedCost1 + discountedCost2;
                System.out.println("You get a 10% discount for choosing to purchase the first 2 items on our menu!");
                System.out.println("The discounted price for " + quantityRequested1 + " " + productRequested1 + " is: " + decFormat.format(discountedCost1));
                System.out.println("The discounted price for " + quantityRequested2 + " " + productRequested2 + " is: " + decFormat.format(discountedCost2));
                System.out.println("Your total price is: " + decFormat.format(discountedTotal));
            }
        } else if (quantityRequested1 > 10 && quantityRequested2 > 10) {
            double subtrahend1 = cost1/5;
            double discountedCost1 = cost1 - subtrahend1;
            double subtrahend2 = cost2/5;
            double discountedCost2 = cost2 - subtrahend2;
            double discountedTotal = discountedCost1 + discountedCost2;
            System.out.println("You get a 5% discount for choosing to purchase more than 10 units for both selections!");
            System.out.println("The discounted price for " + quantityRequested1 + " " + productRequested1 + " is: " + decFormat.format(discountedCost1));
            System.out.println("The discounted price for " + quantityRequested2 + " " + productRequested2 + " is: " + decFormat.format(discountedCost2));
            System.out.println("Your total price is: " + decFormat.format(discountedTotal));
        } else {
            System.out.println("The price for " + quantityRequested1 + " " + productRequested1 + " is: " + decFormat.format(cost1));
            System.out.println("The price for " + quantityRequested2 + " " + productRequested2 + " is: " + decFormat.format(cost2));
            System.out.println("Your total price is: " + decFormat.format(totalCost));
        }
        // final checkpoint
        System.out.println("\n");
        System.out.println("Choose 1 to complete your purchase, or 2 to exit.");
        int n = input.nextInt();
        if (n == 1) {
            System.out.println("\n");
            System.out.println("Congratulations! Your purchase has been processed.");
        } else if (n == 2) {
            System.out.println("\n");
            System.out.println("I am sorry we could not provide you with any products today. Please check back when you are ready to purchase.");
        }

    }
}
