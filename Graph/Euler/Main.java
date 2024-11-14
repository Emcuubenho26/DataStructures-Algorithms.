package Euler;

import static Euler.EulerPathAndCycle.readGraph;
import java.io.IOException;

/**
 *
 * @author VU VAN HUY
 */
public class Main {
    public static void main(String[] args) throws IOException {
        EulerPathAndCycle g = readGraph("EulerInput.txt");

        int res = g.isEulerian();
        if (res == 0) System.out.println("Graph is not Eulerian");
        else if (res == 1) {
            System.out.println("Graph has an Eulerian Path");
            g.printEulerTour();
        } else {
            System.out.println("Graph has an Eulerian Cycle");
            g.printEulerTour();
        }
    }    
}
