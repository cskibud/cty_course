package advanced_java.unit4;

public class Painting extends Product{
    private String painter;
    private String type;

    public Painting() {

    }
    public Painting(double cost, double price) {
        super(cost, price);
    }
    public void setPainter(String painter) {
        this.painter = painter;
    }
    public String getPainter() {
        return this.painter;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
}
