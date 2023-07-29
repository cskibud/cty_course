package advanced_java.midtermProject;

public class Product {
    private String productName;
    private double purchaseCost;
    private double salePrice;
    private double stockingCost;
    private Warehouse warehouse;
    private Customer customer;

    public Product() {

    }
    public Product(String productName, double purchaseCost, double salePrice, double stockingCost, Warehouse warehouse, Customer customer) {
        this.productName = productName;
        this.purchaseCost = purchaseCost;
        this.salePrice = salePrice;
        this.stockingCost = stockingCost;
        this.warehouse = warehouse;
        this.customer = customer;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductName() {
        return this.productName;
    }
    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }
    public double getPurchaseCost() {
        return this.purchaseCost;
    }
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
    public double getSalePrice() {
        return this.salePrice;
    }
    public void setStockingCost(double stockingCost) {
        this.stockingCost = stockingCost;
    }
    public double getStockingCost() {
        return this.stockingCost;
    }
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    public Warehouse getWarehouse() {
        return this.warehouse;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Customer getCustomer() {
        return this.customer;
    }
}
