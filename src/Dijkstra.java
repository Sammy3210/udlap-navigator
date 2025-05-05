import java.util.*;

public class Dijkstra {
    public static Result shortestPath(Graph graph, String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

        for (String node : graph.getNodes()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.name.equals(end)) break;

            for (Map.Entry<String, Integer> neighbor : graph.getNeighbors(current.name).entrySet()) {
                int newDist = distances.get(current.name) + neighbor.getValue();
                if (newDist < distances.get(neighbor.getKey())) {
                    distances.put(neighbor.getKey(), newDist);
                    previous.put(neighbor.getKey(), current.name);
                    pq.add(new Node(neighbor.getKey(), newDist));
                }
            }
        }

        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        return new Result(path, distances.get(end));
    }

    public static class Node {
        String name;
        int cost;

        public Node(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }
    }

    public static class Result {
        List<String> path;
        int totalCost;

        public Result(List<String> path, int totalCost) {
            this.path = path;
            this.totalCost = totalCost;
        }

        public List<String> getPath() {
            return path;
        }

        public int getTotalCost() {
            return totalCost;
        }
    }
}
