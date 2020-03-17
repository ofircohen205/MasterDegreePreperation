package DataStructures.WightedDirectedGraph;

public class Edge{
    private int capacity, value;
    private Vertex to;
    
    public Edge(int capacity,int value, Vertex to){
        this.capacity = capacity;
        this.value = value;
        this.to = to;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Vertex getToVertex() {
        return to;
    }

    public void setToVertex(Vertex to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Edge [" + capacity + "/" + value + "]";
    }

    
}