import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class StreamsPractice {
    public static void main(String[] args) {
        var france = new Country("France", 65_235_184L);
        var canada = new Country("Canada", 37_653_095L);
        var uk = new Country("United Kingdom", 67_791_734L);

        var people = asList(
                new Person("John", 50, Gender.MALE, canada),
                new Person("May", 12, Gender.FEMALE, france),
                new Person("Tiff", 23, Gender.NON_BINARY, uk),
                new Person("Azul", 15, Gender.FEMALE, france),
                new Person("Samantha", 67, Gender.FEMALE, canada));

        System.out.println("--- 1 ---");
        people.stream().map(Person::getName).map(String::toUpperCase).forEach(System.out::println); // Exercise 1
        System.out.println("--- 2 ---");
        people.stream().filter(p -> p.getName().length() < 4).forEach(System.out::println);
        // System.out.println("--- 3 ---");
        // people.stream().flatMap(Collection::stream).collect(toList());
        System.out.println("--- 3 ---");
        System.out.println(people.stream().mapToInt(Person::getAge).max().getAsInt());
        System.out.println("--- 4 ---");
        System.out.println(people.stream().mapToInt(Person::getAge).sum());
        System.out.println("--- 5 ---");
        people.stream().mapToInt(Person::getAge).average().ifPresent(x -> System.out.println("Avg: " + x));
        people.stream().mapToInt(Person::getAge).min().ifPresent(x -> System.out.println("Min: " + x));
        people.stream().mapToInt(Person::getAge).max().ifPresent(x -> System.out.println("Max: " + x));
        System.out.println("Amount of people: " + people.stream().mapToInt(Person::getAge).count());
        System.out.println("--- 6 ---");
        people.stream().collect(partitioningBy(Person::isAdult)).forEach((age, personList) -> System.out.println((age ? "Adults: " : "Children: ") + personList));
        System.out.println("--- 7 ---");
        people.stream().collect(groupingBy(Person::getCountry)).forEach(((country, personList) -> System.out.println(country.name + ": " + personList.stream().map(Person::getName).collect(Collectors.toSet()))));
        System.out.println("--- 8 ---");
        String joiningUsingUnderscore = people.stream().map(Person::getName).collect(Collectors.joining("_"));
        System.out.println(joiningUsingUnderscore);
        System.out.println("--- 9 ---");
    }
}
