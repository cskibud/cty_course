package advanced_java.unit4;
import java.util.*;

public class CalculateDriver {
    public static void main(String[] args) {
        initializeProgram();
        Painting painting = initializePainting();
        Sketch sketch = initializeSketch();
        Photograph photograph = initializePhotograph();
        int orderAmount = getOrderAmount();
        Accounting accountingOrders = getOrders(orderAmount, painting, sketch, photograph);
        displaySummaries(accountingOrders);
        // debug
        // System.out.println("++++++++++++++++++++++++++");
        // System.out.println(painting.getPrice());
        // System.out.println(painting.getCost());
        // System.out.println("--------------------------");
        // System.out.println(sketch.getPrice());
        // System.out.println(sketch.getCost());
        // System.out.println("--------------------------");
        // System.out.println(photograph.getPrice());
        // System.out.println(photograph.getCost());
        // System.out.println("++++++++++++++++++++++++++");
        // lala
        displayProfitMargins(painting, sketch, photograph);
    }
    public static void initializeProgram() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the profit and loss calculator");
        System.out.println("Please enter the following information:");
    }
    public static double checkDoubleExeptions(String promptInput) {
        Scanner input = new Scanner(System.in);
        double result = 0;
        boolean retry = true;
        do {
            retry = false;
            System.out.println(promptInput);
            try {
                result = input.nextDouble();
            }
            catch (InputMismatchException e) {
                retry = true;
                input.nextLine();
                System.out.println("Please enter a valid monetary value. Do not include the \"$\" symbol.");
            }
        } while (retry);
        return result;
    }
    public static int checkIntExeptions(String promptInput, int min, int max) {
        Scanner input = new Scanner(System.in);
        int result = 0;
        boolean retry = true;
        do {
            retry = false;
            System.out.println(promptInput);
            try {
                result = input.nextInt();
                if (result < min || result > max) {
                    System.out.println("Please enter a valid integer as prompted.");
                    retry = true;
                }
            }
            catch (InputMismatchException e) {
                retry = true;
                input.nextLine();
                System.out.println("Please enter a valid integer.");
            }
        } while (retry);
        return result;
    }
    public static Painting initializePainting() {
        Scanner input = new Scanner(System.in);
        System.out.println("Configure Paintings:");
        double paintingPrice = checkDoubleExeptions("Selling Price:");
        double paintingCost = checkDoubleExeptions("Cost to Company:");
        Painting painting = new Painting(paintingCost, paintingPrice);
        return painting;
    }
    public static Sketch initializeSketch() {
        Scanner input = new Scanner(System.in);
        System.out.println("Configure Sketches:");
        double sketchPrice = checkDoubleExeptions("Selling Price:");
        double sketchCost = checkDoubleExeptions("Cost to Company:");
        Sketch sketch = new Sketch(sketchCost, sketchPrice);
        return sketch;
    }
    public static Photograph initializePhotograph() {
        Scanner input = new Scanner(System.in);
        System.out.println("Configure Photographs:");
        double photoPrice = checkDoubleExeptions("Selling Price:");
        double photoCost = checkDoubleExeptions("Cost to Company:");
        Photograph photograph = new Photograph(photoCost, photoPrice);
        return photograph;
    }
    public static int getOrderAmount() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("How many orders will you be entering?");
        int orderAmount = input.nextInt();
        return orderAmount;
    }
    public static Accounting getOrders(int orderAmount, Painting painting, Sketch sketch, Photograph photograph) {
        Scanner input = new Scanner(System.in);
        OrderItem[] orderItems = new OrderItem[orderAmount];
        for (int i = 0; i < orderAmount; i++) {
            int orderNumber = i + 1;
            String productTypePrompt = "Order " + orderNumber + " - which product?\nEnter 1 for Painting, 2 for Sketch, 3 for Photograph:";
            int productType = checkIntExeptions(productTypePrompt, 1, 3);
            String quantityPrompt = "Order " + orderNumber + " - quantity?";
            int quantity = checkIntExeptions(quantityPrompt, 1, Integer.MAX_VALUE);
            OrderItem orderItem = null;
            switch(productType) {
                case 1:
                orderItem = new OrderItem(orderNumber, quantity, painting);
                break;
                case 2:
                orderItem = new OrderItem(orderNumber, quantity, sketch);
                break;
                case 3:
                orderItem = new OrderItem(orderNumber, quantity, photograph);
                break;
                default:
                break;
            }
            if (orderItem != null) {
                orderItems[i] = orderItem;
            }
        }
        Order order = new Order(orderItems);
        Order[] orderArray = {order};
        Accounting accountingOrders = new Accounting(orderArray);
        return accountingOrders;
    }
    public static void displaySummaries(Accounting accountingOrders) {
        Order[] orderArray = accountingOrders.getOrders();
        System.out.println("\n");
        System.out.println("Order Summarization: \n*******************************");
        System.out.println(orderArray[0].summarize());
        System.out.println("\n");
        System.out.println("Profit and Loss Calculation: \n*******************************");
        System.out.println(accountingOrders.summarize());
    }
    public static void displayProfitMargins(Painting painting, Sketch sketch, Photograph photograph) {
        System.out.println("\n");
        System.out.println("Profit Margin Calculations: \n*******************************");
        System.out.println("Paintings: " + painting.calculateProfitMargin(painting.getPrice(), painting.getCost()) + "%");
        System.out.println("Sketch: " + sketch.calculateProfitMargin(sketch.getPrice(), sketch.getCost()) + "%");
        System.out.println("Photographs: " + photograph.calculateProfitMargin(photograph.getPrice(), photograph.getCost()) + "%");
    }
}
