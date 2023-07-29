package advanced_java.unit4;

public class Photograph extends Product{
    private String photographer;
    private String cameraUsed;

    public Photograph() {

    }
    public Photograph(double cost, double price) {
        super(cost, price);
    }
    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }
    public String getPhotographer() {
        return this.photographer;
    }
    public void setCameraUsed(String cameraUsed) {
        this.cameraUsed = cameraUsed;
    }
    public String getCameraUsed() {
        return this.cameraUsed;
    }
}
