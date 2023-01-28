import java.util.function.Function;

public interface Relation<X,Y>{
    boolean test(X x, Y y);

    default Relation<X,Y> negate(){
        return (x,y) -> !this.test(x,y);
    }

    default Relation<Y,X> mirror(){
        return (x, y) -> this.test(y,x);
    }

    default Relation<X,Y> and(Relation<? super X, ? super Y> other){
        return (x,y) -> this.test(x,y) && other.test(x,y);
    }

    default <Z> Relation<Z,Y> compose(Function<? super Z, ? extends X> f){
        return (z,y) -> this.test(f.apply(z),y);
    }
}
