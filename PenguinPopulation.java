public class PenguinPopulation extends MiniJava{
    public static void main(String[] args){
        int young = 2, adults = 0, seniors = 0, n = readInt("Please insert a number:");
        while(n != 0){
            seniors = adults;
            adults = young;
            young = adults*2 + seniors;
            n--;
        }
        write(seniors + adults + young);
    }
}
