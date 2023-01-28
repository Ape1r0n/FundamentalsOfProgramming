public class NumberOfStepsBitwiseOperators {
    public static int bitwiseSteps(int n){
        int counter = 0;

        while(n>0){
            if((n & 1) == 0) { // xxx0 & 0001
                n >>= 1;
            }else{
                --n;
            }
            counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println("Number of steps to reduce provided number into zero: " + bitwiseSteps(14000605));
    }
}
