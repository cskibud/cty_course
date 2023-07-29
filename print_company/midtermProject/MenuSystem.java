package print_company.midtermProject;
import java.util.Scanner;

public class MenuSystem {
    public static void main(String[] args) {
        boolean backToTop = false;
        do {
            backToTop = false;
            displayTopMenu();
            int choice = readInput();
            if (choice == 1) {
                displayInventorySubMenu();
                choice = readInput();
                if (choice == 1) {
                    addAProduct();
                } else if (choice == 2) {
                    viewInventory();
                } else if (choice == 3) {
                    backToTop = true;
                }
            } else if (choice == 2) {
                displaySalesSubMenu();
                choice = readInput();
                if (choice == 1) {
                    viewProducts();
                } else if (choice == 2) {
                    purchaseProducts();
                } else if (choice == 3) {
                    backToTop = true;
                }
            } 
        } while (backToTop);
    }

    public static int readInput() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.nextLine();
        return num;
    }

    public static void displayTopMenu() {
        System.out.println("\n");
        System.out.println("Enter the corresponding numbers to access the following actions:");
        System.out.println("1 - Inventory Actions");
        System.out.println("2 - Sales Actions");
        System.out.println("3 - Exit");
    }

    public static void displayInventorySubMenu() {
        System.out.println("\n");
        System.out.println("Inventory Actions");
        System.out.println("Enter the corresponding numbers to access the following actions:");
        System.out.println("1 - Add a product");
        System.out.println("2 - View inventory");
        System.out.println("3 - Go back to previous menu");
    }

    public static void displaySalesSubMenu() {
        System.out.println("\n");
        System.out.println("Sales Actions");
        System.out.println("Enter the corresponding numbers to access the following actions:");
        System.out.println("1 - View products");
        System.out.println("2 - Purchase a product");
        System.out.println("3 - Go back to previous menu");
    }

    // placeholder methods
    public static void addAProduct() {
        System.out.println("*Asks which product, how many, adds product*");
    }
    public static void viewInventory() {
        System.out.println("*Displays inventory*");
    }
    public static void viewProducts() {
        System.out.println("*Displays products*");
    }
    public static void purchaseProducts() {
        System.out.println("*Asks confirmation, proceeds to checkout*");
    }
}
