import java.io.IOException;

public class TransactionTester {
    public static void main(String[] args) throws IOException {
        TransactionManager tm = new TransactionManager();

        // ----------------------------------------------------------
        Transaction t1 = new Transaction(75.0, "Portugal", "2025-05-25 16:30");
        Transaction t2 = new Transaction(500.0, "Nigeria", "2025-05-24 05:00");
        tm.addTransaction(t1);
        tm.addTransaction(t2);
        // ----------------------------------------------------------

        tm.printAllTransactions();

        // ----------------------------------------------------------
        System.out.println(tm.getTransaction(1));
        System.out.println(tm.assessThreat(1));
        System.out.println(tm.getTransaction(2));
        System.out.println(tm.assessThreat(2));
        System.out.println(tm.getTransaction(30));  // não existe!
        System.out.println(tm.assessThreat(30));    // não existe!
        // ----------------------------------------------------------

        System.out.println("---------------");
        tm.sortTransactionsByThreat();
        System.out.println("---------------");

        // ----------------------------------------------------------
        tm.readFile("Transactions.txt");
        tm.printAllTransactions();

        // ----------------------------------------------------------
        System.out.println(tm.getTransaction(1));
        System.out.println(tm.assessThreat(1));
        System.out.println(tm.getTransaction(2));
        System.out.println(tm.assessThreat(2));
        System.out.println(tm.getTransaction(30));
        System.out.println(tm.assessThreat(30));
        // ----------------------------------------------------------

        tm.writeFile("result.txt");

        // ----------------------------------------------------------

        System.out.println("---------------");
        tm.sortTransactionsByThreat();
        System.out.println("---------------");

        // ----------------------------------------------------------

    }
}
