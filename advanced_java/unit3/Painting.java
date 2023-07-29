package advanced_java.unit3;

public class Painting extends Product{
    private String painter;
    private String type;

    public Painting() {

    }
    public Painting(String title, String painter, String type) {
        super(title);
        this.painter = painter;
        this.type = type;
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
    public void outputProduct() {
        String string = getTitle() + ", " +
        painter + ", " + 
        type;
        System.out.println(string);
    }
}
