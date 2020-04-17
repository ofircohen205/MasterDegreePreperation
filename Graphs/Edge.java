
public class Edge {

    private Vertex source, destination;
    private int weight, capacity;
    private boolean isBidirectional;

    public Edge(String labelSource, String labelDestination,int weight, boolean isBidirectional) {
        this.source = new Vertex(labelSource);
        this.destination = new Vertex(labelDestination);
        this.weight = weight;
        this.isBidirectional = isBidirectional;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isBidirectional() {
        return isBidirectional;
    }

    public void setBidirectional(boolean isBidirectional) {
        this.isBidirectional = isBidirectional;
    }

    @Override
    public String toString() {
        return "(Source: " + getSource() + ", Destination: " + getDestination() + ", Weight: " + getWeight() + ")";
    }
}