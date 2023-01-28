import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        instanceOf.instanceChecker();
        System.out.println(new PersonRecord("lado","turmanidze",18).toString());

        String textBlocksCanBeUseful = """
                                    _________
                                      _____
                                       ___
                                        _
                                       """;
        System.out.println(textBlocksCanBeUseful);
        MP4 cinderella = new MP4();
        cinderella.playVideo();
        cinderella.mp4();

        Set<Character> aS = Set.of('A','a'); // inserting duplicate elements using .of in set results in IllegalArgumentException
        Map<String, Integer> goats = Map.of("Messi",10,"Ronaldo",7,"Maradona",10,"Pele",10);
        Map<String, Integer> goatsAlive = Map.ofEntries(Map.entry("Messi",30),Map.entry("Ronaldo",7));
        aS.stream().forEach(System.out::println);
        goats.forEach((player, number) -> System.out.println(player + ' ' + number));
        goatsAlive.forEach((player, number) -> System.out.println("New number of " + player + " is " + number));
    }
}