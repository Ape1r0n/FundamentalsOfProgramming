// არაფერ შუაშია ამ ამოცანასთან, ისე დავწერე

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyIterator<T> implements Iterator<T> {
    private List<T> source = null;
    private int jump = 1;
    private int index = 0;

    public MyIterator(List<T> source, int x){
        this.source = source;
        jump = x;
    }

    public MyIterator(List<T> source){
        this.source = source;
    }

    @Override
    public boolean hasNext() {
        return (this.index + this.jump) < this.source.size();
    }

    @Override
    public T next() {
        T element = this.source.get(this.index);
        this.index += this.jump;
        return element;
    }

    public static void main(String[] args) {
        List<String> us = new ArrayList<>();
        us.add("Lado");
        us.add("Dima");
        us.add("Temo");
        us.add("Sandro");
        us.add("Tsula");
        Iterator<String> itr = new MyIterator(us,2);
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }



    //
//    @Override
//    public T next() {
//        return this.source.get(this.index++);
//    }
}
