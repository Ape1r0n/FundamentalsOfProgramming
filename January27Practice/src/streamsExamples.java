import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class streamsExamples {
    public static void main(String[] args) {
        List<String> productlist1 = Arrays.asList("Printer", "Mouse", "Keyboard", "Motherboard");
        List<String> productlist2 = Arrays.asList("Scanner", "Projector", "Light Pen");
        List<String> productlist3 = Arrays.asList("Pen Drive", "Charger", "WIFI Adapter", "Cooling Fan");
        List<String> productlist4 = Arrays.asList("CPU Cabinet", "WebCam", "USB Light", "Microphone", "Power cable");
        List<String> l1 = Arrays.asList("a","bc","def");
        List<String> l2 = Arrays.asList("ghij","klmno","pqrstu","vwxyz");
        int[] counter = {1};

        Stream.of(productlist1, productlist2, productlist3, productlist4).flatMap(List::stream).forEach(l -> System.out.println(counter[0]++ + ") "+ l));
        System.out.println("Number of letters in English alphabet: " + Stream.of(l1,l2).flatMap(List::stream).mapToInt(String::length).reduce((a,b) -> a + b).orElse(0));
        System.out.println("Number of letters in Qartuli alphabet: " + Stream.of(l1,l2).flatMap(List::stream).mapToInt(String::length).reduce(7,(a,b) -> a + b));
        System.out.println("2,5,10 reduce with identity 0: " + List.of(2,10,5).stream().reduce(0,(a,b) -> (a+10) + (b+10)));
        System.out.println("2,5,10 reduce without identity: " + List.of(2,10,5).stream().reduce((a,b) -> (a+10) + (b+10)).orElse(0));
    }
}
