package advanced_java.unit2;
import java.util.*;

public class Employee {
    private String jobTitle;
    private String fullName;
    private Date hireDate;

    public Employee() {
        this.jobTitle = "";
        this.fullName = "";
        this.hireDate = new Date(0, 0, 0);
    }
    public Employee(String jobTitle, String fullName, Date hireDate) {
        this.jobTitle = jobTitle;
        this.fullName = fullName;
        this.hireDate = hireDate;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getJobTitle() {
        return this.jobTitle;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getFullName() {
        return this.fullName;
    }
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    public Date getTitle() {
        return this.hireDate;
    }
    public String paycheckGross() {
        String str ="Unable to calculate paycheck for base Employee.";
        return str;
    }
    public String toString() {
        String str = fullName + " - " + jobTitle;
        return str;
    }
}
