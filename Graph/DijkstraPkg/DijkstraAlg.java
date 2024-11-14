package DijkstraPkg;

import java.io.RandomAccessFile;
import java.util.Arrays;

public class DijkstraAlg {

    private final int INF = 99;

    public int[][] readGraph(String fname) {
        int[][] adj = null;
        try {
            RandomAccessFile rf = new RandomAccessFile(fname, "r");
            int n = Integer.parseInt(rf.readLine());
            adj = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] line = rf.readLine().split("\\s+");
                for (int j = 0; j < line.length; j++) {
                    adj[i][j] = Integer.parseInt(line[j]);
                }
            }
            rf.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return adj;
    }

    public int[] dijsktra(int[][] graph, int start) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(visited, false);
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = shortestDistance(distance, visited);
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && distance[u] != Integer.MAX_VALUE
                        && graph[u][v] != INF && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        return distance;
    }

    public int shortestDistance(int[] distance, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minVertex = i;
            }
        }
        return minVertex;
    }

    public void show(int[][] a) {
        int size = 6;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
