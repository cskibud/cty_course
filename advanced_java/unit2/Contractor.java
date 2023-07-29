package advanced_java.unit2;
import java.util.*;
import java.text.*;

public class Contractor extends HourlyEmployee{
    private Date contractStart;
    private Date contractEnd;
    private String company;
    public Contractor() {
        super();
        this.contractStart = new Date(0, 0, 0);
        this.contractEnd = new Date(0, 0, 0);
        this.company = "";
    }
    public Contractor(String jobTitle, String fullName, Date hireDate, double hourlyRate, int hoursPerWeek, Date contractStart, Date  contractEnd, String company) {
        super(jobTitle, fullName, hireDate, hourlyRate, hoursPerWeek);
        this.contractStart = contractStart;
        this.contractEnd = contractEnd;
        this.company = company;
    }
    public String paycheckGross() {
        DecimalFormat decFormat = new DecimalFormat("$#,###.00");
        double paycheck = this.hourlyRate * 80;
        return decFormat.format(paycheck);
    }
    public String toString() {
        String str = getFullName() + " - " + getJobTitle() + ", Contractor with " + this.company + ". Last paycheck: " + paycheckGross();
        return str;
    }
}
