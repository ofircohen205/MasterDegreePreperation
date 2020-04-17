import java.util.*;

public class GraphUtils {

    private final static String NEW = "WHITE";
    private final static String VISITED = "GRAY";
    private final static String DONE = "BLACK";
    private StringBuilder path = new StringBuilder();
    private boolean isBipartite = false;
    private static int time = 0;

    // BFS Helpers arrays
    private HashMap<String, String> anscestorsBFS = new HashMap<>();
    private HashMap<String, Integer> distancesBFS = new HashMap<>();

    // DFS Helpers arrays
    private HashMap<String, String> anscestorsDFS = new HashMap<>();
    private HashMap<String, Integer> startDFS = new HashMap<>();
    private HashMap<String, Integer> endDFS = new HashMap<>();
    private HashMap<String, String> colorsDFS = new HashMap<>();


    public HashMap<String, String> getAnscestorsBFS() {
        return anscestorsBFS;
    }

    public HashMap<String, Integer> getDistancesBFS() {
        return distancesBFS;
    }

    public HashMap<String, String> getAnscestorsDFS() {
        return anscestorsDFS;
    }

    public HashMap<String, Integer> getStartDFS() {
        return startDFS;
    }

    public HashMap<String, Integer> getEndDFS() {
        return endDFS;
    }

    public HashMap<String, String> getColorsDFS() {
        return colorsDFS;
    }

    public String getPath() {
        return path.toString();
    }

    public boolean isBipartite() {
        return isBipartite;
    }

    public void BFS(CustomGraph graph, String source) {
        getDistancesBFS().put(source, 0);
        getAnscestorsBFS().put(source, null);

        HashMap<String, String> colors = new HashMap<>();
        colors.put(source, VISITED);
        for(String vertex : graph.getVertices()) {
            getDistancesBFS().put(vertex, Integer.MAX_VALUE);
            getAnscestorsBFS().put(vertex, null);
            colors.put(vertex, NEW);
        }

        Queue queue = new ArrayDeque<>();
        queue.add(source);
        while(!queue.isEmpty()) {
            String vertex = queue.poll().toString();
            int distance = getDistancesBFS().get(vertex).intValue();
            ArrayList<CustomVertex> neighbours = graph.getNeighbours(vertex);
            for(CustomVertex neighbour : neighbours) {
                String neighbourLabel = neighbour.getLabel();
                if(colors.get(neighbourLabel).equals(NEW)) {
                    colors.replace(neighbourLabel, VISITED);
                    getAnscestorsBFS().replace(neighbourLabel, vertex);
                    getDistancesBFS().replace(neighbourLabel, distance+1);
                    queue.add(neighbourLabel);
                } else if(getDistancesBFS().get(vertex).equals(getDistancesBFS().get(neighbourLabel))) {
                    isBipartite = true;
                }
            }
            colors.replace(vertex, DONE);
        }
    }

    public void PrintPathBFS(String source, String destination) {
        if(source.equals(destination)) {
            path.append(source + "->");
        } else {
            if(getAnscestorsBFS().get(destination).equals(null)) {
                path.append("No path between" + source + " and " + destination);
                return;
            } else {
                PrintPathBFS(source, getAnscestorsBFS().get(destination));
                path.append(destination + "->");
            }
        }
    }

    public void DFS(CustomGraph graph, String source) {
        for(String vertex : graph.getVertices()) {
            getAnscestorsDFS().put(vertex, null);
            getColorsDFS().put(vertex, NEW);
        }

        for(String vertex : graph.getVertices()) {
            String color = getColorsDFS().get(vertex);
            if(color.equals(NEW)) {
                DFS_Visit(graph, vertex);
            }
        }
    }

    public void DFS_Visit(CustomGraph graph, String vertex) {
        getColorsDFS().replace(vertex, VISITED);
        getStartDFS().put(vertex, new Integer(++time));

        ArrayList<CustomVertex> neighbours = graph.getNeighbours(vertex);
        for(CustomVertex neighbour : neighbours) {
            String neighbourLabel = neighbour.getLabel();
            if(getColorsDFS().get(neighbourLabel).equals(NEW)) {
                getAnscestorsDFS().replace(neighbourLabel, vertex);
                DFS_Visit(graph, neighbourLabel);
            }
        }

        getColorsDFS().replace(vertex, DONE);
        getEndDFS().put(vertex, new Integer(++time));
    }

}