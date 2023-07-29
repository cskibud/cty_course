package advanced_java.unit2;
import java.util.*;
import java.text.*;

public class SalariedEmployee extends Employee{
    private double salary;
    private double bonus;
    public SalariedEmployee() {
        super();
        this.salary = 0;
        this.bonus = 0;
    }
    public SalariedEmployee(String jobTitle, String fullName, Date hireDate, double salary, double bonus) {
        super(jobTitle, fullName, hireDate);
        this.salary = salary;
        this.bonus = bonus;
    }
    public String paycheckGross() {
        DecimalFormat decFormat = new DecimalFormat("$#,###.00");
        double paycheck = this.salary / 26;
        return decFormat.format(paycheck);
    }
    public String toString() {
        String str = super.toString() + ", Salaried Employee. Last paycheck: " + paycheckGross();
        return str;
    }
}
