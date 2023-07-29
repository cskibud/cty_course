package advanced_java.unit2;
import java.util.*;
import java.text.*;

public class HourlyEmployee extends Employee{
    protected double hourlyRate;
    protected int hoursPerWeek;
    public HourlyEmployee() {
        super();
        this.hourlyRate = 0;
        this.hoursPerWeek = 0;
    }
    public HourlyEmployee(String jobTitle, String fullName, Date hireDate, double hourlyRate, int hoursPerWeek) {
        super(jobTitle, fullName, hireDate);
        this.hourlyRate = hourlyRate;
        this.hoursPerWeek = hoursPerWeek;
    }
    public String paycheckGross() {
        DecimalFormat decFormat = new DecimalFormat("$#,###.00");
        double paycheck = this.hourlyRate * this.hoursPerWeek;
        return decFormat.format(paycheck);
    }
    public String toString() {
        String str = super.toString() + ", Hourly Employee. Last paycheck: " + paycheckGross();
        return str;
    }
}
