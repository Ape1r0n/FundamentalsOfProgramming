package SparseArrays2D;

import java.util.*;
import java.util.function.Function;

public class Sparse2DArray<T>{
    static class Element<T>{
        private int x;
        private int y;
        private T value;

        public Element(int x, int y, T value) {
            this.x = x;
            this.y = y;
            this.value = Objects.requireNonNull(value);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public T getValue() {
            return value;
        }
    }

    private final int sizeX;
    private final int sizeY;
    private List<Element<T>> elementList = new LinkedList<>();

    public Sparse2DArray(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public T get(int x, int y){
        Objects.checkIndex(x, sizeX);
        Objects.checkIndex(y, sizeY);
        return elementList.stream().filter(e -> e.getX() == x && e.getY() == y).findAny().map(Element::getValue).orElse(null);
    }

    public void set(int x, int y, T value){
        Objects.checkIndex(x, sizeX);
        Objects.checkIndex(y, sizeY);
        if(elementList.stream().filter(e -> e.getX() == x && e.getY() == y).findAny().isPresent()) elementList.remove(elementList.stream().filter(e -> e.getX() == x && e.getY() == y).findAny());
        elementList.add(new Element<>(x,y,value));
    }

    public void sortElements(){
        Collections.sort(elementList, Comparator.comparing((Element<T> t) -> t.x).thenComparing(u -> u.x));
    }

    public static <T> Sparse2DArray<T> fromArray(T[][] array2d){
        if(array2d == null) throw new RuntimeException("You passed array that is null");
        int initialSize = array2d[0].length;
        Sparse2DArray<T> ans = new Sparse2DArray<>(array2d.length, array2d[0].length);
        for(int i=0; i< array2d.length; i++){
            if(array2d[i] == null) throw new RuntimeException("null element detected");
            if(array2d[i].length != initialSize) throw new RuntimeException("inconsistent array size");
            for(int k=0; k<array2d[0].length; k++) ans.set(i,k,array2d[i][k]);
        }
        return ans;
    }

    public T[][] toArray(Function<Integer, T[]> array1dFunc, Function<Integer, T[][]> array2dFunc){
        T[][] ans = array2dFunc.apply(sizeX);
        for(int i = 0; i < sizeX; i++) ans[i] = array1dFunc.apply(sizeY);
        for(Element<T> e : elementList) ans[e.getX()][e.getY()] = e.getValue();
        return ans;
    }
}