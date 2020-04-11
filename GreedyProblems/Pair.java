
public class Pair<S, F> {
    
    public final F first;
    public final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public String toString() {
        return "Pair{" + String.valueOf(first) + ", " + String.valueOf(second) + "}";
    }
}