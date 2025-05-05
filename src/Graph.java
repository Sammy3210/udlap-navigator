import java.util.*;

public class Graph {
    private final Map<String, Map<String, Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(String from, String to, int weight) {
        adjList.putIfAbsent(from, new HashMap<>());
        adjList.putIfAbsent(to, new HashMap<>());
        adjList.get(from).put(to, weight);
        adjList.get(to).put(from, weight);
    }

    public Map<String, Integer> getNeighbors(String node) {
        return adjList.getOrDefault(node, new HashMap<>());
    }

    public Set<String> getNodes() {
        return adjList.keySet();
    }
}
