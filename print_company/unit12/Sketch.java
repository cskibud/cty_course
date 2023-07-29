package print_company.unit12;

public class Sketch extends Product{
    private String sketcher;
    private static int availableSketches;

    public Sketch() {

    }
    public Sketch(String title, double length, double width, String sketcher) {
        super(title, length, width);
        this.sketcher = sketcher;
        availableSketches++;
    }
    public double calculateSketchPrice() {
        double sketchPrice = getLength() * getwidth() * 1.00;
        return sketchPrice;
    }
    public static void setAvailableSketches(boolean add) {
        if (add) {
            availableSketches++;
        } else {
            availableSketches--;
        }
    }
    public static int getAvailableSketches() {
        return availableSketches;
    }
    public String toString() {
        String string = "Title: " + getTitle() + "\n" +
        "Sketcher: " + sketcher + "\n" + 
        "Price $" + calculateSketchPrice();
        return string;
    }
}
