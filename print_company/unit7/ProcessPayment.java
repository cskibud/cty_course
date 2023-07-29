package print_company.unit7;
import java.util.Scanner;

public class ProcessPayment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean retry = false;
        do {
            System.out.println("Please enter a payment method from below:");
            System.out.println("1 = Credit");
            System.out.println("2 = Cash/Check");
            System.out.println("3 = Purchase Requisition");
            int payType = input.nextInt();
            input.nextLine();
            if (payType == 1) {
                // credit - check everything
                boolean invalidRetry = false;
                do {
                System.out.println("Please enter your credit card number:");
                String cardNumber = input.nextLine();
                boolean validity = isCardValid(cardNumber);
                if (validity) {
                    String cardType = findCardType(cardNumber);
                    System.out.println("You have selected to pay with credit, and the card you are using is a(n) " + cardType + " card.");
                    break;
                } else {
                    System.out.println("Your credit card number is invalid, try again.");
                    invalidRetry = true;
                }
                } while (invalidRetry);
                retry = false;
            } else if (payType == 2 || payType == 3) {
                System.out.println("Sorry, this payment method is not currently supported. Please try again later.");
                break;
            } else {
                System.out.println("Please try again and enter the number corresponding to the payment method desired from our list.");
                retry = true;
                System.out.println("\n");
            }
        } while (retry);
    }
    public static String findCardType(String input) {
        char firstChar = input.charAt(0); 
        if (firstChar == '3') {
            return "American Express";
        } else if (firstChar == '4') {
            return "Visa";
        } else if (firstChar == '5') {
            return "Mastercard";
        } else if (firstChar == '6') {
            return "Discover";
        } else {
            return "";
        }
    }
    public static Boolean isCardValid(String input) {
        char firstChar = input.charAt(0);
        if (firstChar == '3' && input.length() == 15) {
            return true;
        } else if ((firstChar == '4' || firstChar == '5' || firstChar == '6') && input.length() == 16) {
            return true;
        } else {
            return false;
        }
    }
}
