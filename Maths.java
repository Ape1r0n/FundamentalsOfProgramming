import java.lang.Math;

public class Maths{
    public static int roundUp(int n){
        return 1 + n/2;
    }

    public static double[] wholeAndFractional(double n){
        return new double[]{(n - n%1),n%1};
    }

    public static boolean isDoubleAnInteger(double n){
        return n % 1 == 0;
    }

    public static int absolute(int n){
        return (n>=0) ? n : -n;
    }

    public static int romanValue(char c){
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> -1;
        };
    }

    public static int romanToInt(String s){
        int n = s.length() , result = 0 , current , next , i = 0;
        while(i < n) {
            if(i == n - 1){
                result += romanValue(s.charAt(i));
                return result;
            }
            current = romanValue(s.charAt(i));
            next = romanValue(s.charAt(i + 1));
            if(current >= next){
                result += current;
                i++;
            }else{
                result += next - current;
                i += 2;
            }
        }
        return result;
    }

    public static boolean isPrime(int p){
        boolean result = true;
        for(int i=2; i<Math.sqrt(p) + 1;i++){
            if(p%i==0)
                result = false;
        }
        return result;
    }

    public static int numberOfPrimes(int n){
        int counter = 0;
        if(n < 2){
            counter = -1;
        }else{
            counter = 2;
            for(int i=5; i < n; i++){
                if(isPrime(i))
                    counter++;
            }
        }
        return counter;
    }

    public static int gcd(int a, int b){
        while(a != b){
            if(a < b)
                b = b - a;
            else
                a = a - b;
        }
        return a;
    }

    public static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }

    public static void main(String[] args) {
        System.out.println("Round up: " + roundUp(7));
        System.out.println("Whole: " + (int)wholeAndFractional(3.14)[0] + ", Fractional: " + wholeAndFractional(3.14)[1]);
        System.out.println("6.7 is integer: " + isDoubleAnInteger(6.7));
        System.out.println("5.0 is integer: " + isDoubleAnInteger(5.0));
        System.out.println("Absolute value of -17 is " + absolute(-17));
        System.out.println("Integer value of XIV is " + romanToInt("XIV"));
        System.out.println("Number of primes before 927: " + numberOfPrimes(927));
        System.out.println("LCM  of 12 and 14 is " + lcm(12,14));
    }
}