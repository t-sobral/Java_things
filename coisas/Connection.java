import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Connection {
    private double jitter;
    private String proposito;
    private static int idCounter = 1;
    private int id;
    private LocalDateTime dateTime;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Connection(double jitter, String proposito, String dateTimeStr) {
        this.jitter = jitter;
        this.proposito = proposito;
        this.id = idCounter++;
        this.dateTime = LocalDateTime.parse(dateTimeStr, formatter);

        if (id >= idCounter) {
            idCounter = id + 1;
        }
    }
    
    public int getId() {
        return id;
    }

    public double getJitter() {
        return jitter;
    }

    public String getProposito() {
        return proposito;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Connection #" + id + " [jitter=" + jitter + ", proposito=" + proposito + ", dateTime=" + dateTime + "]";
    }
}
