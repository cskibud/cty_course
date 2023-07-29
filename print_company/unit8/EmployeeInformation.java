package print_company.unit8;
import java.util.Scanner;
import java.util.Arrays;

public class EmployeeInformation {
    public static void main(String[] args) {
        System.out.println("You will be prompted to enter data about the employees, including their employee ID and whether they have a set salary, or are paid hourly");
        System.out.println("\n");
        // findEmployeeAmount
        // create array with all employee ids
        // sort array
        int[] sortedArray = sortArray(collectEmployeeId(findEmployeeAmount()));
        // print
        System.out.println("\n");
        System.out.println("Employee IDs in order:");
        printArray(sortedArray);
        // create two dimesional array
        // add id and pay type
        splitTwoDimensionalArray(findPayType(sortedArray)); 
        // print by pay type
    }
    public static int findEmployeeAmount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the total number of employees to be entered: ");
        int employeeAmount = input.nextInt();
        input.nextLine();
        return employeeAmount;
    }
    public static int[] collectEmployeeId(int employeeAmount) {
        Scanner input = new Scanner(System.in);
        int[] unsortedIdArray = new int[employeeAmount];
        System.out.println("Please enter the " + employeeAmount + " six digit employee IDs:");
        for (int i = 0; i < employeeAmount; i++) {
            int employeeId = input.nextInt();
            unsortedIdArray[i] = employeeId;
            System.out.println("Employee IDs left: " + (employeeAmount - (i + 1)));
        }
        return unsortedIdArray;
    }
    public static int[] sortArray(int[] unsortedIdArray) {
        Arrays.sort(unsortedIdArray);
        return unsortedIdArray;
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) continue;
            System.out.println(array[i]);
        }
    }
    public static int[][] findPayType(int[] sortedArray) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Please enter the corresponding number for the pay type for each employee:");
        System.out.println("1. Set Salary");
        System.out.println("2. Paid Hourly");
        int[][] idAndPayTypeArray = new int[sortedArray.length][2];
        for (int i = 0; i < idAndPayTypeArray.length; i++) {
            System.out.println("Employee with ID " + sortedArray[i] + " pay type:");
            int payType = input.nextInt();
            input.nextLine();
            idAndPayTypeArray[i][0] = sortedArray[i];
            idAndPayTypeArray[i][1] = payType;
        }
        return idAndPayTypeArray;
    }
    public static void splitTwoDimensionalArray(int[][] idAndPayTypeArray) {
        int[] setSalaryIds = new int[idAndPayTypeArray.length];
        int[] paidHourlyIds = new int[idAndPayTypeArray.length];
        int salaryIndex = 0;
        int hourlyIndex = 0;
		for (int i = 0; i < idAndPayTypeArray.length; i++) {
            if (idAndPayTypeArray[i][1] == 1) {
                setSalaryIds[salaryIndex++] = idAndPayTypeArray[i][0];
            } else {
                paidHourlyIds[hourlyIndex++] = idAndPayTypeArray[i][0];
            }
		}
        System.out.println();
        System.out.println("Salaried worker IDs are:");
        printArray(setSalaryIds);
        System.out.println();
        System.out.println("Hourly worker IDs are:");
        printArray(paidHourlyIds);
	}
}
