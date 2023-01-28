package DoublyLinkedList;


public class IntDoubleList{
    private  IntDoubleListElement head, tail;

    public IntDoubleListElement getFirstElement(){
        return head;
    }

    public  IntDoubleListElement getLastElement(){
        return tail;
    }

    public void append(int info){
        IntDoubleListElement element = new IntDoubleListElement(info);
        if(head == null){
            head = element;
            tail = element;
        }else{
            tail.next = element;
            element.prev = tail;
            tail = element;
        }
    }

    public int size(){
        IntDoubleListElement temp = head;
        int counter = 0;

        while(temp != null){
            counter++;
            temp = temp.next;
        }

        return counter;
    }

    public int get(int pos) {
        if (pos < 0 || pos >= this.size()) {
            System.out.println("Out of range");
            return 0;
        }
        IntDoubleListElement temp = head;
        int res = 0;
        for(int i=0; i <= pos; i++, temp = temp.next)
            res = temp.getInfo();
        return res;
    }

    public void remove(int pos){
        if(pos < 0 || pos >= this.size()){
            System.out.println("Incorrect position");
        }else if(pos == 0) {
            head = head.next;
            if(head != null) head.prev = null;
            else tail = null;
        }else if(pos == this.size()-1){
            tail = tail.prev;
            tail.next = null;
        }else{
            IntDoubleListElement temp = head;
            int i = 0;
            while(i != pos) {
                temp = temp.next;
                i++;
            }
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        }
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        IntDoubleListElement temp = head;
        if(temp != null){
            while(temp.next != null){
                builder.append(temp.getInfo() + ",");
                temp = temp.next;
            }
            builder.append(temp.getInfo());
            return builder.toString();
        }else{
            return "";
        }
    }

    public boolean isEqual(IntDoubleList other){
        if(this.size() != other.size()){
            return false;
        } else {
            boolean result = true;
            int i = 0;
            IntDoubleListElement tempThis = this.head, tempThat = other.head;
            while(i < this.size()){
                if(tempThis.getInfo() != tempThat.getInfo()){
                    result = false;
                    break;
                }
                tempThis = tempThis.next;
                tempThat = tempThat.next;
                i++;
            }
            return result;
        }
    }

    public int sum(){
        if(this.size() == 0) return 0;
        else {
            int sum = 0, i = 0;
            IntDoubleListElement temp = head;
            while (i < this.size()) {
                sum += temp.getInfo();
                temp = temp.next;
                i++;
            }
            return sum;
        }
    }

    public IntDoubleList copy(){
        IntDoubleList copy = new IntDoubleList();
        IntDoubleListElement temp = head;
        if(temp == null) return copy;
        copy.append(temp.getInfo());
        while(temp.next != null){
            temp = temp.next;
            copy.append(temp.getInfo());
        }
        return copy;
    }

    public IntDoubleListElement[] search(int intValue){
        if(head == null) return new IntDoubleListElement[0];
        int i = 0, j = 0;
        IntDoubleListElement temp = head;
        IntDoubleListElement[] arr = new IntDoubleListElement[this.size()];

        while(temp != null){
            if(temp.getInfo() == intValue){
                i++;
            }
            temp = temp.next;
        }

        IntDoubleListElement[] result = new IntDoubleListElement[i];
        temp = head;
        while (temp != null){
            if(temp.getInfo() == intValue){
                result[j] = temp;
                j++;
            }
            temp = temp.next;
        }

        return result;
    }

}