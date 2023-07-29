package print_company.unit12;

public class Photograph extends Product{
    private String photographer;
    private static int availablePhotos;

    public Photograph() {

    }
    public Photograph(String title, double length, double width, String photographer) {
        super(title, length, width);
        this.photographer = photographer;
        availablePhotos++;
    }
    public double calculatePhotoPrice() {
        double photoPrice = getLength() * getwidth() * 0.50;
        return photoPrice;
    }
    public static void setAvailablePhotos(boolean add) {
        if (add) {
            availablePhotos++;
        } else {
            availablePhotos--;
        }
    }
    public static int getAvailablePhotos() {
        return availablePhotos;
    }
    public String toString() {
        String string = "Title: " + getTitle() + "\n" +
        "Photographer: " + photographer + "\n" + 
        "Price $" + calculatePhotoPrice();
        return string;
    }
}
