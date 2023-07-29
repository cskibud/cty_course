package print_company.unit10;
import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        System.out.println("You will be prompted to enter information on 3 employees.");
        Employee[] employees = new Employee[3];
        for (int i = 0; i < employees.length; i++) {
            System.out.println();
            System.out.println("Please enter information on employee #" + (i + 1));
            System.out.println();
            employees[i] = buildEmployee();
        }
        for (int i = 0; i < employees.length; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("\n");
            System.out.println("How many vacation days would you like to schedule for employee #" + (i + 1) + "?");
            int daysScheduled = input.nextInt();
            employees[i].scheduleVacationDay(daysScheduled);
            System.out.println();
            System.out.println("How many vacation days would you like to cancel for employee #" + (i + 1) + "?");
            int daysCanceled = input.nextInt();
            employees[i].cancelVacationDay(daysCanceled);
            System.out.println();
            System.out.println("Would you like to terminate employee #" + (i + 1) + "?");
            System.out.println("Enter 1 for yes and 2 for no:");
            int terminate = input.nextInt();
            if (terminate == 1) {
                employees[i].terminateEmployee();
            }
            System.out.println();
        }
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        
    }
    public static Employee buildEmployee() {
        // prompt inputs
        Scanner input = new Scanner(System.in);
        System.out.println("Enter their first name: ");
        String firstNameInput = input.nextLine();
        System.out.println();
        System.out.println("Enter their last name: ");
        String lastNameInput = input.nextLine();
        System.out.println();
        System.out.println("Enter the month they were hired as an interger (eg. January = 1, Febuary = 2... December = 12): ");
        int monthHiredInput = input.nextInt();
        System.out.println();
        System.out.println("Enter the day they were hired: ");
        int dayHiredInput = input.nextInt();
        System.out.println();
        System.out.println("Enter the year they were hired: ");
        int yearHiredInput = input.nextInt(); 
        Date hireDateInput = new Date(monthHiredInput, dayHiredInput, yearHiredInput);
        System.out.println();
        System.out.println("Enter the amount of vacation days they have left: ");
        int vacationDaysLeftInput = input.nextInt();
        System.out.println();
        System.out.println("Enter the last review they were given: ");
        input.nextLine();
        String lastReviewInput = input.nextLine();
        System.out.println();
        // build employee
        Employee employee = new Employee(firstNameInput, lastNameInput, hireDateInput, vacationDaysLeftInput, lastReviewInput); 
        return employee;
    }
}
