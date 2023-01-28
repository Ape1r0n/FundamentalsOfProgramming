public class GiveFive extends MiniJava{
    public static void main(String[] args){
        int n = readInt("Please insert a number:");
        int iterations = 0;
        while (n > 1){
            if(n%5 == 0){
                n /= 5;
                iterations++;
            } else if(n%5 == 1){
                n += 9;
                iterations++;
            } else if(n%5 == 2){
                n--;
                iterations++;
            } else if(n%5 == 3){
                n += 7;
                iterations++;
            } else {
                n += 6;
                iterations++;
            }
        }
        write(iterations);
    }
}
