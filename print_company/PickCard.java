package print_company;
import java.util.Scanner;

public class PickCard {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your card...");
        System.out.println("\n");
        System.out.println("1 = Ace");
        System.out.println("2 = 2");
        System.out.println("3 = 3");
        System.out.println("4 = 4");
        System.out.println("5 = 5");
        System.out.println("6 = 6");
        System.out.println("7 = 7");
        System.out.println("8 = 8");
        System.out.println("9 = 9");
        System.out.println("10 = 10");
        System.out.println("11 = Jack");
        System.out.println("12 = Queen");
        System.out.println("13 = King");
        System.out.println("\n");
        System.out.println("Please pick a rank from the list (type the corresponding number):");
        int rankNumber = input.nextInt();
        input.nextLine();
        System.out.println("\n");
        System.out.println("1 = Clubs");
        System.out.println("2 = Diamonds");
        System.out.println("3 = Hearts");
        System.out.println("4 = Spades");
        System.out.println("\n");
        System.out.println("Please pick a suit from the list (type the corresponding number):");
        int suitNumber = input.nextInt();

        String rank;
        switch(rankNumber) {
            case 1:
                rank = "Ace";
                break;
            case 2:
                rank = "2";
                break;
            case 3:
                rank = "3";
                break;
            case 4:
                rank = "4";
                break;
            case 5:
                rank = "5";
                break;
            case 6:
                rank = "6";
                break;
            case 7:
                rank = "7";
                break;
            case 8:
                rank = "8";
                break;
            case 9:
                rank = "9";
                break;
            case 10:
                rank = "10";
                break;
            case 11:
                rank = "Jack";
                break;
            case 12:
                rank = "Queen";
                break;
            case 13:
                rank = "King";
                break;
            default:
                return;
        }
        String suit;
        switch(suitNumber) {
            case 1:
                suit = "Clubs";
                break;
            case 2:
                suit = "Diamonds";
                break;
            case 3:
                suit = "Hearts";
                break;
            case 4:
                suit = "Spades";
                break;
            default:
                return;
        }
        System.out.println("\n");
        System.out.println("The card you picked is: --> " + rank + " of " + suit);
    }
}
