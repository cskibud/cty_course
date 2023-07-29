package advanced_java.unit4;

public class Sketch extends Product{
    private String sketcher;
    private String technique;

    public Sketch() {

    }
    public Sketch(double cost, double price) {
        super(cost, price);
    }
    public void setSketcher(String sketcher) {
        this.sketcher = sketcher;
    }
    public String getSketcher() {
        return this.sketcher;
    }
    public void setTechnique(String technique) {
        this.technique = technique;
    }
    public String getTechnique() {
        return this.technique;
    }
}
