package FunctionalInterfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class Main{
    public static void main(String[] args) {
        /* Predicate */
        Predicate<String> checkLength = str -> str.length() >= 5; // boolean result
        System.out.println(checkLength.test("Matli"));

        /* Consumer */
        Person p = new Person();
        Consumer<Person> setName = t -> t.setName("Bagrati"); // modifies data | no output
        setName.accept(p);
        System.out.println(p.getName());

        /* Function */
        Function<Integer, String> getInt = t -> t*(10) + " <- Output"; // input and output
        System.out.println(getInt.apply(30));

        /* Supplier */
        Supplier<Double> getPower = () -> Double.valueOf(1231321130); // only output
        System.out.println(getPower.get());
    }
}