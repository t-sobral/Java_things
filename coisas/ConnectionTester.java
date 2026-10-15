public class ConnectionTester {
    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager();

        // ----------------------------------------------------------
        Connection c1 = new Connection(1.0, "www", "2025-05-25 16:30");
        Connection c2 = new Connection(4.9, "gaming", "2025-05-24 05:00");
        cm.addConnection(c1);
        cm.addConnection(c2);
        // ----------------------------------------------------------

        cm.printAllConnections();

        // ----------------------------------------------------------
        System.out.println(cm.getConnection(1));
        System.out.println(cm.assessQuality(1));
        System.out.println(cm.getConnection(2));
        System.out.println(cm.assessQuality(2));
        System.out.println(cm.getConnection(30));  // não existe!
        System.out.println(cm.assessQuality(30));  // não existe!
        // ----------------------------------------------------------

        System.out.println("---------------");
        cm.sortConnectionsByQuality();
        System.out.println("---------------");

        // ----------------------------------------------------------
        cm.readFile("Connections.txt");
        cm.printAllConnections();

        // ----------------------------------------------------------
        System.out.println(cm.getConnection(1));
        System.out.println(cm.assessQuality(1));
        System.out.println(cm.getConnection(2));
        System.out.println(cm.assessQuality(2));
        System.out.println(cm.getConnection(30));
        System.out.println(cm.assessQuality(30));
        // ----------------------------------------------------------

        cm.writeFile("result.txt");

        // ----------------------------------------------------------

        System.out.println("---------------");
        cm.sortConnectionsByQuality();
        System.out.println("---------------");

        // ----------------------------------------------------------

    }
}
