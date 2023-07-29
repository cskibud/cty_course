package advanced_java.unit3;

public abstract class Product {
    private String title;

    public Product() {
        this.title = "";
    }
    public Product(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    // abstract method
    public abstract void outputProduct();
}
