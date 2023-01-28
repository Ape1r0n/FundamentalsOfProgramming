package pgdp.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

    private Node<T> root;

    public Tree (T data) {
        root = new Node(data);
    }

    private boolean getByKey(Node<T> vertice, T key){
        if(vertice.getData() == key) return true;
        else if(vertice.isLeaf()) return false;
        for(Node<T> temp : vertice.getChildren()){
            if(getByKey(temp,key)) return true;
        }
        return false;
    }

    public boolean containsKey(T key){
        return getByKey(root,key);
    }

    private Node<T> getByValue(Node<T> vertice, T value){
        if(vertice.getData() == value) return vertice;
        else if(vertice.isLeaf()) return null;
        for(Node<T> temp : vertice.getChildren()){
            Node<T> droebiti = getByValue(temp,value);
            if (droebiti != null){
                return droebiti;
            }
        }
        return null;
    }

    public void insert(T value, T parent){
        if (parent != null && value != null && !containsKey(value) && containsKey(parent)){
            Node<T> temp = getByValue(root,parent);
            if(temp != null) temp.insert(new Node<T>(value));
        }
    }

    public void remove(T value){
        Node<T> temp = getByValue(root,value);
        if(temp != null && temp.getParent() != null) temp.remove();
    }

    public T LCA(T a, T b) {
        if(root.getData() == a || root.getData() == b) return root.getData();
        Node<T> tempA = getByValue(root,a);
        Node<T> tempB = getByValue(root,b);
        if(tempA != null && tempB != null && tempA.getData() == tempB.getData()) return tempA.getParent().getData();
        else if(tempA != null && tempB != null && root != null && tempA.getParent() != null && tempB.getParent() != null){
            List<Node<T>> A_parents = new ArrayList<>(), B_parents = new ArrayList<>();
            Node<T> tempA_Parent = tempA, tempB_Parent = tempB;
            int counter = 0;

            // Filling ArrayLists with all the parents of tempA and tempB
            while(tempA_Parent.getData() != root.getData()){
                A_parents.add(tempA_Parent);
                tempA_Parent = tempA_Parent.getParent();
            }
            A_parents.add(root);

            while(tempB_Parent.getData() != root.getData()){
                B_parents.add(tempB_Parent);
                tempB_Parent = tempB_Parent.getParent();
            }
            B_parents.add(root);

            for(Node<T> A_element : A_parents){
                Node<T> temp_B = root;

                for(Node<T> B_element : B_parents){
                    temp_B = B_element;
                    if(A_element.getData() == B_element.getData()) return A_element.getData();
                }
                if(A_element.getData() == temp_B.getData()) break;
                counter++;
            }

            while(counter > 0){
                tempA = tempA.getParent();
                counter--;
            }

            return tempA.getData();
        }
        return null;
    }

    public int distanceBetweenNodes(T a, T b){
        Node<T> tempA = getByValue(root,a);
        Node<T> tempB = getByValue(root,b);
        if(tempA == null || tempB == null) return -1;
        T lca = LCA(tempA.getData(),tempB.getData());
        int counter = 0;
        while(tempA.getData() != lca){
            counter++;
            tempA = tempA.getParent();
        }
        while(tempB.getData() != lca){
            ++counter;
            tempB = tempB.getParent();
        }
        return counter;
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public void traverse(){
        root.traverse(root);
    }

}
