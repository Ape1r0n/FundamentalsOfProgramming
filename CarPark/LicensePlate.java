package CarPark;

public class LicensePlate {
    private String regionalCode, letters;
    private int digits;

    public LicensePlate(String regionalCode, String letters, int digits){
        this.regionalCode = regionalCode;
        this.letters = letters;
        this.digits = digits;
    }

    public String getRegionalCode(){
        return regionalCode;
    }

    public String getLetters(){
        return letters;
    }

    public int getDigits(){
        return digits;
    }

    public boolean isEqual(LicensePlate other){
        return this.equals(other);
    }

    public String toString(){
        return regionalCode + ":" + letters + " " + digits;
    }
}