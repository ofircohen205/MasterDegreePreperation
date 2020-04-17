import java.util.*;

public class CustomGraph {

    private HashMap<String, ArrayList<CustomVertex>> adjacencyList;
    private ArrayList<String> vertices;
    private boolean isBidirectional;

    public CustomGraph() {
        this.adjacencyList = new HashMap<>();
        this.vertices = new ArrayList<>();
        this.isBidirectional = false;
    }

    public CustomGraph(boolean isBidirectional) {
        this.adjacencyList = new HashMap<>();
        this.isBidirectional = isBidirectional;
    }

    public HashMap<String, ArrayList<CustomVertex>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(HashMap<String, ArrayList<CustomVertex>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public ArrayList<String> getVertices() {
        return vertices;
    }

    public ArrayList<CustomVertex> getNeighbours(String vertex) {
        return getAdjacencyList().get(vertex);
    }

    public boolean isBidirectional() {
        return isBidirectional;
    }

    public void setBidirectional(boolean isBidirectional) {
        this.isBidirectional = isBidirectional;
    }

    public void addVertex(String label) {
        getAdjacencyList().put(label, new ArrayList<CustomVertex>());
        getVertices().add(label);
    }

    public void addEdge(String source, String destination, int weight) {
        if(!getAdjacencyList().containsKey(source)) {
            addVertex(source);
        }

        if(!getAdjacencyList().containsKey(destination)) {
            addVertex(destination);
        }

        getAdjacencyList().get(source).add(new CustomVertex(destination, weight));
        if(isBidirectional()) {
            getAdjacencyList().get(destination).add(new CustomVertex(source, weight));
        }
    }

    public int getVerticesCount() {
        return getVertices().size();
    }

    public int getEdgesCount() {
        int count = 0;
        for(String vertex : getVertices()) {
            count += getAdjacencyList().get(vertex).size();
        }
        if(isBidirectional()) {
            count /= 2;
        }
        
        return count;
    }

    public boolean hasVertex(String label) {
        return getAdjacencyList().containsKey(label);
    }

    public boolean hasEdge(String source, String destination) {
        CustomVertex dest = getVertexByLabel(source, destination);
        return dest != null ? getAdjacencyList().get(source).contains(dest) : false;
    }

    private CustomVertex getVertexByLabel(String source, String destination) {
        ArrayList<CustomVertex> neighbours = getNeighbours(source);
        for(CustomVertex vertex : neighbours) {
            if(vertex.getLabel().equals(destination)) {
                return vertex;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for(String labelVertex : getAdjacencyList().keySet()) {
            builder.append(labelVertex + ": ");
            for(CustomVertex vertex : getAdjacencyList().get(labelVertex)) {
                builder.append("(Source: " + labelVertex + ", " + vertex + " ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }

}