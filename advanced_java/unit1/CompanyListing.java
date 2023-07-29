package advanced_java.unit1;
import java.util.Scanner;

public class CompanyListing {
    public static void main(String[] args) {
        int arrLength = getArrayLength();
        Company array[] = new Company[arrLength];
        for (int i = 0; i < array.length; i++) {
            System.out.println("\n");
            System.out.println("Please enter information for company " + (i + 1));
            array[i] = getInputs();
        }
        System.out.println("\n");
        System.out.println("Company review: ");
        System.out.println(toString(array));
    }
    public static int getArrayLength() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Competitor Management System, how many companies will you be entering?");
        int arrLength = input.nextInt();
        return arrLength;
    }
    public static Company getInputs() {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the name of the company?");
        String companyName = input.nextLine();
        System.out.println("Who is the CEO?");
        String ceoName = input.nextLine();
        System.out.println("What industry is the company part of?");
        String industry = input.nextLine();
        System.out.println("What type of company is it (public or private)?");
        String type = input.nextLine();
        System.out.println("Does the company sell paintings?");
        String sellsPaintings = input.nextLine();
        System.out.println("Does the company sell sketches?");
        String sellsSketches = input.nextLine();
        System.out.println("Does the company sell photographs?");
        String sellsPhotographs = input.nextLine();
        Company companyInfo = new Company(companyName, industry, type, ceoName, sellsPaintings, sellsSketches, sellsPhotographs);
        return companyInfo;
    }
    public static String toString(Company arr[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i].toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
