import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Anagram {
    private static boolean usingMap(String a, String b){
        if(a.length() != b.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<a.length(); i++){
            if(map.containsKey(map.getOrDefault(a.charAt(i),0))) map.put(a.charAt(i),1);
            else map.put(a.charAt(i),map.getOrDefault(a.charAt(i),0)+1);
        }
        for(int i=0; i<b.length(); i++){
            if(!map.containsKey(b.charAt(i))) return false;
            else map.put(b.charAt(i),map.get(b.charAt(i))-1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() != 0) return false;
        }
        return true;
    }

    private static boolean usingSorts(String a, String b){
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        return Arrays.toString(aArr).equals(Arrays.toString(bArr));
    }

    private static Function<Boolean, String> printer = (aBoolean -> aBoolean ? "Provided strings ARE anagrams." : "Provided strings are NOT anagrams.");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string -> ");
        String a = scanner.nextLine();
        System.out.print("Enter second string -> ");
        String b = scanner.nextLine();
        System.out.println("usingMap -> " + printer.apply(usingMap(a,b)));
        System.out.println("usingSorts -> " + printer.apply(usingSorts(a,b)));
    }
}
