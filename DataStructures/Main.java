import WightedDirectedGraph.Graph;
import WightedDirectedGraph.Vertex;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Graph G = new Graph();
        
        // Adding Vertecies
        Vertex v1 = new Vertex("S");
        Vertex v2 = new Vertex("A");
        Vertex v3 = new Vertex("E");
        Vertex v4 = new Vertex("B");
        Vertex v5 = new Vertex("C");
        Vertex v6 = new Vertex("F");
        Vertex v7 = new Vertex("T");
        
        G.addVertex(v1);
        G.addVertex(v2);
        G.addVertex(v3);
        G.addVertex(v4);
        G.addVertex(v5);
        G.addVertex(v6);
        G.addVertex(v7);

        /*          E ---> C --->
            s --->  A ----------> T
                    B ---> F --->
        */

        G.addEdge(G.getVertex(v1), G.getVertex(v2), 5, 0);
        G.addEdge(G.getVertex(v1), G.getVertex(v3), 3, 0);
        G.addEdge(G.getVertex(v1), G.getVertex(v4), 10, 0);
        G.addEdge(G.getVertex(v3), G.getVertex(v5), 9, 0);
        G.addEdge(G.getVertex(v4), G.getVertex(v6), 12, 0);
        G.addEdge(G.getVertex(v2), G.getVertex(v7), 1, 0);
        G.addEdge(G.getVertex(v5), G.getVertex(v7), 2, 0);
        G.addEdge(G.getVertex(v6), G.getVertex(v7), 12, 0);

        System.out.println(G);
    }
}