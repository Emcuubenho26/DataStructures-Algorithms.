package Dijkstra2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author VU VAN HUY
 */
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        try {
            String filename = "DijkstraInput.txt";
            BufferedReader br = new BufferedReader(new FileReader(filename));
            int vertices = Integer.parseInt(br.readLine().trim());
            Graph graph = new Graph(vertices);

            for (int i = 0; i < vertices; i++) {
                String[] line = br.readLine().trim().split("\\s+");
                for (int j = 0; j < vertices; j++) {
                    if (line[j].equals("INF")) {
                        graph.addEdge(i, j, Graph.INF);
                    } else {
                        int weight = Integer.parseInt(line[j]);
                        if (weight != 0) {
                            graph.addEdge(i, j, weight);
                        }
                    }
                }
            }
            br.close();

            int startVertex = 5; // Start vertex 0
            graph.dijkstra(startVertex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
