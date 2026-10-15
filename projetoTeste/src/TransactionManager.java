import java.util.*;
import java.io.*;

public class TransactionManager {
    private static HashMap<Integer,Transaction> transactionInventory = new HashMap<>();

    public void addTransaction(Transaction t){
        transactionInventory.put(t.getID(), t);
    }

    public void removeTransaction(int id){
        transactionInventory.remove(id);
    }

    public Transaction getTransaction(int id){
        Transaction t1 = transactionInventory.get(id);
        if(t1 == null){
            return null;
        }
        return t1;
    }

    public double assessThreat(int id){
        StandarTransactionThreatCalculator calculator = new StandarTransactionThreatCalculator();

        Transaction t1 = getTransaction(id);
        if(t1 == null){
            return -1;
        }
        
        return calculator.assessThreat(t1); //retorna o incidice

    }

    public void printAllTransactions(){

        for(int i : transactionInventory.keySet()){
            System.out.println(transactionInventory.get(i));
        }
    }

    public void sortTransactionsByThreat(){//wtf was this sort?
    Comparator<Transaction> byThreat = Comparator.comparingDouble(
            (Transaction p) -> assessThreat(p.getID()));
    Comparator<Transaction> byValue = Comparator.comparingDouble(
            (Transaction p) -> (double)p.getTransactionValue());

    transactionInventory.values()  
            .stream()
            .sorted(byThreat.reversed().thenComparing(byValue.reversed()))
            .forEach(System.out::println);

    }

    public void readFile(String f) throws FileNotFoundException{
        transactionInventory.clear();
        Scanner sc = new Scanner(new File(f));
        sc.nextLine();
        
        while (sc.hasNext()){
            String line = sc.nextLine();
            String[] parts = line.split(";");
            int id = Integer.parseInt(parts[0]);
            
            double valorTransaçao = Double.parseDouble(parts[1]);
            String destino = parts[2];
            String timing = parts[3].trim();

            Transaction t1 = new Transaction(valorTransaçao, destino, timing);
            transactionInventory.put(id, t1);

        }
        sc.close();
    }

    public void writeFile(String f) throws IOException{
        BufferedWriter escritor = new BufferedWriter(new FileWriter(f));
        escritor.write("ID; Data e Hora de inicio; País Benificiario; Valor; Indice de ameaça \n");

        for(int i : transactionInventory.keySet()){
            double ameaça = assessThreat(i);
            Transaction t1 = transactionInventory.get(i);
            escritor.write(t1.getID() + "; "  + t1.getTimeRight() + "; " + t1.getPaisDestino() + "; " + t1.getTransactionValue() + ";" + ameaça + "\n");
        }
        escritor.close();
        
    }






}
