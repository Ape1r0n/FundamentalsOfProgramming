public class IsPalindromeOrPerfect extends MiniJava{
    public static void main(String[] args){
        int remainder, tmp, sum = 0, number = readInt();
        int number_again = number, sigma = 0;

        tmp = number;
        while(number > 0){
            remainder = number%10;
            sum = (sum*10) + remainder;
            number /= 10;
        }

        if(tmp == sum){
            write(number_again + " is a palindrome");
        }else{
            write(number_again + " is not a palindrome");
        }

        for(int i=1;i<=(number_again/2);i++){
            if(number_again%i == 0){
                sigma += i;
            }
        }

        if (number_again == sigma){
            write(number_again + " is a perfect number");
        }else{
            write(number_again + " is not a perfect number");
        }

        // euclid proved that 2^(p-1)(2^p -1) is a perfect number if 2^p - 1 is prime
    }
}
