public class AverageCharacter{
    public static char averageCharacter(String s){
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            sum += s.charAt(i);
        }
        return (char)(sum/s.length());
    }

    public static void main(String[] args) {
        System.out.println(averageCharacter("aBcDe"));
    }
}
