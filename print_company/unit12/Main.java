package print_company.unit12;
import java.util.*;

public class Main {
    private static 
    ArrayList<Product> inventory = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        initiateInventory();
        boolean keepGoing = false;
        do {
            keepGoing = false;
            int topMenuChoice = getTopMenuChoice();
            if (topMenuChoice == 1) {
                int inventoryMenuChoice = getInventoryMenuChoice();
                switch(inventoryMenuChoice) {
                    case 1: 
                    inventory1();
                    break;
                    case 2:
                    inventory2();
                    break;
                    case 3:
                    inventory3();
                    break;
                    default:
                    break;
                }
            } else if (topMenuChoice == 2) {
                int salesMenuChoice = getSalesMenuChoice();
                switch(salesMenuChoice) {
                    case 1:
                    sales1();
                    break;
                    case 2:
                    sales2();
                    break;
                    case 3:
                    sales3();
                    break;
                    default:
                    break;
                }
            }
            System.out.println("\n\n-----------------------------------\nReturn to menu: 1\nExit: 2");
            int continuationChoice = input.nextInt();
            if (continuationChoice == 1) {
                keepGoing = true;
            } else {
                keepGoing = false;
            }
        } while(keepGoing);
    }
    private static void initiateInventory() {
        Painting p1 = new Painting("Lilies", 10, 8, "Claude Bonet");
        Painting p2 = new Painting("Water", 6, 4, "Leonardo Davinki");
        Painting p3 = new Painting("Night", 9, 12, "Brett Roberts");

        Sketch s1 = new Sketch("Silk", 4, 3, "Claire Little");
        Sketch s2 = new Sketch("Dancer", 12, 10, "Tom Nook");
        Sketch s3 = new Sketch("Moon", 5, 6, "Haley Blue");

        Photograph f1 = new Photograph("Hunt", 7, 6, "Adams Ansel");
        Photograph f2 = new Photograph("Street", 8, 4, "Anthony Whitmos");
        Photograph f3 = new Photograph("Flight", 8, 14, "Marc Hans");

        inventory = new ArrayList<>();
        inventory.add(p1);
        inventory.add(p2);
        inventory.add(p3);
        inventory.add(s1);
        inventory.add(s2);
        inventory.add(s3);
        inventory.add(f1);
        inventory.add(f2);
        inventory.add(f3);
    }
    public static int getTopMenuChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("To access inventory actions, enter 1");
        System.out.println("To access sales actions, enter 2");
        int topMenuChoice = input.nextInt();
        return topMenuChoice;
    }
    public static int getInventoryMenuChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "Add a product to the system: 1");
        System.out.println("View Inventory: 2");
        System.out.println("Modify available inventory: 3");
        int inventoryMenuChoice = input.nextInt();
        return inventoryMenuChoice;
    }
    public static int getSalesMenuChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "View a list of products and their properties, including available quantity and pricing: 1");
        System.out.println("Buy a product: 2");
        System.out.println("Return a product: 3");
        int salesMenuChoice = input.nextInt();
        return salesMenuChoice;
    }
    public static void inventory1() {
        // add a product
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "What would you like to add?");
        System.out.println("Painting: 1\nSketch: 2\nPhotograph: 3");
        int typeNum = input.nextInt();
        if (typeNum == 1) {
            Painting p4 = new Painting("Light", 10, 8, "New Bury");
            inventory.add(p4);
            System.out.println("\n" + "A painting has been added.");
        } else if (typeNum == 2) {
            Sketch s4 = new Sketch("Boredom", 5, 5, "Haiti Isla");
            inventory.add(s4);
            System.out.println("\n" + "A sketch has been added.");
        } else if (typeNum == 3) {
            Photograph f4 = new Photograph("Folly", 11, 15, "Aims Sey");
            inventory.add(f4);
            System.out.println("\n" + "A photograph has been added.");
        }
    }
    public static void inventory2() {
        // view inventory
        System.out.println("\n" + "Available paintings:" + Painting.getAvailablePaintings());
        System.out.println("Available sketches:" + Sketch.getAvailableSketches());
        System.out.println("Available photographs:" + Photograph.getAvailablePhotos());
        System.out.println("Total available products:" + (Painting.getAvailablePaintings() + Sketch.getAvailableSketches() + Photograph.getAvailablePhotos()));
    }
    public static void inventory3() {
        // modify available inventory
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "What would you like to remove from inventory?");
        System.out.println("Painting: 1\nSketch: 2\nPhotograph: 3");
        int typeNum = input.nextInt();
        if (typeNum == 1) {
            inventory.remove(0);
            System.out.println("\n" + "A painting has been removed.");
            Painting.setAvailablePainting(false);
        } else if (typeNum == 2) {
            inventory.remove(3);
            System.out.println("\n" + "A sketch has been removed.");
            Sketch.setAvailableSketches(false);
        } else if (typeNum == 3) {
            inventory.remove(6);
            System.out.println("\n" + "A photograph has been removed.");
            Photograph.setAvailablePhotos(false);
        } 
    }
    public static void sales1() {
        // view products, info and pricing
        for(int i = 0; i < inventory.size(); i++) {
            System.out.println("\n" + (i + 1) + ".");
            System.out.println(inventory.get(i).toString());
        }
    }
    public static void sales2() {
        // buy a product
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "Please view the list of products and enter the corresponding number, 1-" + inventory.size() + ":");
        int index = input.nextInt() - 1;
        System.out.println("You have successfully bought the piece \"" + inventory.get(index).getTitle() + "\"");
        String name = inventory.get(index).getClass().getSimpleName();
        if (name.equals("Painting")) {
            Painting.setAvailablePainting(false);
        } else if (name.equals("Sketch")) {
            Sketch.setAvailableSketches(false);
        } else if (name.equals("Photograph")) {
            Photograph.setAvailablePhotos(false);
        }
        inventory.remove(index);
    }
    public static void sales3() {
        // return a product
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "What is the type of product you are returning?");
        System.out.println("Painting: 1\nSketch: 2\nPhotograph: 3");
        int typeNum = input.nextInt();
        input.nextLine();
        System.out.println("What is the title?");
        String title = input.nextLine();
        System.out.println("Who is the artist/photographer?");
        String artist = input.nextLine();
        System.out.println("What is the length?");
        double length = input.nextDouble();
        System.out.println("What is the width?");
        double width = input.nextDouble();
        if (typeNum == 1) {
            Painting p5 = new Painting(title, length, width, artist);
            inventory.add(p5);
        } else if (typeNum == 2) {
            Sketch s5 = new Sketch(title, length, width, artist);
            inventory.add(s5);
        } else if (typeNum == 3) {
            Photograph f5 = new Photograph(title, length, width, artist);
            inventory.add(f5);
        }
        System.out.println("\n" + "The product has been successfully returned.");
    }
}
