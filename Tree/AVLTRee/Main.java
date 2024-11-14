package AVLTRee;
public class Main {
    public static void main(String[] args) {
        MyAVLTree myAVL = new MyAVLTree();
        myAVL.root=myAVL.addAVLNode(myAVL.root, 8);
        myAVL.root=myAVL.addAVLNode(myAVL.root, 3);
        myAVL.root=myAVL.addAVLNode(myAVL.root, 10);
        myAVL.root=myAVL.addAVLNode(myAVL.root, 1);
        myAVL.root=myAVL.addAVLNode(myAVL.root, 6);
        myAVL.root=myAVL.addAVLNode(myAVL.root, 14);
        myAVL.root=myAVL.addAVLNode(myAVL.root, 4);
        myAVL.root=myAVL.addAVLNode(myAVL.root, 7);
        myAVL.root=myAVL.addAVLNode(myAVL.root, 13);
        myAVL.root=myAVL.addAVLNode(myAVL.root, 5);
        myAVL.BFS(myAVL.root);
//        System.out.println("\nDelbymerging");
//        myAVL.delAVLByMerging(myAVL.root, 8);
        System.out.println("\nDelbyCopying");
        myAVL.delAVLByCopying(myAVL.root, 100);
        myAVL.BFS(myAVL.root);
        System.out.println("");        
    }
}
