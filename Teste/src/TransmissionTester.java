
import java.io.IOException;

public class TransmissionTester {
    public static void main(String[] args) throws IOException {
        TransmissionManager tm = new TransmissionManager();

        // ----------------------------------------------------------
        Transmission t1 = new Transmission(15.0, 1500, "2025-05-25 16:30");
        Transmission t2 = new Transmission(7.5, 3000, "2025-05-24 05:00");
        tm.addTransmission(t1);
        tm.addTransmission(t2);
        // ----------------------------------------------------------

        tm.printAllTransmissions();

        // ----------------------------------------------------------
        System.out.println(tm.getTransmission(1));
        System.out.println(tm.calculateBuffer(1));
        System.out.println(tm.getTransmission(2));
        System.out.println(tm.calculateBuffer(2));
        System.out.println(tm.getTransmission(30));  // não existe!
        System.out.println(tm.calculateBuffer(30));  // não existe!
        // ----------------------------------------------------------

        System.out.println("---------------");
        tm.sortTransmissionsBySize();
        System.out.println("---------------");

        // ----------------------------------------------------------
        tm.readFile("Transmissions.txt");
        tm.printAllTransmissions();

        // ----------------------------------------------------------
        System.out.println(tm.getTransmission(1));
        System.out.println(tm.calculateBuffer(1));
        System.out.println(tm.getTransmission(2));
        System.out.println(tm.calculateBuffer(2));
        System.out.println(tm.getTransmission(30));
        System.out.println(tm.calculateBuffer(30));
        // ----------------------------------------------------------

        tm.writeFile("result.txt");

        // ----------------------------------------------------------

        System.out.println("---------------");
        tm.sortTransmissionsBySize();
        System.out.println("---------------");

        // ----------------------------------------------------------

    }
}
