package DataStructures;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

import DataStructures.WightedDirectedGraph.Graph;
import DataStructures.WightedDirectedGraph.Vertex;

/**
 * GraphUtils
 */
public class GraphUtils {

    /*
    * Depth First Traversal -> O(|E| + |H|)
    */
    public static Set<Vertex> DFS(Graph graph, Vertex root) {
        Set<Vertex> visited = new LinkedHashSet<Vertex>();
        Stack<Vertex> stack = new Stack<Vertex>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getVertices()) {              
                    stack.push(v);
                }
            }
        }
        return visited;
    }
}