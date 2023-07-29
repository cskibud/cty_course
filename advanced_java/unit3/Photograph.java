package advanced_java.unit3;

public class Photograph extends Product{
    private String photographer;
    private String cameraUsed;

    public Photograph() {

    }
    public Photograph(String title, String photographer, String cameraUsed) {
        super(title);
        this.photographer = photographer;
        this.cameraUsed = cameraUsed;
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
    public void outputProduct() {
        String string = getTitle() + ", " +
        photographer + ", " + 
        cameraUsed;
        System.out.println(string);
    }
}
