package AVLTRee;
public class Node {
    int data, height;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.height = 1;
        this.left = null;
        this.right = null;
    }    
}
