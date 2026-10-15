
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transmission {
    private static int inicaializador = 1;
    private double duraçao;
    private int ID;
    private int Bitrate;
    private LocalDateTime hrInicio;
     private static DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    public Transmission(double duraçao, int Bitrate, String dataHora){
        this.duraçao = duraçao;
        this.Bitrate = Bitrate;
        this.hrInicio = LocalDateTime.parse(dataHora,formater);
        this.ID = inicaializador++;
    }

    public Transmission(int id, double duraçao, int Bitrate, String dataHora){
        this.duraçao = duraçao;
        this.Bitrate = Bitrate;
        this.hrInicio = LocalDateTime.parse(dataHora,formater);
        this.ID = id;
    
    }

    public double getDuraçao() {
        return duraçao;
    }

    public int getID() {
        return ID;
    }

    public int getBitrate() {
        return Bitrate;
    }

    public LocalDateTime getHrInicio() {
        return hrInicio;
    }

    @Override
    public String toString() {
        return "Transmission |duraçao: " + duraçao + ", ID: " + ID + ", Bitrate: " + Bitrate + ", hrInicio: " + hrInicio
                + "|";
    }




}
