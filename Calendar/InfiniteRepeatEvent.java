package Calendar;

public class InfiniteRepeatEvent extends Event{
    private int period;

    public InfiniteRepeatEvent(int day, String desription, String place, int period) {
        super(day, desription, place);
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

    public int diff(int day){
        if(this.getDay() > day) return super.diff(day);
        else return period - (day - this.getDay())%period; // (super.diff(day) % period + period) % period
    }

    public static void main(String[] args) {
        InfiniteRepeatEvent e = new InfiniteRepeatEvent(12,"SMTH","KIU",3);
        System.out.println(e.diff(27));
    }
}
