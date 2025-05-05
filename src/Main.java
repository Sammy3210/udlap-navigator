import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge("A", "C", 6);
        graph.addEdge("C", "D", 5);
        graph.addEdge("D", "E", 4);
        graph.addEdge("A", "B", 6);
        graph.addEdge("B", "F", 5);
        graph.addEdge("F", "G", 4);
        graph.addEdge("G", "H", 2);
        graph.addEdge("H", "I", 3);
        graph.addEdge("I", "J", 2);
        graph.addEdge("J", "K", 4);
        graph.addEdge("K", "L", 2);
        graph.addEdge("L", "N", 1);
        graph.addEdge("G", "M", 4);
        graph.addEdge("M", "O", 7);
        graph.addEdge("O", "J", 4);
        graph.addEdge("O", "N", 2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Navegador UDLAP ---");
        System.out.print("Lugar de origen (A-O): ");
        String start = scanner.next().toUpperCase();
        System.out.print("Lugar de destino (A-O): ");
        String end = scanner.next().toUpperCase();

        Dijkstra.Result result = Dijkstra.shortestPath(graph, start, end);
        System.out.println("Ruta óptima: " + String.join(" -> ", result.getPath()));
        System.out.println("Tiempo estimado: " + result.getTotalCost() + " minutos");
    }
}
