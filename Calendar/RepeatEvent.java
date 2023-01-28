package Calendar;

public class RepeatEvent extends InfiniteRepeatEvent{
    private int end;

    public RepeatEvent(int day, String desription, String place, int period, int end) {
        super(day, desription, place, period);
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    public int diff(int day){
        if(day >= this.end){
            return this.end - day;
        }else{
            return super.diff(day);
        }
    }

    public static void main(String[] args) {
        RepeatEvent r = new RepeatEvent(2,"","",3,32);
        System.out.println(r.diff(32));
    }
}