import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        GraphUtils gu = new GraphUtils();
        for(int i = 0; i < 5; i++) {
            graph.addVertex(String.valueOf(i));
        }
        ArrayList<Vertex> vertices = graph.getVertices();
        graph.addEdge(vertices.get(0).getLabel(), vertices.get(1).getLabel(), 5);
        graph.addEdge(vertices.get(0).getLabel(), vertices.get(4).getLabel(), 1);
        graph.addEdge(vertices.get(1).getLabel(), vertices.get(2).getLabel(), 2);
        graph.addEdge(vertices.get(1).getLabel(), vertices.get(3).getLabel(), 8);
        graph.addEdge(vertices.get(1).getLabel(), vertices.get(4).getLabel(), 13);
        graph.addEdge(vertices.get(2).getLabel(), vertices.get(3).getLabel(), 11);
        graph.addEdge(vertices.get(3).getLabel(), vertices.get(4).getLabel(), 4);

        // System.out.println(graph);
        // System.out.println("Graph has edge (4,3): " + graph.hasEdge(new Edge("4", "3", -1, false)));
        
        ArrayList<ArrayList<CustomPair>> retVal = gu.BFS(graph, vertices.get(0));
        ArrayList<CustomPair> anscestors = retVal.get(0);
        ArrayList<CustomPair> distances = retVal.get(1);

        for(CustomPair cp : anscestors) {
            System.out.println(cp.getVertex());
        }
    }
}