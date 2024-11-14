
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        String fileName="GraphInput.txt";
        Graph myG = new Graph(fileName);

        System.out.println("\n--BFS--");        
        char startVertex='B';
        myG.BFS(myG.toInt(startVertex));
        System.out.println("\nDegree of all verties");
        for (int i = 0; i < myG.size; i++) {
            System.out.println("Degree of "+
                    myG.toChar(i)+": "+myG.deg(myG.toChar(i)));
        }
        System.out.println("\n--DFS --");
        myG.DFSGraph(startVertex);
        System.out.println("");        
    }
}
