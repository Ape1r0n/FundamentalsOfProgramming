public class Factorization extends MiniJava{
    public static void main(String[] args){
        int n = readInt("Please insert a number:");
        if (n <= 1){
            write("Error: n>1 expected!");
        }else{
            for (int i = 2; i < n / 2; i++) {
                while (n % i == 0) {
                    writeConsole(i + " ");
                    n /= i;
                }
            }
            writeConsole(n);
        }
    }
}
