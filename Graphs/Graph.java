import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<String, ArrayList<Edge>> adjacencyList;
    private ArrayList<Vertex> vertices;
    private boolean isBidirectional;

    public Graph() {
        this.adjacencyList = new HashMap<>();
        this.vertices = new ArrayList<>();
        this.isBidirectional = false;
    }

    public Graph(boolean isBidirectional) {
        this.adjacencyList = new HashMap<>();
        this.isBidirectional = isBidirectional;
    }

    public HashMap<String, ArrayList<Edge>> getGraph() {
        return this.adjacencyList;
    }

    public boolean isBidirectional() {
        return isBidirectional;
    }

    public void setBidirectional(boolean isBidirectional) {
        this.isBidirectional = isBidirectional;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void addVertex(String label) {
        getGraph().put(label, new ArrayList<Edge>());
        getVertices().add(new Vertex(label));
    }

    public void addEdge(String labelSource, String labelDestination, int weight) {
        if(!getGraph().containsKey(labelSource)) {
            addVertex(labelSource);
        }

        if(!getGraph().containsKey(labelDestination)) {
            addVertex(labelDestination);
        }

        Edge edge = new Edge(labelSource, labelDestination, weight, isBidirectional);
        getGraph().get(labelSource).add(edge);
        if(isBidirectional()) {
            Edge bidirectionalEdge = new Edge(labelDestination, labelSource, weight, isBidirectional);
            getGraph().get(labelDestination).add(bidirectionalEdge);
        }
    }

    public int getVerticesCount() {
        return getGraph().keySet().size();
    }

    public int getEdgesCount() {
        int count = 0;
        for(String label : getGraph().keySet()) {
            count += getGraph().get(label).size();
        }

        if(isBidirectional()) {
            count /= 2;
        }

        return count;
    }

    public boolean hasVertex(String label) {
        return getGraph().containsKey(label);
    }

    public boolean hasEdge(Edge edge) {
        return getGraph().get(edge.getSource().getLabel()).contains(edge);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for(String label : getGraph().keySet()) {
            builder.append(label + ": ");
            for(Edge edge : getGraph().get(label)) {
                builder.append(edge.toString() + " ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }

}