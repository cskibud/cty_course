package print_company;
import java.util.Scanner;

public class CalculateAreaPolygon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the amount of sides of a regular polygon:");
        int sides = input.nextInt();
        input.nextLine();
        System.out.println("Please enter the length of one of the sides:");
        double length = input.nextDouble();
        double answer = calculateArea(sides, length);
        System.out.println("The area of your regular polygon is: " + answer);
    }
    public static double calculateArea(int sides, double length) {
        double a = sides * length * length;
        double b = 4 * Math.tan(Math.PI/sides);
        double area = a/b;
        return area;
    }
    
}
