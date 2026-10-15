import java.time.LocalDateTime;

public class StandarTransactionThreatCalculator implements ITransactionThreatCalculator{
    
    public double assessThreat(Transaction t){
        double ameaça = (t.getTransactionValue() * 25)/500;
        LocalDateTime t1 = t.getTime();
        int hour  = t1.getHour();

        if(t.getPaisDestino().equalsIgnoreCase("Nigeria")){
            ameaça += ameaça * 0.75;
        }

        if((hour >= 2) && (hour <= 6) || isWeekend(t1)){
            ameaça *= 2;
        }

        return truncating(ameaça);

    }

    private boolean isWeekend(LocalDateTime f){
        switch(f.getDayOfWeek()){
            case SATURDAY:
                return true;
            
            case SUNDAY:
                return true;
            
            default:
                return false;

        }
        
    }

    private double truncating(double f){
        if(f < 0){
            return 0;
        }
        else if (f > 100){
            return 100;
        }
        else
            return f;
    }
}
