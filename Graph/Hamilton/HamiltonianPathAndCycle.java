package Hamilton;


import java.io.*;
import java.util.*;

public class HamiltonianPathAndCycle {
    private int V; // Number of vertices
    private List<Integer>[] adj; // Adjacency list representation

    // Constructor
    public HamiltonianPathAndCycle(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // Function to read the graph from a file
    public static HamiltonianPathAndCycle readGraph(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        int vertices = Integer.parseInt(br.readLine().trim());
        HamiltonianPathAndCycle graph = new HamiltonianPathAndCycle(vertices);
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            int v = Integer.parseInt(parts[0]);
            int w = Integer.parseInt(parts[1]);
            graph.addEdge(v, w);
        }
        br.close();
        return graph;
    }

    // Utility function to check if the vertex v can be added at position pos in path[]
    boolean isSafe(int v, int[] path, int pos) {
        // Check if this vertex is an adjacent vertex of the previously added vertex
        if (!adj[path[pos - 1]].contains(v)) {
            return false;
        }

        // Check if the vertex has already been included
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }

        return true;
    }

    // A recursive utility function to solve Hamiltonian Path problem
    boolean hamCycleUtil(int[] path, int pos) {
        // Base case: If all vertices are included in the path
        if (pos == V) {
            // And if there is an edge from the last included vertex to the first vertex
            return adj[path[pos - 1]].contains(path[0]);
        }

        // Try different vertices as a next candidate in Hamiltonian Cycle
        for (int v = 1; v < V; v++) {
            // Check if this vertex can be added to Hamiltonian Cycle
            if (isSafe(v, path, pos)) {
                path[pos] = v;

                // Recur to construct the rest of the path
                if (hamCycleUtil(path, pos + 1)) {
                    return true;
                }

                // If adding vertex v doesn't lead to a solution, remove it
                path[pos] = -1;
            }
        }

        // If no vertex can be added to Hamiltonian Cycle constructed so far, then return false
        return false;
    }

    // This function solves the Hamiltonian Cycle problem using Backtracking.
    int[] hamCycle() {
        int[] path = new int[V];
        Arrays.fill(path, -1);

        // Let us put vertex 0 as the first vertex in the path. If there is a Hamiltonian Cycle,
        // then the path can be started from any point of the cycle as the graph is undirected
        path[0] = 0;
        if (!hamCycleUtil(path, 1)) {
            System.out.println("No Hamiltonian Cycle exists");
            return null;
        }

        return path;
    }

    // Print Hamiltonian Cycle
    void printHamCycle(int[] path) {
        for (int i = 0; i < V; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]);
    }

    // A recursive utility function to solve Hamiltonian Path problem
    boolean hamPathUtil(int[] path, int pos) {
        // Base case: If all vertices are included in the path
        if (pos == V) {
            return true;
        }

        // Try different vertices as a next candidate in Hamiltonian Path
        for (int v = 1; v < V; v++) {
            // Check if this vertex can be added to Hamiltonian Path
            if (isSafe(v, path, pos)) {
                path[pos] = v;

                // Recur to construct the rest of the path
                if (hamPathUtil(path, pos + 1)) {
                    return true;
                }

                // If adding vertex v doesn't lead to a solution, remove it
                path[pos] = -1;
            }
        }

        // If no vertex can be added to Hamiltonian Path constructed so far, then return false
        return false;
    }

    // This function solves the Hamiltonian Path problem using Backtracking.
    int[] hamPath() {
        int[] path = new int[V];
        Arrays.fill(path, -1);

        // Try different starting points for Hamiltonian Path
        for (int i = 0; i < V; i++) {
            path[0] = i;
            if (hamPathUtil(path, 1)) {
                return path;
            }
            Arrays.fill(path, -1);
        }

        System.out.println("No Hamiltonian Path exists");
        return null;
    }

    // Print Hamiltonian Path
    void printHamPath(int[] path) {
        for (int i = 0; i < V; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        HamiltonianPathAndCycle g = readGraph("HamintonInput.txt");

        System.out.println("Hamiltonian Cycle (if exists):");
        int[] cycle = g.hamCycle();
        if (cycle != null) {
            g.printHamCycle(cycle);
        }

        System.out.println("Hamiltonian Path (if exists):");
        int[] path = g.hamPath();
        if (path != null) {
            g.printHamPath(path);
        }
    }
    
}
