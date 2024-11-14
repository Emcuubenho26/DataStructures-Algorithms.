package Euler;
import java.io.*;
import java.util.*;

public class EulerPathAndCycle {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list representation

    // Constructor
    public EulerPathAndCycle(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // Function to read the graph from a file
    public static EulerPathAndCycle readGraph(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        int vertices = Integer.parseInt(br.readLine().trim());
        EulerPathAndCycle graph = new EulerPathAndCycle(vertices);
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            int v = Integer.parseInt(parts[0]);
            int w = Integer.parseInt(parts[1]);
            graph.addEdge(v, w);
        }
        br.close();
        return graph;
    }

    // Method to check if all non-zero degree vertices are connected
    boolean isConnected() {
        boolean[] visited = new boolean[V];
        int i;
        for (i = 0; i < V; i++) {
            if (adj[i].size() != 0) break;
        }

        if (i == V) return true;

        DFSUtil(i, visited);

        for (i = 0; i < V; i++) {
            if (visited[i] == false && adj[i].size() != 0) return false;
        }

        return true;
    }

    // A function to perform DFS traversal
    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n]) DFSUtil(n, visited);
        }
    }

    // Function to check if a given graph has an Eulerian Path or Cycle
    int isEulerian() {
        if (!isConnected()) return 0;

        int odd = 0;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 != 0) odd++;
        }

        if (odd > 2) return 0;
        return (odd == 2) ? 1 : 2;
    }

    // Function to print Eulerian Path or Cycle
    void printEulerUtil(int u) {
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u].get(i);

            if (isValidNextEdge(u, v)) {
                System.out.print(u + "-" + v + " ");
                removeEdge(u, v);
                printEulerUtil(v);
            }
        }
    }

    // Function to check if the edge u-v can be considered as next edge in Eulerian path
    boolean isValidNextEdge(int u, int v) {
        if (adj[u].size() == 1) return true;

        boolean[] isVisited = new boolean[V];
        int count1 = DFSCount(u, isVisited);

        removeEdge(u, v);
        isVisited = new boolean[V];
        int count2 = DFSCount(u, isVisited);

        addEdge(u, v);

        return (count1 <= count2);
    }

    // Function to count reachable vertices from v
    int DFSCount(int v, boolean[] visited) {
        visited[v] = true;
        int count = 1;
        for (int adjVertex : adj[v]) {
            if (!visited[adjVertex]) count += DFSCount(adjVertex, visited);
        }
        return count;
    }

    // Function to remove an edge from the graph
    void removeEdge(int u, int v) {
        adj[u].remove((Integer) v);
        adj[v].remove((Integer) u);
    }

    // Function to print Eulerian Path or Cycle
    void printEulerTour() {
        int u = 0;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 == 1) {
                u = i;
                break;
            }
        }
        printEulerUtil(u);
        System.out.println();
    }
}

