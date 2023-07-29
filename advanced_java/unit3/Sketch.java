package advanced_java.unit3;

public class Sketch extends Product{
    private String sketcher;
    private String technique;

    public Sketch() {

    }
    public Sketch(String title, String sketcher, String technique) {
        super(title);
        this.sketcher = sketcher;
        this.technique = technique;
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
    public void outputProduct() {
        String string = getTitle() + ", " +
        sketcher + ", " + 
        technique;
        System.out.println(string);
    }
}
