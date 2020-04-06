package WightedDirectedGraph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Directed and Weighted Graph Implementation
 */
public class Graph{

    /**
     * @param vertices respresent the graph vertices
    */

    private Set<Vertex> vertices;
        
    // constructor  
    public Graph() {  
        vertices = new LinkedHashSet<>();
    }

    public Vertex getRoot(){
        return getVertex(new ArrayList<>(vertices).get(0));
    }

    public Vertex getSink(){
        return getVertex(new ArrayList<>(vertices).get(vertices.size() - 1));
    }

    public List<Vertex> getVertices() {
        return new ArrayList<>(vertices);
    }

    public Vertex getVertex(Vertex vertex) {
        for(Vertex v : vertices){
            if(v.equals(vertex)){
                return v;
            }
        }
        return null;
    }

    public boolean addEdge(Vertex v1, Vertex v2, int capacity, int value) {
        if ( !vertices.contains(v1) || !vertices.contains(v2) ) {return false; }
        Edge edge = new Edge(capacity, value, v2);
        v1.addEdge(edge);
        return true;
    }

    public boolean addVertex(Vertex vertex){
        return !vertices.contains(vertex) && vertices.add(vertex);
    }

    public void removeVertex(Vertex vertex) {
        // Undone for now, need to seperate for all cases;
        // Root, Middle, Sink
        // TODO: Remove vertex and edges
    }

    public void removeEdge(Vertex from, Vertex to){
        for(Edge edge : from.getEdges()){
            if(edge.getToVertex().equals(to)){
                from.getEdges().remove(edge);
            }
        }
    }

    public int getNumberOfVertext(){
        return vertices.size();
    }

    @Override
    public String toString() {
        String res = "";
        ArrayList<Vertex> vertices = new ArrayList<>(this.vertices);
        for(int i = 0; i < vertices.size() - 1; i++){
            Vertex v = vertices.get(i);
            res += v;
            for(Edge e: v.getEdges()){
                res += e + "\n";
            }
        }
        return res;
    }
 
}