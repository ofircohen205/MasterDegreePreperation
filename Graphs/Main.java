import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CustomGraph graph = new CustomGraph();
        GraphUtils gu = new GraphUtils();
        for(int i = 0; i < 5; i++) {
            graph.addVertex(String.valueOf(i));
        }
        ArrayList<String> vertices = graph.getVertices();
        graph.addEdge(vertices.get(0), vertices.get(1), 5);
        graph.addEdge(vertices.get(0), vertices.get(4), 1);
        graph.addEdge(vertices.get(1), vertices.get(2), 2);
        graph.addEdge(vertices.get(1), vertices.get(3), 8);
        graph.addEdge(vertices.get(1), vertices.get(4), 13);
        graph.addEdge(vertices.get(2), vertices.get(3), 11);
        graph.addEdge(vertices.get(3), vertices.get(4), 4);

        System.out.println(graph);
        System.out.println("CustomGraph has edge (4,3): " + graph.hasEdge(vertices.get(4), vertices.get(3)));
        
        gu.BFS(graph, vertices.get(0));
        System.out.println(gu.getAnscestorsBFS());
        System.out.println("Graph bipartite: " + gu.isBipartite());
        gu.PrintPathBFS(vertices.get(0), vertices.get(3));
        System.out.println(gu.getPath());

        gu.DFS(graph, vertices.get(0));
        System.out.println(gu.getAnscestorsDFS());
    }
}