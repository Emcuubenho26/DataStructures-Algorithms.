package BiranySearchTree;

public class Main {

    public static void main(String[] args) {
        MyBinarySearchTree myTree = new MyBinarySearchTree();
        myTree.addABSTNode(8);
        myTree.addABSTNode(3);
        myTree.addABSTNode(10);
        myTree.addABSTNode(6);
        myTree.addABSTNode(1);
        myTree.addABSTNode(14);
        myTree.addABSTNode(7);
        myTree.addABSTNode(13);
        myTree.addABSTNode(4);
        myTree.addABSTNode(5);
        myTree.BFS(myTree.root);
        System.out.println("\nInorder");
        myTree.inOrder(myTree.root);
        System.out.println("");
//        myTree.delByMerging(myTree.root,3);
//        myTree.delByCopying(myTree.root,3);
        myTree.BFS(myTree.root);
        System.out.println("\nNumber of nodes: "
                + myTree.countTreeNode(myTree.root));
        System.out.println("Number of nodes from 6 to 13: "
                + myTree.countNodeInARange(myTree.root, 6, 13));
        System.out.println("Number of nodes only have a left child: "
                + myTree.countLeftNode(myTree.root));
        System.out.println("Number of nodes only have a right child: "
                + myTree.countRightNode(myTree.root));
        System.out.println("Number of nodes have two children: "
                + myTree.countNodeTwoChidren(myTree.root));
        System.out.println("Delete all nodes have a left child");
//        myTree.root=myTree.delAllNodeOnlyLeftChild(myTree.root);
//        myTree.BFS(myTree.root);
        System.out.println("Delete all nodes have a right child");
        myTree.root=myTree.delAllNodeOnlyRightChild(myTree.root);
        myTree.BFS(myTree.root);
        System.out.println("");
    }
}
