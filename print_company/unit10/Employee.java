package print_company.unit10;
import java.util.Date;

public class Employee {
    private String firstName;
    private String lastName;
    private String fullName;
    private print_company.unit10.Date hireDate;
    private Date terminationDate;
    private int vacationDaysLeft;
    private int vacationDaysScheduled;
    private String lastReview;
    public Employee(String firstNameInput, String lastNameInput, print_company.unit10.Date hireDateInput, int vacationDaysLeftInput, String lastReviewInput) {
        firstName = firstNameInput;
        lastName = lastNameInput;
        fullName = firstName + " " + lastName;
        hireDate = hireDateInput;
        vacationDaysLeft = vacationDaysLeftInput;
        vacationDaysScheduled = 0;
        lastReview = lastReviewInput;
    }
    public void setVacationDaysLeft(int vacationDaysLeft) {
        this.vacationDaysLeft = vacationDaysLeft;
    }
    public int getVacationDaysLeft() {
        return this.vacationDaysLeft;
    }
    public void setLastReview(String lastReview) {
        this.lastReview = lastReview;
    }
    public String getLastReview() {
        return this.lastReview;
    }
    public boolean scheduleVacationDay(int daysScheduled) {
        int difference = vacationDaysLeft - daysScheduled;
        if (difference < 0) return false;
        vacationDaysLeft = difference;
        vacationDaysScheduled += daysScheduled;
        return true;
    }
    public boolean cancelVacationDay(int daysCanceled) {
        int difference = vacationDaysScheduled - daysCanceled;
        if (difference < 0) return false;
        vacationDaysScheduled = difference;
        vacationDaysLeft += daysCanceled;
        return true;
    }
    public void terminateEmployee() {
        Date today = new Date();
        int month = today.getMonth();
        int day = today.getDate();
        int year = today.getYear() + 1900;
        terminationDate = new Date(month, day, year);
    }
    public String toString() {
        String string = "\n" + "Employee Information" + "\n" + "First Name: " + firstName + "\n" +
        "Last Name: " + lastName + "\n" + 
        "Full Name: " + fullName + "\n" + 
        "Date of Hire: " + hireDate + "\n" + 
        "Date of Termination: " + terminationDate + "\n" + 
        "Vacation Days Left: " + vacationDaysLeft + "\n" + 
        "Vacation Days Scheduled: " + vacationDaysScheduled + "\n" + 
        "Last Review: " + lastReview;
        return string;
    }
}
