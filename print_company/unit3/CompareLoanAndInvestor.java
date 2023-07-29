package print_company.unit3;
import java.util.Scanner;

public class CompareLoanAndInvestor {
    public static void main(String [] args) {
        // Calculate loan
        System.out.println("Calculating for a Loan:");
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

        // Calculate investor
        System.out.println("\n");
        System.out.println("Calculating for an Investor:");
        System.out.println("Enter Amount Invested: ");
        double amountInvested = input.nextDouble();
        System.out.println("Enter Current Company Valuation: ");
        double currentValue = input.nextDouble();
        System.out.println("Enter Estimated Rate of Growth as a Percentage: ");
        double growthRate = input.nextDouble()/100;
        System.out.println("Enter Percentage of Company Given for Investment: ");
        double investorPercentage = input.nextDouble()/100;
        System.out.println("Enter Number of Investment Years: ");
        int time = input.nextInt();

        double companyFutureValue = (Math.pow((1 + growthRate), time)) * currentValue;
        double investorFutureValue = investorPercentage * companyFutureValue;
        double ownerFutureValue = companyFutureValue - (amountInvested + investorFutureValue);

        System.out.println("The Future Value for the Owner is: ");
        System.out.println("$" + ownerFutureValue);

        // Compare Loan and Investor
        double ownerValueWithLoan = companyFutureValue - totalPayment;
        System.out.println("\n");
        System.out.println("Owner Future Value with a Loan: ");
        System.out.println("$" + ownerValueWithLoan);
        System.out.println("Owner Future Value with an Investor: ");
        System.out.println("$" + ownerFutureValue);
    }
}
