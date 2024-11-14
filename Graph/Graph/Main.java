package Graph;
public class Main {
    public static void main(String[] args) {
        MyGraph myG = new MyGraph();
        myG.show();
        System.out.println("=> BFS from A");
        myG.breadth_First_Traversal('A');
        System.out.println("\n=> BFS from B");
        myG.breadth_First_Traversal('B');
        System.out.println("\n=> DFS from B");
        myG.DFSGraph('B');
        System.out.println("");
        for (int i = 0; i < 7; i++) {
            System.out.println("Graph degree of "+myG.toChar(i)+": "+ myG.graphDeg(myG.toChar(i)));
        }               
        System.out.println("");
    }
}
