import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;


public class GraphUtils {

    public ArrayList<ArrayList<CustomPair>> BFS(Graph graph, Vertex start) {
        ArrayList<CustomPair> distances = new ArrayList<>();
        ArrayList<CustomPair> colors = new ArrayList<>();
        ArrayList<CustomPair> anscestors = new ArrayList<>();
        HashMap<Vertex, Integer> indices = new HashMap<>();

        int i = 0;
        distances.add(new CustomPair(start, 0));
        colors.add(new CustomPair(start, "Gray"));
        anscestors.add(new CustomPair(start, null));
        indices.put(start, new Integer(i++));

        for(Vertex vertex : graph.getVertices()) {
            if(!start.getLabel().equals(vertex.getLabel())) {
                CustomPair<Integer> distance = new CustomPair(vertex, Integer.MAX_VALUE);
                CustomPair<String> color = new CustomPair(vertex, "White");
                CustomPair<Vertex> anscestor = new CustomPair(vertex, null);
                distances.add(distance);
                colors.add(color);
                anscestors.add(anscestor);
                indices.put(vertex, new Integer(i++));
            }
        }

        Queue<Vertex> q = new ArrayDeque<>();
        q.add(start);

        while(!q.isEmpty()) {
            Vertex next = q.poll();
            int nextIndex = indices.get(next).intValue();
            int dist = -1;
            if(distances.get(nextIndex).getValue() instanceof Integer) {
                dist = distances.get(nextIndex).getValue().intValue();
            }
            for(Edge edge : graph.getGraph().get(next.getLabel())) {
                Vertex destination = edge.getDestination();
                int index = colors.indexOf(destination);
                if(colors.get(index).getValue().equals("White")) {
                    colors.get(index).setValue("Gray");
                    anscestors.get(index).setValue(next);
                    distances.get(index).setValue(dist + 1);
                }
            }
            colors.get(nextIndex).setValue("Black");
        }

        ArrayList<ArrayList<CustomPair>> retVal = new ArrayList<>();
        retVal.add(anscestors);
        retVal.add(distances);
        return retVal;
    }
}