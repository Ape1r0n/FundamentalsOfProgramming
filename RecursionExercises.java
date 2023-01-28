import java.util.Scanner;

public class RecursionExercises {
    public static String reverseString(String str){
        if(str == null || str.equals("")){
            return str;
        }else{
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }

    public static void finalCountdown(int n){
        if(n == 1){
            System.out.println("IT'S FINAL COUNTDOWNNNN! (" + 1 + ")");
        }else{
            System.out.println(n);
            finalCountdown(n-1);
        }
    }
    static int res = 0;
    public static int reverseNumber(int n){
        if(n == 0){
            return n;
        }else if(n > 0){
            int modulo = n%10;
            res = res*10 + modulo;
            reverseNumber(n/10);
        }
        return res;
    }

    public static int power(int x, int y){
        if(y == 0)
            return 1;
        else{
            return (x*power(x,y-1));
        }
    }
    static String answer = "";
    public static String decimalToBinary(int dec){
        if(dec == 0)
            answer += 0;
        else if(dec == 1)
            answer += 1;
        else{
            answer += dec%2;
            return decimalToBinary(dec/2);
        }
        return reverseString(answer);
    }

    public static int countOccurence(int[] arr, int num, int counter, int occurence) {
        if(arr[counter] == num) occurence++;
        if(counter == arr.length-1) return occurence;
        return countOccurence(arr,num,++counter,occurence);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter string that should be reversed: ");
        String str = scn.nextLine();
        System.out.println("Reverse of <<" + str + ">> is -> " + reverseString(str));

        System.out.println("Enter number: ");
        int num = scn.nextInt();
        finalCountdown(num);
        System.out.println("Reverse of <<" + num + ">> is " + reverseNumber(num));
        res = 0;

        System.out.println("Enter base and power: ");
        int base = scn.nextInt(), power = scn.nextInt();
        System.out.println(power(base,power));

        System.out.println(num + " to binary -> " + decimalToBinary(num));

        int[] arr = {1,2,3,4,5,6,7,8,9,9,9};
        int res = countOccurence(arr,9,0,0);
        System.out.println("Number 9 occurs " + res + " times in the array");
    }
}
