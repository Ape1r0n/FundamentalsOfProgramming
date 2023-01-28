import java.io.*;
import java.util.function.*;
import java.util.stream.*;
import java.nio.file.*;

public class StateTest {
    public static void main(String[] a) throws IOException {
        BiConsumer<State,Double> acc = State::inc; // sub-task 2
        BiConsumer<State,State> comb = State::add; // sub-task 3
        Stream<String> ss = Files.lines(Path.of(a[0]));
        double avg = ss.mapToDouble(Double::parseDouble).filter(d -> d > 42.0 || d < -42.0).average().getAsDouble();
        System.out.println("The average is \t" + avg);
    }
}