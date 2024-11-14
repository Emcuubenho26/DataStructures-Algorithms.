
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    int[][] adj;
    int size;

    public Graph(String fname) throws FileNotFoundException, IOException {
        try {
            RandomAccessFile rf = new RandomAccessFile(fname, "r");
            size = Integer.parseInt(rf.readLine());
            adj = new int[size][size];
            for (int i = 0; i < size; i++) {
                String[] line = rf.readLine().trim().split("\\s+");
                for (int j = 0; j < line.length; j++) {
                    adj[i][j] = Integer.parseInt(line[j]);
                }
            }
            rf.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public char toChar(int i) {
        return (char) (i + 65);
    }

    public int toInt(char c) {
        return (c - 65);
    }

    public void visit(char v) {
        System.out.print(v + " ");
    }

    public void BFS(int i) {
        boolean[] visited = new boolean[size];
        Arrays.fill(visited, false);
        Queue<Integer> myQ = new LinkedList<>();
        myQ.add(i);
        while (!myQ.isEmpty()) {
            int v = myQ.poll();
            visit(toChar(v));
            visited[v] = true;
            for (int j = 0; j < size; j++) {
                if (!visited[j] && adj[v][j] != 0) {
                    myQ.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    public void depth_First_Traversal(int x, boolean[] visited) {
        visit(toChar(x));
        visited[x] = true;
        for (int i = 0; i < size; i++) {
            if (!visited[i] && adj[i][x] != 0) {
                depth_First_Traversal(i, visited);  //Recursive
            }
        }
    }

    public void DFSGraph(char v) {
        boolean[] visited = new boolean[size];
        Arrays.fill(visited, false);
        depth_First_Traversal(toInt(v), visited);
    }

    public int deg(char v) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (adj[toInt(v)][i] != 0) {
                count++;
            }
        }
        return count;
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
