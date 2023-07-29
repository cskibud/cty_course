package advanced_java.unit3;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Welcome to the product manager for Blue Heart!");
        Product[] productArray = new Product[3];
        productArray[0] = getPaintingInput();
        productArray[1] = getSketchInput();
        productArray[2] = getPhotographInput();
        System.out.println("\n");
        System.out.println("Summary:");
        for (int i = 0; i < productArray.length; i++) {
            productArray[i].outputProduct();
        }
    }
    public static Painting getPaintingInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Enter the following information for a painting:");
        System.out.println("Title:");
        String title = input.nextLine();
        System.out.println("Painter:");
        String painter = input.nextLine();
        System.out.println("Type:");
        String type = input.nextLine();
        Painting painting = new Painting(title, painter, type);
        return painting;
    }
    public static Sketch getSketchInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Enter the following information for a sketch:");
        System.out.println("Title:");
        String title = input.nextLine();
        System.out.println("Sketcher:");
        String sketcher = input.nextLine();
        System.out.println("Technique Used:");
        String technique = input.nextLine();
        Sketch sketch = new Sketch(title, sketcher, technique);
        return sketch;
    }
    public static Photograph getPhotographInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Enter the following information for a photograph:");
        System.out.println("Title:");
        String title = input.nextLine();
        System.out.println("Photographer:");
        String photographer = input.nextLine();
        System.out.println("Camera Used:");
        String cameraUsed = input.nextLine();
        Photograph photograph = new Photograph(title, photographer, cameraUsed);
        return photograph;
    }
}
