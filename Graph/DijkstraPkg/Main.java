package DijkstraPkg;

public class Main {

    public static void main(String[] args) {
        String fname = "DijkstraInput.txt";
        DijkstraAlg myDijkstra = new DijkstraAlg();
//        myDijkstra.show(myDijkstra.readGraph(fname));
        int [][] graph = myDijkstra.readGraph(fname);
        int startVertex = 1;
        int[] shortetPath = myDijkstra.dijsktra(graph, startVertex);
        for (int i = 0; i < shortetPath.length; i++) {
            System.out.println("Distance from " + toChar(startVertex) + " to " + toChar(i)
                    + " is: " + shortetPath[i]);
        }
        System.out.println("");

    }
    
    public static char toChar(int i) {
        return (char) (i + 65);
    }    

}
