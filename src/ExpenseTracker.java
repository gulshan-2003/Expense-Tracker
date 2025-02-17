import java.util.*;

public class ExpenseTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ExpenseManager manager = new ExpenseManager();

        while (true){
            System.out.println("\nExpense Tracker Menu: ");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expense");
            System.out.println("3. Exit");
            System.out.println("Choose an Option: ");


            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter the Amount: ");
                    double amount = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.println("Enter Description: ");
                    String description = sc.nextLine();

                    Expense expense = new Expense(amount,category,description);
                    manager.addExpense(expense);
                    System.out.println("Expense added successfully!");
                    break;

                case  2:
                    manager.displayExpenses();
                    break;

                case 3:
                    System.out.println("Exiting... Have a GREAT DAY!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice. Please try again.");
            }
        }
    }
}
