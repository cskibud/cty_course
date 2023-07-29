package print_company.unit9;
import java.util.Scanner;

public class DetermineOfficeLocations {
    public static void main(String[] args) {
        System.out.println("Welcome! The purpose of this program is to identify four new office locations and determine their viability.");
        System.out.println();
        System.out.println("You will be prompted to enter office locations and their distance from the central office iteratively.");
        String[] officeLocationsArray = new String[4];
        boolean retry = false;
        for (int i = 0; i < 4; i++) {
            do {
                retry = false;
                String officeLocation = getOFficeLocation();
                if (!checkLength(officeLocation)) {
                    showLocationError(officeLocation);
                    retry = true;
                } else {
                    double officeDistance = getOfficeDistance();
                    int numResult = checkDistance(officeDistance);
                    if (numResult != 0) {
                        showDistanceError(officeDistance, numResult);
                        retry = true;
                    } else {
                        officeLocationsArray[i] = officeLocation;
                        showPass(officeLocation);
                    }
                }
            } while (retry);
        }
        System.out.println("\n");
        System.out.println("Four possible office locations are:");
        printArray(officeLocationsArray);
    }
    public static String getOFficeLocation() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Enter a potential office location (up to 15 characters):");
        String officeLocation = input.nextLine();
        return officeLocation;
    }
    public static double getOfficeDistance() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter the distance from the potential office to the central office (in miles):");
        double officeDistance = input.nextDouble();
        return officeDistance;
    }
    public static int checkDistance(double officeDistance) {
        if (officeDistance < 100) {
            return -1;
        } else if (officeDistance > 800) {
            return 1; 
        } else {
            return 0;
        }
    }
    public static boolean checkLength(String officeLocation) {
        if (officeLocation.length() > 0 && officeLocation.length() <= 15) {
            return true;
        } else {
            return false;
        }
    }
    public static void showLocationError(String officeLocation) {
        StringBuilder str = new StringBuilder();
        str.append("There are too many characters in \"");
        str.append(officeLocation);
        str.append("\".");
        str.append(" Please try again.");
        System.out.println(str.toString());
    }
    public static void showDistanceError(double officeDistance, int numResult) {
        StringBuilder str = new StringBuilder();
        if (numResult == -1) {
            str.append(officeDistance);
            str.append(" miles is too close to the central office.");
            str.append("\"");
            str.append(" Please try again.");
        } else if (numResult == 1) {
            str.append(officeDistance);
            str.append(" miles is too far from the central office.");
            str.append("\"");
            str.append(" Please try again.");
        }
        System.out.println(str.toString());
    }
    public static void showPass(String officeLocation) {
        StringBuilder str = new StringBuilder();
        str.append(officeLocation);
        str.append(" is a potential office location.");
        System.out.println(str.toString());
    }
    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
