import DataStructures.WightedDirectedGraph.Graph;
import DataStructures.WightedDirectedGraph.Vertex;

import java.util.ArrayList;

import DataStructures.WightedDirectedGraph.Edge;



/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Graph G = new Graph();
        
        // Adding Vertecies
        String[] labels = {"S", "A", "E", "B", "C", "D", "F", "H", "Q", "T"};
        for (String label: labels){
            G.addVertex(new Vertex(label));
        }

        System.out.println(G);

    }
}