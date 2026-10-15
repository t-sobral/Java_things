import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private static int starter = 1;
    private int ID;
    private double transactionValue;
    private String paisDestino;
    private LocalDateTime time;
    private static DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");



    public Transaction(double transactionValue, String paisDestino, String time){
        this.transactionValue = transactionValue;
        this.paisDestino = paisDestino;
        this.time = LocalDateTime.parse(time.trim(),formater);
        this.ID = starter++;
    }

    public int getID() {
        return ID;
    }

    public double getTransactionValue() {
        return transactionValue;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getTimeRight(){
        return time.format(formater);
    }


    @Override
    public String toString() {
        return "Transaction | ID: " + ID + ", Transaction Value: " + transactionValue + ", Pais Destino: " + paisDestino
                + ", time" + time.format(formater);
    }


    
    







}
