package DataStructures.WightedDirectedGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vertex{
    private String label;
    private Set<Edge> edges;

    public Vertex(String label){
        this.label = label;
        edges = new HashSet<>();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean addEdge(Edge edge){
        return edges.add(edge);
    }

    public List<Edge> getEdges() {
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

    @Override
    public String toString() {
        return "(Vertex " + label + ")";
    }
    
}