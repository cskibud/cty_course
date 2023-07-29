package print_company;
import java.util.Scanner;

public class CalculateDrivingCost {
    public static void main(String [] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Enter Driving Distance: ");
        double drivingDistance = input.nextDouble();
        System.out.println("Enter Miles Per Gallon: ");
        double milesPerGallon = input.nextDouble();
        System.out.println("Enter Price Per Gallon: ");
        double pricePerGallon = input.nextDouble();

        double costOfTrip = (drivingDistance/milesPerGallon) * pricePerGallon;
        System.out.println("The cost of the trip is $" + costOfTrip);
    }
    
}
