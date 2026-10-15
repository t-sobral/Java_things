
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Expense {
    private static int inicializor = 1;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private String category;
    private double expense;
    private LocalDateTime date;
    private int ID;


    public Expense(String category, double expense,LocalDateTime time ){
        this.category = category;
        this.expense = expense;
        this.date = time;
        this.ID = inicializor++;
    }

    public String getCategory() {
        return category;
    }

    public double getExpense() {
        return expense;
    }

    public String getDate() {
        return date.format(formatter);
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Expense | ID: " + ID + "; Category: " + category + ", expense: " + expense + ", date: " + getDate() + "|";
    }

    

}
