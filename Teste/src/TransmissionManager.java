import java.io.*;
import java.util.*;

public class TransmissionManager {
    private static HashMap<Integer, Transmission> transmissoes = new HashMap<>();

    public void addTransmission(Transmission t){
        int id = t.getID();
        transmissoes.put(id, t);
    }

    public void removeTransmission(int id){
        transmissoes.remove(id);
    }

    public Transmission getTransmission(int id){
        if(transmissoes.containsKey(id)){
            return transmissoes.get(id);
        }
        return null;
    }

    public int calculateBuffer(int id){
        StandardTransmissionBufferCalculator calculator = new StandardTransmissionBufferCalculator();
        Transmission t1 = transmissoes.get(id);
        
        if(transmissoes.containsValue(t1)){
            return calculator.calculateBuffer(t1);
        }
        
        return -1;
    }

    public void printAllTransmissions(){
        for(int i : transmissoes.keySet()){
            System.out.println(transmissoes.get(i));
        }
    }

    public void sortTransmissionsBySize(){
    
        Comparator<Transmission> buffer = Comparator.comparingDouble(
            (Transmission p) -> mib(p));
    Comparator<Transmission> duration = Comparator.comparingDouble(
            (Transmission p) -> (double)p.getDuraçao());

        transmissoes.values()  
            .stream()
            .sorted(buffer.reversed().thenComparing(duration.reversed()))
            .forEach(System.out::println);
            
        };
        
        

    public void readFile(String fich) throws FileNotFoundException{
        transmissoes.clear();
        Scanner sc = new Scanner(new File(fich));
        sc.nextLine();
        
        while(sc.hasNext()){
            String data = sc.nextLine();
            String[] parts = data.trim().split(";");

            int id = Integer.parseInt(parts[0].trim());
            double duraçao = Double.parseDouble(parts[1].trim());
            int Bitrate = Integer.parseInt(parts[2].trim());
            String dataHora = parts[3].trim();

            Transmission t1 = new Transmission(id,duraçao, Bitrate, dataHora);
            transmissoes.put(id, t1);
        }
        sc.close();
    }


    public void writeFile(String fich) throws IOException{
        
        BufferedWriter escritor = new BufferedWriter(new FileWriter(fich));
        escritor.write("ID; Data e hora; tamanho do buffer; bitrate\n");
        
        for(int i : transmissoes.keySet()){
            int buffer = calculateBuffer(i);
            Transmission t1 = transmissoes.get(i);
            escritor.write(t1.getID() + ";" + t1.getHrInicio() + ";" + buffer + ";" + t1.getBitrate() + "\n");
        }
        escritor.close();
    }







    private double mib(Transmission t){
        if(transmissoes.containsValue(t)){
            double duraçao = t.getDuraçao();
             int Bitrate = t.getBitrate();
            double mib = (duraçao * Bitrate)/8192;
            return mib;
        }
        return -1;}
}
