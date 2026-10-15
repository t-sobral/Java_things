import java.time.LocalDateTime;

public class StandardTransmissionBufferCalculator implements ITransmissionBufferCalculator{

    public int calculateBuffer(Transmission t){
        LocalDateTime t1 = t.getHrInicio();
        if(isWeekend(t1)){
            return 30;
        }
        else if ((t1.getHour() >= 2) &&(t1.getHour() <= 6)){
            return 10; //segundos
        }
        else
            return 15; //segundos

    }

    private boolean isWeekend(LocalDateTime t){
        switch (t.getDayOfWeek()) {
            case SATURDAY:
                return true;
            
            case SUNDAY:
                return true;

            default:
                return false;
        }
    }

}
