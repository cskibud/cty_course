package advanced_java.unit2;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        int arrLength = getArrayLength();
        Employee array[] = new Employee[arrLength];
        for (int i = 0; i < array.length; i++) {
            int employeeType = getEmployeeType();
            if (employeeType == 1) { 
                array[i] = getHourlyInput();
            } else if (employeeType == 2) {
                array[i] = getSalariedInput();
            } else if (employeeType == 3) {
                array[i] = getContractorInput();
            }
        }
        System.out.println("\n");
        System.out.println("Report:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString());
        }
    }
    public static int getArrayLength() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Employee Management System, how many employees will you be entering?");
        int arrLength = input.nextInt();
        return arrLength;
    }
    public static int getEmployeeType() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Which type of employee are you entering? Enter 1 for Hourly, 2 for Salaried, and 3 for Contractor:");
        int employeeType = input.nextInt();
        return employeeType;
    }
    public static HourlyEmployee getHourlyInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the following information for this Hourly employee.");
        System.out.println("Employee's Name:");
        String fullName = input.nextLine();
        System.out.println("Job Title:");
        String jobTitle = input.nextLine();
        System.out.println("Hired Month:");
        int month = input.nextInt();
        System.out.println("Hired Day:");
        int day = input.nextInt();
        System.out.println("Hired Year:");
        int year = input.nextInt();

        System.out.println("Hourly Rate:");
        double hourlyRate = input.nextDouble();
        System.out.println("Hours Worked:");
        int hoursPerWeek = input.nextInt();

        HourlyEmployee hourlyEmployee = new HourlyEmployee(jobTitle, fullName, new Date(month, day, year), hourlyRate, hoursPerWeek);
        return hourlyEmployee;
    }
    public static SalariedEmployee getSalariedInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the following information for this Salaried employee.");
        System.out.println("Employee's Name:");
        String fullName = input.nextLine();
        System.out.println("Job Title:");
        String jobTitle = input.nextLine();
        System.out.println("Hired Month:");
        int month = input.nextInt();
        System.out.println("Hired Day:");
        int day = input.nextInt();
        System.out.println("Hired Year:");
        int year = input.nextInt();

        System.out.println("Salary:");
        double salary = input.nextDouble();
        System.out.println("Bonus:");
        double bonus = input.nextDouble();

        SalariedEmployee salariedEmployee = new SalariedEmployee(jobTitle, fullName, new Date(month, day, year), salary, bonus);
        return salariedEmployee;
    }
    public static Contractor getContractorInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the following information for this Contractor.");
        System.out.println("Employee's Name:");
        String fullName = input.nextLine();
        System.out.println("Job Title:");
        String jobTitle = input.nextLine();
        System.out.println("Hired Month:");
        int month = input.nextInt();
        System.out.println("Hired Day:");
        int day = input.nextInt();
        System.out.println("Hired Year:");
        int year = input.nextInt();

        System.out.println("Contracted Start Month:");
        int startMonth = input.nextInt();
        System.out.println("Contracted Start Day:");
        int startDay = input.nextInt();
        System.out.println("Contracted Start Year:");
        int startYear = input.nextInt();
        System.out.println("Contracted End Month:");
        int endMonth = input.nextInt();
        System.out.println("Contracted End Day:");
        int endDay = input.nextInt();
        System.out.println("Contracted End Year:");
        int endYear = input.nextInt();

        System.out.println("Hourly Rate:");
        double hourlyRate = input.nextDouble();
        input.nextLine();
        System.out.println("Company:");
        String company = input.nextLine();
        int hoursPerWeek = 80;

        Contractor contractor = new Contractor(jobTitle, fullName, new Date(month, day, year), hourlyRate, hoursPerWeek, new Date(startMonth, startDay, startYear), new Date(endMonth, endDay, endYear), company);
        return contractor;
    }
}
