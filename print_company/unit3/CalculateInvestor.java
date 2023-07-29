package print_company.unit3;
import java.util.Scanner;

public class CalculateInvestor {
    public static void main(String [] args) {
        Scanner input = new Scanner (System.in);
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
    }
}
