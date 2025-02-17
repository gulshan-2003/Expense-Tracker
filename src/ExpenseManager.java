import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private static final String FILE_NAME = "expenses.txt";

    //    Method to add an expense and save to file
    public void addExpense(Expense expense) {
        List<Expense> expenses = getAllExpenses();
        expenses.add(expense);
        saveExpensesToFile(expenses);
    }

    //    Method to retrieve all expenses from file
    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            expenses = (List<Expense>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Ignore if the file does not exist yet
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    //    Method to save expenses to file
    private void saveExpensesToFile(List<Expense> expenses) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(expenses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    Method to display all expenses
    public void displayExpenses() {
        List<Expense> expenses = getAllExpenses();
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        System.out.println("Date   |  Category  |  Amount  |  Description ");
        System.out.println("----------------------------------------------");
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

}


