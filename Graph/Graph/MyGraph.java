package Graph;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class MyGraph {
    int [][]adj;
    int size;

    public MyGraph() {
        try {
            String fName="inputGraph.txt";
            RandomAccessFile fIn = new RandomAccessFile(fName, "r");
            size = Integer.parseInt(fIn.readLine());
            adj = new int[size][size];
            String line="";
            for (int i = 0; i < size; i++) {
                line=fIn.readLine();
                String []s=line.split("\\s+");
                for (int j = 0; j < s.length; j++) {
                    adj[i][j] = Integer.parseInt(s[j]);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }   
    char toChar(int x){
        return (char)(x+65);
    }
    
    int toInt (char c){
        return (c-65);
    }
    public void visit(char v) {
        System.out.print(v + " ");
    }
    public void breadth_First_Traversal(char v) {
        boolean []visited = new boolean[size];
        Arrays.fill(visited, false);    //All vertices not visited
        Queue <Integer> myQ = new LinkedList<>();
        myQ.add(toInt(v));
        while (!myQ.isEmpty()){
            int p = myQ.poll();
            visited[p]=true;
            for (int i = 0; i < size; i++) {
                if (!visited[i] && adj[i][p]!=0) {
                    visited[i]=true;
                    myQ.add(i);
                }
            }
            visit(toChar(p));
        }
    }
    
    public int graphDeg(char x) {
        int count=0;
        for (int i = 0; i < size; i++) {
            if (adj[i][toInt(x)]!=0) count++;
        }
        return count;
    }     
    
    public void depth_First_Traversal(int x, boolean []visited) {
        visit(toChar(x));
        visited[x]=true;
        for (int i = 0; i < size; i++) {
            if (!visited[i] && adj[i][x]!=0) {
                depth_First_Traversal(i, visited);  //Recursive
            }
        }        
    }  
       
    public void DFSGraph(char v) {
        boolean []visited = new boolean[size];
        Arrays.fill(visited, false);
        depth_First_Traversal(toInt(v), visited);
    }
    
    public void show() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(adj[i][j]+" ");
            }
            System.out.println("");
        }
    }    
}
