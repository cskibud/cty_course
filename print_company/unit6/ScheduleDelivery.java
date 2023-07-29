package print_company.unit6;
import java.util.Scanner;

public class ScheduleDelivery {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Blue Heart!");
        System.out.println("You can now select a delivery date and products will be delivered to your door!");
        System.out.println("\n");
        System.out.println("Please enter the product you wish to be delivered:");
        String product = input.nextLine();
        int month;
        int day;
        int year;

        boolean userRetry = true;
        boolean retry;
        do {
            do {
                retry = false;
                System.out.println("\n");
                System.out.println("Please enter the delivery month as a number (1 = January, 2 = February, ... 12 = December):");
                month = input.nextInt();
                System.out.println("\n");
                System.out.println("Please enter the delivery day:");
                day = input.nextInt();
                System.out.println("\n");
                System.out.println("Please enter the delivery year (in four digits, eg. 2023):");
                year = input.nextInt();
                System.out.println("\n");

                if (month < 1 || month > 12) {
                    System.out.println("You have entered an invalid month, please try again.");
                    retry = true;
                    continue;
                }
                if (year < 1000 || year > 9999) {
                    System.out.println("You have entered an invalid year, please try again.");
                    retry = true;
                    continue;
                }
                if ((month == 2 && (year % 4 == 0)) && (day < 1 || day > 29)) {
                    System.out.println("You have entered an invalid day, please try again.");
                    retry = true;
                    continue;
                } 
                if ((month == 2 && (year % 4 != 0)) && (day < 1 || day > 28)) {
                    System.out.println("You have entered an invalid day, please try again.");
                    retry = true;
                    continue;
                }
                if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day < 1 || day > 31)) {
                    System.out.println("You have entered an invalid day, please try again.");
                    retry = true;
                    continue;
                }
                if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {
                    System.out.println("You have entered an invalid day, please try again.");
                    retry = true;
                    continue;
                }
                if ((month == 1 && day == 1 || month == 3 && day == 20 || month == 4 && day == 22 || month == 5 && day == 1 || month == 6 && day == 5 || month == 6 && day == 2 || month == 12 && day == 31)) {
                    System.out.println("Sorry, we are unavailable that day. Please enter 1 to retry and 2 to quit:");
                    int num = input.nextInt();
                    if (num == 1) {
                        retry = true;
                        continue;
                    } else {
                        userRetry = false;
                        break;
                    }
                }          
            } while (retry);
            if (!userRetry) {
                break;
            }
            String monthName = " ";
            switch (month) {
                case 1:
                    monthName = "January";
                    break;
                case 2:
                    monthName = "February";
                    break;
                case 3:
                    monthName = "March";
                    break;
                case 4:
                    monthName = "April";
                    break;
                case 5:
                    monthName = "May";
                    break;
                case 6:
                    monthName = "June";
                    break;
                case 7:
                    monthName = "July";
                    break;
                case 8:
                    monthName = "August";
                    break;
                case 9:
                    monthName = "September";
                    break;
                case 10:
                    monthName = "October";
                    break;
                case 11:
                    monthName = "November";
                    break;
                case 12:
                    monthName = "December";
                    break;
            }
            // confirmation
            // System.out.println("\n");
            System.out.println("You have selected " + monthName + " " + day + ", " + year + " to have " + product + " delivered.");
            System.out.println("To confirm, enter 1. To re-enter, enter 2. To quit, enter 3.");
            int num2 = input.nextInt();
            if (num2 == 1) {
                System.out.println("\n");
                System.out.println("Congratulations! Your delivery date has been scheduled.");
                break;
            } else if (num2 == 2) {
                userRetry = true;
            } else {
                break;
            }
    } while (userRetry);
}
}
