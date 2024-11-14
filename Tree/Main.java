
public class Main {

    public static void main(String[] args) throws Exception {
        MyTree myT = new MyTree();
        myT.init();
        System.out.println("Pre_order traversal");
        myT.preOrder(myT.root);
        System.out.println("\nIn_Order traversal");
        myT.inOrder(myT.root);
        System.out.println("\nPost_Order traversal");
        myT.postOrder(myT.root);
        System.out.println("\nBreath Traversal");
        myT.breathTraversal(myT.root);
        System.out.println("\nBFS");
        myT.BFS(myT.root);
        System.out.println("");
    }   
    
}
