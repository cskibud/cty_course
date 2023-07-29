package print_company.unit11;

public class Date {
    private int month;
    private int day;
    private int year;
    public Date(int month, int day, int year) {
        setDate(month, day, year);
    }
    public void setDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }
    public String toString() {
        String date = month + "/" + day + "/" + year;
        return date;
    }
}
