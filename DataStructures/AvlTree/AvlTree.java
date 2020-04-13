package DataStructures.AvlTree;

public class AvlTree<T> {

    Node<T> root;
    
    public boolean isBalanced(Node<T> node){
        return Math.abs(getBalance(node)) <= 1;
    }

    public int getBalance(Node<T> node){
        if(node == null) return 0;
        int leftHeight = node.getLeft() == null ? 0 : node.getLeft().getHeight();
        int rightHeight = node.getRight() == null ? 0 : node.getRight().getHeight();
        return leftHeight - rightHeight;
    }

    public Node<T> add(Node<T> node, T value){
        if(root == null){
            this.root = new Node<T>(value, null, null);
            return this.root;
        }

        return null;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> a = node.getLeft();
        Node<T> b = a.getRight();
        a.setRight(node);
        node.setLeft(b);
        node.updateHeight();
        a.updateHeight();
        return a;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> a = node.getRight();
        Node<T> b = a.getLeft();
        a.setLeft(node);
        node.setRight(b);
        node.updateHeight();
        a.updateHeight();
        return a;
    }

}