import java.util.Scanner;

public class UltimateSquare{

    public static int ceiling(int i){
        return i%2==0 ? i/2 : (i >> 1) + 1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int temp, n = scn.nextInt();
        int[] output = new int[n];
        for(int i=0; i<n; i++){
            temp = scn.nextInt();
            output[i] = ceiling(temp);
        }
        for(int i=0; i<n; i++){
            System.out.println(output[i]);
        }
    }
}