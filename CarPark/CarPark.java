package CarPark;

public class CarPark {
    private final Car[] spaces;

    public CarPark(int n){
        this.spaces = new Car[n];
    }

    public int park(Car c){
        for(int i=0; i< spaces.length; i++){
            if(spaces[i] == null) spaces[i] = c;
        }
        int count = 0;
        for(Car i : spaces) if(i != null) count++;
        return count;
    }

    public int search(LicensePlate lp){
        int result = -1;
        boolean found=false;
        for(int i=0; i<spaces.length; ++i){
            if((spaces[i] != null) && spaces[i].getLicensePlate().isEqual(lp)){
                result = i;
                found = true;
                break;
            }
        }
        if(!found)
            return -1;
        else
            return result;
    }

    public Car driveOff(LicensePlate lp){
        Car result = null;
        for(int i=0; i<spaces.length; ++i){
            if(spaces[i] != null && spaces[i].getLicensePlate().isEqual(lp)){
                result = spaces[i];
                spaces[i] = null;
                break;
            }
        }
        return result;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Car Park:\n");
        for(int i = 0; i < spaces.length; ++i){
            builder.append(i + ": ");
            if(spaces[i] != null) builder.append("[" + spaces[i] + "]\n");
            else builder.append("[]\n");
        }
        return builder.toString();
    }
}