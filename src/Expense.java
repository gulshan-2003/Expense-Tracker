import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Expense implements Serializable {
    private double amount;
    private String category;
    private String description;
    private String date;

    // constructor

    public Expense(double amount,String category,String description){
        this.amount=amount;
        this.category=category;
        this.description=description;
        this.date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    //Getters


    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getDate(){
        return date;
    }

     @Override
    public String toString() {
        return date + " | " + category + " | " + amount + " | " + description;
    }
}
