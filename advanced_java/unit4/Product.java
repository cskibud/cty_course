package advanced_java.unit4;

public abstract class Product {
    private double cost;
    private double price;

    public Product() {
        this.cost = 0.0;
        this.price = 0.0;
    }
    public Product(double cost, double price) {
        this.cost = cost;
        this.price = price;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public double getCost() {
        return this.cost;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }

    public void outputProduct() {

    }
    public int calculateProfitMargin(double price, double cost) {
        double profitMargin = 0;
        try {
            profitMargin = (price - cost) / cost;
            if (cost == 0.0)
                throw new ArithmeticException();
        }
        catch (ArithmeticException e) {
            System.out.println("Cannot calculate the profit margin because the cost is zero and division by zero is not possible.");
            return 100;
        }
        int profitMarginAsPercentage = (int) Math.round(profitMargin * 100);
        return profitMarginAsPercentage;
    }
}
