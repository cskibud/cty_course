package advanced_java.unit4;
import java.text.*;

public class Order implements Calculate{
    private OrderItem[] orderItems;

    public Order() {
    }
    public Order(OrderItem[] orderItems) {
        this.orderItems = orderItems;
    }
    public double getTotalPrice() {
        double customerTotal = 0;
        for (int i = 0; i < orderItems.length; i++) {
            int quantity = orderItems[i].getQuantity();
            double price = orderItems[i].getItem().getPrice();
            customerTotal += quantity * price;
        }
        return customerTotal;
    }
    public double getTotalCost() {
        double costTotal = 0;
        for (int i = 0; i < orderItems.length; i++) {
            int quantity = orderItems[i].getQuantity();
            double cost = orderItems[i].getItem().getCost();
            costTotal += quantity * cost;
        }
        return costTotal;
    }
    public String summarize() {
        DecimalFormat decFormat = new DecimalFormat("$#,###.00");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < orderItems.length; i++) {
            String type = orderItems[i].getItem().getClass().getSimpleName();
            int orderNumber = i + 1;
            int quantity = orderItems[i].getQuantity();
            double price = orderItems[i].getItem().getPrice();
            String product = "";
            if (type.equals("Painting")) {
                product = "painting(s)";
            } else if (type.equals("Sketch")) {
                product = "sketch(es)";
            } else if (type.equals("Photograph")) {
                product = "photograph(s)";
            }
            String str = "\nOrder " + orderNumber + ": " + quantity + " " + product + " at " + decFormat.format(price);
            sb.append(str);
        }
        String totals = "\nOrder Customer Total: " + decFormat.format(getTotalPrice()) + "\nOrder Cost Total: " + decFormat.format(getTotalCost());
        sb.append(totals);
        String returnString = sb.toString();
        return returnString;
    }
}
