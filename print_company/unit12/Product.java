package print_company.unit12;

public class Product {
    private String title;
    private double length;
    private double width;

    public Product() {

    }
    public Product(String title, double length, double width) {
        this.title = title;
        this.length = length;
        this.width = width; 
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getLength() {
        return this.length;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getwidth() {
        return this.width;
    }
}
