package print_company.unit11;
import java.util.*;

public class Branch {
    private int branchId;
    private String locationName;
    private String address;
    Manager supervisor;
    Employee[] team;

    //for the main
    private static Scanner input;
    private static Branch[] branches;
    private static Manager[] managers;
    private static Employee[] employees;

    public Branch() {
    }
    public Branch(int branchId, String locationName, String address, Manager supervisor, Employee[] team) {
        this.branchId = branchId;
        this.locationName = locationName;
        this.address = address;
        this.supervisor = supervisor;
        this.team = team.clone();
    }
    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
    public int getBranchId() {
        return this.branchId;
    }
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    public String getLocationName() {
        return this.locationName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }
    public void setSupervisor(Manager supervisor) {
        this.supervisor = supervisor;
    }
    public Manager getSupervisor() {
        return this.supervisor;
    }
    public void setTeam(Employee[] team) {
        this.team = team.clone();
    }
    public Employee[] getTeam() {
        return this.team;
    }
    public void addToTeam(Employee employee) {
        List<Employee> list = Arrays.asList(this.team);
        List<Employee> arraylist = new ArrayList<>(list);
        arraylist.add(employee);
        Employee[] array = new Employee[arraylist.size()];
        this.team = arraylist.toArray(array);
    }
    public void removeFromTeam(Employee employee) {
        int indexToRemove = -1;
        for(int i = 0; i < this.team.length; i++) {
            if (this.team[i].equal(employee)) {
                indexToRemove = i;
                break;
            }
        }
        List<Employee> list = Arrays.asList(this.team);
        list.remove(indexToRemove);
        this.team = (Employee[]) list.toArray();
    }
    public void removeLastEmployee() {
        List<Employee> list = Arrays.asList(this.team);
        list.remove(this.team.length - 1);
        this.team = (Employee[]) list.toArray();
    }
    public void displayBranchInfo() {
        System.out.println(this.supervisor);
        System.out.println("\n" + "Team Information");
        for(int i = 0; i < this.team.length; i++) {
            System.out.println("Employee #" + (i + 1));
            System.out.println(this.team[i]);
            System.out.println("\n");
        }
        System.out.println("The total number of employees on the team is " + (this.team.length) + ".");
    }
    public static void main(String[] args) {
        input = new Scanner(System.in);
        initiateCompany();
        boolean keepGoing = true;
        while (keepGoing) {
            keepGoing = handleMenu();
        }
    }

    private static void initiateCompany() {
        Employee e1 = new Employee(
            1111, 
            "Bob", 
            "Builder", 
            new Date(6, 5, 2001), 
            10, 
            "Good job!"
        );
        Employee e2 = new Employee(
            2222, 
            "Leo", 
            "Narda", 
            new Date(12, 18, 2015), 
            10, 
            "Tqm"
        );
        Employee e3 = new Employee(
            3333, 
            "Bob", 
            "Builder", 
            new Date(6, 5, 2001), 
            10, 
            "Good job!"
        );
        Employee e4 = new Employee(
            4444, 
            "Kat", 
            "Niss", 
            new Date(12, 18, 2015), 
            10, 
            "Good."
        );
        Employee e5 = new Employee(
            55555, 
            "Bob", 
            "Builder", 
            new Date(6, 5, 2001), 
            10, 
            "Good job!"
        );
        Employee e6 = new Employee(
            6666, 
            "Leo", 
            "Narda", 
            new Date(12, 18, 2015), 
            10, 
            "Great!"
        );
        Employee e7 = new Employee(
            7777, 
            "Bob", 
            "Builder", 
            new Date(6, 5, 2001), 
            10, 
            "Good job!"
        );
        Employee e8 = new Employee(
            8888, 
            "Pleo", 
            "Narda", 
            new Date(12, 18, 2015), 
            10, 
            "Yes."
        );
        Employee e9 = new Employee(
            9999, 
            "Bob", 
            "Builder", 
            new Date(6, 5, 2001), 
            10, 
            "Good job!"
        );
        Employee e10 = new Employee(
            1212, 
            "Creo", 
            "Narda", 
            new Date(12, 18, 2015), 
            10, 
            "Thanks."
        );
        Manager m1 = new Manager(
            "F", 
            "G", 
            9999
        );
        Manager m2 = new Manager(
            "V", 
            "T", 
            9999
        );
        Manager m3 = new Manager(
            "S", 
            "K", 
            9999
        );
        Branch baltimore = new Branch(
            1000, 
            "Baltimore",
            "1500 Baldwin St", 
            new Manager(), 
            new Employee[] {}
        );
        Branch boston = new Branch(
            2000, 
            "Boston",
            "302 Newbury St", 
            new Manager(), 
            new Employee[] {}
        );
        Branch newYork = new Branch(
            3000, 
            "New York",
            "41 Adams St", 
            new Manager(), 
            new Employee[] {}
        );
        branches = new Branch[3];
        branches[0] = baltimore;
        branches[1] = boston;
        branches[2] = newYork;
        baltimore.addToTeam(e1);
        baltimore.addToTeam(e2);
        baltimore.addToTeam(e3);
        baltimore.addToTeam(e4);
        boston.addToTeam(e5);
        boston.addToTeam(e6);
        boston.addToTeam(e7);
        newYork.addToTeam(e8);
        newYork.addToTeam(e9);
        newYork.addToTeam(e10);
        boston.setSupervisor(m2);
        newYork.setSupervisor(m3);
        managers = new Manager[] {m1, m2, m3};
        employees = new Employee[] {e1, e2, e3, e4, e5, e6, e7, e8, e9, e10};
    }

    private static boolean handleMenu() {
        Branch chosenBranchAdmin = null;
        int mainMenuChoice = getMainMenuChoice();
        if (mainMenuChoice == 1) {
            int branchIdInput = getBranchIdInput();
            for (int i = 0; i < branches.length; i++) {
                if (branches[i].branchId == branchIdInput) {
                    chosenBranchAdmin = branches[i];
                    break;
                } 
            }
            System.out.println("Your next changes will be done on the branch in " + chosenBranchAdmin.locationName);
            int administrationChoice = getAdministrationChoice();
            switch(administrationChoice) {
                case 1: {
                // assign manager to supervisor
                System.out.println("Which manager do you want assign as supervisor?");
                System.out.println("\n");
                System.out.println("Enter 1-3:");
                int managerIndex = input.nextInt();
                Manager m = managers[managerIndex-1];
                m.setBranchId(chosenBranchAdmin.branchId);
                chosenBranchAdmin.setSupervisor(m);
                break; 
            }
                case 2: {
                // Assign an employee to the branch team
                System.out.println("Which manager do you want assign as supervisor?");
                System.out.println("\n");
                System.out.println("Enter 1-10:");
                int employeeIndex = input.nextInt();
                Employee e = employees[employeeIndex-1];
                chosenBranchAdmin.addToTeam(e);
                break;
            }
                case 3: 
                // Remove an employee from the branch team
                chosenBranchAdmin.removeLastEmployee();
                break;
                default:
                break;
            }
        } else if (mainMenuChoice == 2) {
            int reportChoice = getReportChoice();
            switch(reportChoice) {
                case 1:
                Branch chosenBranchReport = null;
                int branchIdInput = getBranchIdInput();
                for (int i = 0; i < branches.length; i++) {
                    if (branches[i].branchId == branchIdInput) {
                        chosenBranchReport = branches[i];
                        break;
                    } 
                }
                chosenBranchReport.displayBranchInfo();
                break;
                case 2:
                for (int i = 0; i < branches.length; i++) {
                    System.out.println("\n");
                    System.out.println(branches[i].locationName + " Branche");
                    branches[i].displayBranchInfo();
                }
                System.out.println("\n");
                System.out.println("The total number of managers is: " + Manager.activeManagers);
                System.out.println("The total number of employees is: " + Employee.getActiveEmployees());
                break;
                default:
                break;
            }
        }
        System.out.println("\n\n-----------------------------------\n1. Return to menu\n2. Exit");
        int continuationChoice = input.nextInt();
        if (continuationChoice == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int getBranchIdInput() {
        boolean retry = false;
        int branchIdInput;
        do {
            retry = false;
            System.out.println("\n");
            System.out.println("Enter a 4-digit branch ID:");
            branchIdInput = input.nextInt();
            if (branchIdInput < 1000 || branchIdInput > 9999) {
                System.out.println("You have entered an invalid branch ID. Please try again.");
                retry = true;
            }
        } while (retry);
        return branchIdInput;
    }
    public static int getMainMenuChoice() {
        System.out.println("\n" + "Enter the number corresponding to the action you would like to perform.");
        System.out.println("1. View administration actions");
        System.out.println("2. View reports");
        int mainMenuChoice = input.nextInt();
        return mainMenuChoice;
    }
    public static int getAdministrationChoice() {
        System.out.println("\n" + "Enter the number corresponding to the action you would like to perform.");
        System.out.println("1. Assign a manager to supervise the branch");
        System.out.println("2. Assign an employee to the branch team");
        System.out.println("3. Remove an employee from the branch team");
        int administrationChoice = input.nextInt();
        return administrationChoice;
    }

    public static int getReportChoice() {
        System.out.println("\n" + "Enter the number corresponding to the action you would like to perform.");
        System.out.println("1. View a report of manager and employees for a specific location");
        System.out.println("2. View a cumulative report of all employees sorted by branch location, including total managers and total number of employees for the company");
        int reportChoice = input.nextInt();
        return reportChoice;
    }
}
