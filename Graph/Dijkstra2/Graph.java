package Dijkstra2;
/**
 *
 * @author VU VAN HUY
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

class Graph {
    private int vertices;
    private int[][] adjacencyMatrix;
    final static int INF = 99;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight; // If underected graph
    }

    public char toChar(int x) {
        return (char)(x+65);
    }    
    public void dijkstra(int startVertex) {
        boolean[] visited = new boolean[vertices];
        int[] distance = new int[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(distance, INF);
        Arrays.fill(parent, -1);
        distance[startVertex] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(vertices, (a, b) -> a.cost - b.cost);
        pq.add(new Node(startVertex, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            if (!visited[u]) {
                visited[u] = true;

                for (int v = 0; v < vertices; v++) {
                    if (adjacencyMatrix[u][v] > 0 && !visited[v]) {
                        int newDist = distance[u] + adjacencyMatrix[u][v];
                        if (newDist < distance[v]) {
                            distance[v] = newDist;
                            parent[v] = u;
                            pq.add(new Node(v, newDist));
                        }
                    }
                }
            }
        }

        printShortestPaths(startVertex, distance, parent);
    }

    public void printShortestPaths(int startVertex, int[] distance, int[] parent) {
        System.out.println("Shortest paths from vertex " + toChar(startVertex) + ":");
        for (int i = 0; i < vertices; i++) {
            if (i != startVertex) {
                if (distance[i] == INF) {
                    System.out.println("No path from vertex " + startVertex + " to vertex " + i);
                } else {
                    System.out.print("From vertex " + toChar(startVertex) + " to " + toChar(i) + ": ");
                    printPath(i, parent);
                    System.out.println("cost " + distance[i]);
                }
            }
        }
    }

    public void printPath(int currentVertex, int[] parent) {
        if (currentVertex == -1) {
            return;
        }
        printPath(parent[currentVertex], parent);
        System.out.print(toChar(currentVertex) + " ");
    }

    class Node {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}

