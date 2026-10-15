import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class ConnectionManager {
    private List<Connection> connections;
    private IConnectionQualityCalculator qualityCalculator;

    public ConnectionManager() {
        this.connections = new ArrayList<>();
        this.qualityCalculator = new StandardConnectionQualityCalculator();
    }

    public void addConnection(Connection c){
        connections.add(c);
    }

    public boolean removeConnection(int id){
        Connection c = getConnection(id);
        if (c != null){
            return connections.remove(c);
        }
        return false;
    }

    public Connection getConnection(int id){
        for (Connection c : connections) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public double assessQuality(int id){
        Connection c = getConnection(id);
        if (c == null){
            return -1;
        }
        return qualityCalculator.assessQuality(c);
    }

    public void printAllConnections(){
        for (Connection c : connections) {
            System.out.println(c);
        }
    }

    public void sortConnectionsByQuality(){
        connections.sort(new Comparator<Connection>() {
            @Override
            public int compare(Connection c1, Connection c2) {
                double q1 = qualityCalculator.assessQuality(c1);
                double q2 = qualityCalculator.assessQuality(c2);
                int compQualidade = Double.compare(q2, q1);

                if (compQualidade != 0) {
                    return compQualidade;
                }
                return c2.getDateTime().compareTo(c1.getDateTime());
            }
        });
        printAllConnections();
    }

    public void readFile(String fich){
        try {
            File file = new File(fich);
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine().trim();
                if (linha.isEmpty()) continue;

                String[] partes = linha.split(";");
                
                if (partes.length >= 3) {
                    int id = Integer.parseInt(partes[0].trim());
                    double jitter = Double.parseDouble(partes[1].trim());
                    String proposito = partes[2].trim();
                    
                    String timestamp = "";
                    if (partes.length == 4) {
                        timestamp = partes[3].trim();
                    }
                    
                    Connection c = new Connection( jitter, proposito, timestamp);
                    this.addConnection(c);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: O ficheiro " + fich + " não foi encontrado.");
        } catch (Exception e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        }
    }

    public void writeFile(String fich){
        try {
            PrintWriter writer = new PrintWriter(new File(fich));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            
            writer.println("ID; Data e Hora; Proposito; Jitter; QoE");
            
            for (Connection c : connections) {
                writer.println(c.getId() + "; " + c.getDateTime().format(formatter) + "; " + c.getProposito() + "; " + c.getJitter() + "; " + this.assessQuality(c.getId()));
            }
            
            writer.close();
            System.out.println("Ficheiro " + fich + " gravado com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao criar o ficheiro para escrita: " + e.getMessage());
        }
    }
    
}

