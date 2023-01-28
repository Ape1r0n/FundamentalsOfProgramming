package PainfulSuccessors;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface Succ<T> {
    Succ<T> succ(T t);

    static <T> BiFunction<Succ<T>, T, Succ<T>> export() {
        return (s, t) -> s.succ(t);
    }

    default boolean looping(T t) {
        return succ(t) == this;
    }

    default Succ<T> filter(Predicate<? super T> p) {
        return t -> {
            if (p.test(t)) return Succ.this.succ(t);
            else return null;
        };
    }
}