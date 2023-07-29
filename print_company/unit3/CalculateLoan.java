package print_company.unit3;
import java.util.Scanner;

public class CalculateLoan {
    public static void main(String [] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Enter Yearly Interest Rate: ");
        double yearlyInterestRate = input.nextDouble()/100;
        System.out.println("Enter Number of Loan Years: ");
        int loanYears = input.nextInt();
        System.out.println("Enter Loan Amount: ");
        double loanAmount = input.nextDouble();
        double rate = yearlyInterestRate / 12;
        int numberPeriods = loanYears * 12;
        double discount = (Math.pow((1 + rate), numberPeriods) - 1) / (rate * (Math.pow((1 + rate), numberPeriods)));
        double monthlyPayment = loanAmount / discount;
        double totalPayment = monthlyPayment * numberPeriods;
        System.out.println(
            "With a loan amount of $" + loanAmount + 
            " for " + loanYears + 
            " years, and a yearly interate rate of " + yearlyInterestRate + ","
        );
        System.out.println(
            "your monthly payment is:"
        );
        System.out.println(
            "$" + monthlyPayment
        );
        System.out.println(
            "and your total payment is:"
        );
        System.out.println(
            "$" + totalPayment
        );
    }
}
