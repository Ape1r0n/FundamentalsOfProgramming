package pgdp.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T>{

    private List<Node<T>> children;
    private Node<T> parent;
    private T data;
    public Node(T data) {
        this.data = data;
        children = new ArrayList<>();
    }
    public void insert(Node<T> value) {
        if(value != null) {
            children.add(value);
            value.parent = this;
        }
    }

    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    public int size() {
       if(this.isLeaf()) return 1;
       else{
           int size = 1;
           for(Node<T> temp : children){
               if(temp.isLeaf()) size++;
               else size += temp.size();
           }
           return size;
       }
    }

    public void remove() {
        if(this.isLeaf()) parent.children.remove(parent.children.indexOf(this));
        else parent.children.addAll(children);
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Node<T> getParent() {
        return parent;
    }

    public T getData() {
        return data;
    }

    public void traverse(Node<T> root) {
        if(this.isLeaf()) return;
        int itr = 0;
        Node<T> temp = null;
        System.out.print(" " + root.getData());
        while(itr < root.size()-1){
            temp = root.getChildren().get(itr);
            traverse(temp);
            ++itr;
        }
    }


}