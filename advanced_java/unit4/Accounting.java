package advanced_java.unit4;
import java.text.*;

public class Accounting implements Calculate{
    private Order[] orders = new Order[1];

    public Accounting() {

    }
    public Accounting(Order[] orders) {
        this.orders = orders;
    }
    public Order[] getOrders() {
        return this.orders;
    }
    public double calculateProfitOrLoss() {
        double netProfitOrLoss = orders[0].getTotalPrice() - orders[0].getTotalCost();
        return netProfitOrLoss;
    }
    public String summarize() {
        DecimalFormat decFormat = new DecimalFormat("$#,###.00");
        double netValue = calculateProfitOrLoss();
        String str = "";
        if (netValue == 0) {
            str = "\nOn this order you have neither a profit or a loss";
        } else if (netValue < 0) {
            str = "\nOn this order you have a loss of: " + (decFormat.format((Math.abs(netValue))));
        } else if (netValue > 0) {
            str = "\nOn this order you have a Profit of: " + (decFormat.format((netValue)));
        }
        return str;
    }
    public int calculateProfitMargin(double price, double cost) {
        double profitMargin = 0;
        try {
            profitMargin = (price - cost) / cost;
        }
        catch (ArithmeticException e) {
            System.out.println("Cannot calculate the profit margin because the cost is zero and division by zero is not possible.");
        }
        int profitMarginAsPercentage = (int) Math.round(profitMargin * 100);
        return profitMarginAsPercentage;
    }
}
