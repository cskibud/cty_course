package print_company.unit11;

public class Manager {
    private String firstName;
    private String lastName;
    private String fullName;
    private int branchId;
    
    public static int activeManagers = 0;
    public Manager() {

    }
    public Manager(String firstName, String lastName, int branchId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.branchId = branchId;
        activeManagers++;
    }
    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
    public int getBranchId() {
        return this.branchId;
    }
    public String toString() {
        String string = "\n" + "Supervisor Information" + "\n" + "First Name: " + firstName + "\n" +
        "Last Name: " + lastName + "\n" + 
        "Full Name: " + fullName + "\n" + 
        "Branch ID: " + branchId;
        return string;
    }
}
