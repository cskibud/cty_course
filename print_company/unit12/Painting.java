package print_company.unit12;

public class Painting extends Product{
    private String painter;
    private static int availablePaintings;

    public Painting() {

    }
    public Painting(String title, double length, double width, String painter) {
        super(title, length, width);
        this.painter = painter;
        availablePaintings++;
    }
    public double calculatePaintingPrice() {
        double paintingPrice = getLength() * getwidth() * 1.25;
        return paintingPrice;
    }
    public static void setAvailablePainting(boolean add) {
        if (add) {
            availablePaintings++;
        } else {
            availablePaintings--;
        }
    }
    public static int getAvailablePaintings() {
        return availablePaintings;
    }
    public String toString() {
        String string = "Title: " + getTitle() + "\n" +
        "Painter: " + painter + "\n" + 
        "Price $" + calculatePaintingPrice();
        return string;
    }
}
