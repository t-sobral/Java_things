import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class Read {
 private static HashMap<String,ArrayList<Float>> datas = new HashMap<>();
    private static HashMap<Things,Float> valores = new HashMap<>();
    
    public HashMap<String,ArrayList<Float>> dataGather(String f) throws FileNotFoundException{//este conta coluna a coluna
        Scanner sc = new Scanner(new File(f));
        sc.nextLine();
        
        while(sc.hasNextLine()){
            String data = sc.nextLine();
            String[] parts = data.split(",");
            
            ArrayList<Float> coisas = new ArrayList<>(); 
            
            String date = parts[0];
            Float Food = Float.parseFloat(parts[1]);
            Float Transportation = Float.parseFloat(parts[2]);
            Float Leisure = Float.parseFloat(parts[3]);
            
            coisas.add(Food);
            coisas.add(Transportation);
            coisas.add(Leisure);

            datas.put(date, coisas);
            
        }
        sc.close();
        return datas;

    }

    public void somaDiaria(HashMap<String,ArrayList<Float>> t, String g){ //vai buscar ao hasmap o dia que tem de input (g) e calcula
        ArrayList<Float> testar = t.get(g);
        float soma = 0.0f;
        for(Float i : testar){
            soma+=i;
        }
        System.out.println("Date: "+ g + "->" + soma);
    }

    public HashMap<Things,Float> custoTotal(HashMap<String,ArrayList<Float>> t){
        Float custoFood = 0.0f;
        Float custoTrans = 0.0f;
        Float custoLeisure = 0.0f;
    
        for (String i : t.keySet()){
            ArrayList<Float> testar = t.get(i);
            custoFood += testar.get(0);
            custoTrans += testar.get(1);
            custoLeisure += testar.get(2);
        }

        addAll(valores,custoFood, custoTrans, custoLeisure);
        return valores;
    }
    
    private void addAll(HashMap<Things,Float> j, float f,float t, float l){
        j.put(Things.FOOD, f);
        j.put(Things.TRANSPORT, t);
        j.put(Things.LEISURE, l);
    }
}

