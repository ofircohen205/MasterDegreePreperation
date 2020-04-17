
public class CustomPair<T> {

    private Vertex vertex;
    private T value;

    public CustomPair(Vertex vertex, T value) {
        this.vertex = new Vertex(vertex.getLabel());
        this.value = value;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}