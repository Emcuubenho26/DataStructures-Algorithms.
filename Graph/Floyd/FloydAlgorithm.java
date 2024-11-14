package Floyd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author VU VAN HUY
 */
public class FloydAlgorithm {
    final static int INF = 99;

    public static void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];
        int[][] next = new int[V][V];

        // Khoi tao ma tran khoang cach va duong di
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        // Thuat toan Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        // In ra ket qua
        for (int i = 0; i < 6; i++) {
        int startVertex = i; // Chon dinh bat dau la dinh 0
        printShortestPaths(startVertex, dist, next);
            System.out.println("");            
        }
    }

    public static void printShortestPaths(int startVertex, int[][] dist, int[][] next) {
        int V = dist.length;
        for (int endVertex = 0; endVertex < V; endVertex++) {
            if (endVertex != startVertex) {
                if (dist[startVertex][endVertex] == INF) {
                    System.out.println("Khong co duong di tu dinh " + startVertex + " den dinh " + endVertex);
                } else {
                    System.out.print("Tu dinh " + toChar(startVertex) + " -> " + toChar(endVertex) + ": ");
                    printPath(startVertex, endVertex, next);
                    System.out.println(" cost " + dist[startVertex][endVertex]);
                }
            }
        }
    }
    
    public static char toChar(int x) {
        return (char)(x+65);
    }
    public static void printPath(int startVertex, int endVertex, int[][] next) {
        int current = startVertex;
        System.out.print(toChar(current));
        while (current != endVertex) {
            current = next[current][endVertex];
            System.out.print(" -> " + toChar(current));
        }
    }

    public static void main(String[] args) {
        try {
            String filename = "DijkstraInput.txt";
            BufferedReader br = new BufferedReader(new FileReader(filename));
            int vertices = Integer.parseInt(br.readLine().trim());
            int[][] graph = new int[vertices][vertices];

            for (int i = 0; i < vertices; i++) {
                String[] line = br.readLine().trim().split("\\s+");
                for (int j = 0; j < vertices; j++) {
                    if (line[j].equals("INF")) {
                        graph[i][j] = INF;
                    } else {
                        graph[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }

            br.close();
            
            floydWarshall(graph);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
