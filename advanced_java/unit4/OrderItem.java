package advanced_java.unit4;

public class OrderItem {
    private int orderNumber;
    private int quantity;
    private Product item;

    public OrderItem() {
    }
    public OrderItem(int orderNumber, int quantity, Product item) {
        this.quantity = quantity;
        this.item = item;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public int getOrderNumber() {
        return this.orderNumber;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public void setItem(Product item) {
        this.item = item;
    }
    public Product getItem() {
        return this.item;
    }

}
