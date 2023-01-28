public class TwoMaximums extends MiniJava {
    public static void main(String[] args){
        int k = readInt("Please indicate number:");
        int temp, firstMaximum = Integer.MIN_VALUE;
        int secondMaximum = -2147483648;
        if(k < 2){
            write("Error: number >= 2 expected!");
        } else {
            firstMaximum = readInt("Please insert integer:");
            secondMaximum = readInt("Please insert integer:");

            if(firstMaximum < secondMaximum){
                temp = firstMaximum;
                firstMaximum = secondMaximum;
                secondMaximum = temp;
            }

            while (k != 2 ){
                temp = readInt();
                if(temp > firstMaximum){
                    firstMaximum = temp;
                } else if(temp > secondMaximum){
                    secondMaximum = temp;
                }

                k--;
            }
            write("First:");
            write(firstMaximum);
            write("Second:");
            write(secondMaximum);
        }
    }
}
