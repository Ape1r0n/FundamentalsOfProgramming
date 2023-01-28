public class BinarySearchTree<T extends Comparable<T>> {

    private class Node {
        T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void add(T value) {
        this.root = add(value, this.root);
    }

    private Node add(T value, Node node) {
        if (node == null) {
            return new Node(value);
        }
        if (value.compareTo(node.value) < 0) {
            node.left = add(value, node.left);
        } else if (value.compareTo(node.value) > 0) {
            node.right = add(value, node.right);
        }
        return node;
    }

    public void remove(T value) {
        this.root = remove(value, this.root);
    }

    private Node remove(T value, Node node) {
        if (node == null) {
            return null;
        }
        if (value.compareTo(node.value) < 0) {
            node.left = remove(value, node.left);
        } else if (value.compareTo(node.value) > 0) {
            node.right = remove(value, node.right);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                T minValue = findMin(node.right);
                node.value = minValue;
                node.right = remove(minValue, node.right);
            }
        }
        return node;
    }

    public T searchByValue(T value) {
        return searchByValue(value, this.root);
    }

    private T searchByValue(T value, Node node) {
        if (node == null) {
            return null;
        }
        if (value.compareTo(node.value) < 0) {
            return searchByValue(value, node.left);
        } else if (value.compareTo(node.value) > 0) {
            return searchByValue(value, node.right);
        } else {
            return node.value;
        }
    }

    private T findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    public T leastCommonAncestor(T value1, T value2) {
        Node current = root;
        while (current != null) {
            int compare1 = value1.compareTo(current.value);
            int compare2 = value2.compareTo(current.value);
            if (compare1 < 0 && compare2 < 0) {
                current = current.left;
            } else if (compare1 > 0 && compare2 > 0) {
                current = current.right;
            } else {
                return current.value;
            }
        }
        return null;
    }

    public void inorderTransversal() {
        inorderTransversal(this.root);
    }

    private void inorderTransversal(Node node) {
        if (node == null) return;
        inorderTransversal(node.left);
        System.out.println(node.value);
        inorderTransversal(node.right);
    }

    public void preorderTransversal() {
        preorderTransversal(this.root);
    }

    private void preorderTransversal(Node node) {
        if (node == null) return;
        System.out.println(node.value);
        preorderTransversal(node.left);
        preorderTransversal(node.right);
    }

    public void postorderTransversal() {
        postorderTransversal(this.root);
    }

    private void postorderTransversal(Node node) {
        if (node == null) return;
        postorderTransversal(node.left);
        postorderTransversal(node.right);
        System.out.println(node.value);
    }
}