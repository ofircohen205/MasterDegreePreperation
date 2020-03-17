package DataStructures.WightedDirectedGraph;

import java.util.ArrayList;
import java.util.HashSet;
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
        vertices = new HashSet<>();
    }

    public List<Vertex> getVertices() {
        return new ArrayList<>(vertices);
    }

    public boolean addVertex(Vertex vertex){
        return vertices.add(vertex);
    }

    public void removeVertex(Vertex vertex) {
        /* TODO: remove all connected edges */
        vertices.remove(vertex);
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
        int count = 0;
        for(Vertex v : vertices){
            if(count < vertices.size() - 1){
                res += v.toString() + " ---> ";
            }
            else{
                res += v.toString();
            }
            count++;
        }
        return res;
    }
 
}