package print_company;
import java.util.Scanner;

public class CalculateGrade {
    public static void main(String [] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter a grade: ");
        double grade = input.nextDouble();

        if (grade > 100 || grade < 0) {
            System.out.println("Please enter a valid grade.");
        } else if (grade >= 90) {
            System.out.println("The grade of " + grade + " is equivalent to an A.");
        } else if (grade >= 80) {
            System.out.println("The grade of " + grade + " is equivalent to an B.");
        } else if (grade >= 70) {
            System.out.println("The grade of " + grade + " is equivalent to an C.");
        } else if (grade >= 60) {
            System.out.println("The grade of " + grade + " is equivalent to an D.");
        } else {
            System.out.println("The grade of " + grade + " is equivalent to an F.");
        }

        if (grade >= 90 && grade <= 100) {
            System.out.println("Well done!");
        }
    }
}
