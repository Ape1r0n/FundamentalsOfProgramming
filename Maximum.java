public class Maximum extends MiniJava{
    public static void main(String[] args){
        int k = readInt("Please indicate number:");
        int temp, maximum = -2147483648; // +2147483647
        if(k < 1){
            write("Error: number >= 1 expected!");
        } else {
            while (k != 0 ){
                temp = readInt("Please insert integer:");
                if(temp > maximum){
                    maximum = temp;
                }
                k--;
            }
            write("Maximum:");
            write(maximum);
        }
    }
}
