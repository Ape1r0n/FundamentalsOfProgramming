public class Fibonacci_Prime extends MiniJava{
    public static void main(String[] args) {
        int a = 0, b = 1, c = 0, n, i = 1, k = 0, j;
        n = readInt("Enter n:");
        write("Fibonacci Series given below:-");
        while (i <= n){
            c = a + b;
            if(c > n){
                c = c - 1;
            } else {
                j = 1;
                while (j <= c){
                    if(c%j == 0){
                        k++;
                        j++;
                    }
                    j++;
                }
                if(k == 2){
                    write(c + "\t");
                }
                a = b;
                b = c;
                k = 0;
            }
            i++;
        }
    }
}
