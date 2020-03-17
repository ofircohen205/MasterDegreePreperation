package DataStructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Edge{
    private int capacity, value;
    private Vertex to;
    
    Edge(int capacity,int value, Vertex to){
        this.capacity = capacity;
        this.value = value;
        this.to = to;
    }

    int getCapacity() {
        return capacity;
    }

    void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    Vertex getToVertex() {
        return to;
    }

    void setToVertex(Vertex to) {
        this.to = to;
    }
}

class Vertex{
    private String label;
    private Set<Edge> edges;

    Vertex(String label){
        this.label = label;
        edges = new HashSet<>();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    boolean addEdge(Edge edge){
        return edges.add(edge);
    }

    List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (edges == null) {
            if (other.edges != null)
                return false;
        } else if (!edges.equals(other.edges))
            return false;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        return true;
    }
    
}

/**
 * Directed and Weighted Graph Implementation
 */
public class Graph{

    /**
     * @param vertices respresent the graph vertices
    */

    private Set<Vertex> vertices;
        
    // constructor  
    Graph() {  
        vertices = new HashSet<>();
    }

    List<Vertex> getVertices() {
        return new ArrayList<>(vertices);
    }

    boolean addVertex(Vertex vertex){
        return vertices.add(vertex);
    }

    void removeVertex(Vertex vertex) {
        /* TODO: remove all connected edges */
        vertices.remove(vertex);
    }

    void removeEdge(Vertex from, Vertex to){
        for(Edge edge : from.getEdges()){
            if(edge.getToVertex().equals(to)){
                from.getEdges().remove(edge);
            }
        }
    }

    int getNumberOfVertext(){
        return vertices.size();
    }
}