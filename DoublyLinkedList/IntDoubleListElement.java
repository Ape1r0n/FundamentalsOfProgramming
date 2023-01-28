package DoublyLinkedList;

public class IntDoubleListElement {
    private int info;
    public IntDoubleListElement prev, next;

    public IntDoubleListElement(int info){
        this.info = info;
        this.next = null;
        this.prev = null;
    }

    public int getInfo(){
        return info;
    }

    public void setInfo(int info){
        this.info = info;
    }

    public boolean isEqual(IntDoubleListElement other){
        return other != null && this.getInfo() == other.getInfo();
    }

}