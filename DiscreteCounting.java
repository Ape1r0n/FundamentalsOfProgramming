public class DiscreteCounting{
    public static int dN(int n){
        if(n == 1){
            return 0;
        }else if(n == 2){
            return 1;
        }else{
            return (n-1)*(dN(n-1) + dN(n-2));
        }
    }

    public static int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }

    public static int power(int n, int k){
        int res = 1;
        if(k == 0){
            res = 1;
        }else{
            while(k>0) {
                res *= n;
                --k;
            }
        }
        return res;
    }

    public static double Dn(int n){
        double sum = 0;
        for(int k=0; k<=n;k++){
            double temp = (double) power(-1,k)/factorial(k);
            sum += temp;
        }
        sum = sum * factorial(n);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(dN(5));
        System.out.println(Dn(5));
    }
}
