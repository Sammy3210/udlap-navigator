import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class NavigatorGUI extends JFrame {
    private JComboBox<String> comboOrigen;
    private JComboBox<String> comboDestino;
    private JTextArea resultado;

    private static final Map<String, String> nombresNodos = new HashMap<>();
    private static final String[] nodos;

    static {
        nombresNodos.put("A", "Humanidades");
        nombresNodos.put("B", "Ágora");
        nombresNodos.put("C", "Hacienda");
        nombresNodos.put("D", "Negocios");
        nombresNodos.put("E", "Auditorio");
        nombresNodos.put("F", "Ingeniería");
        nombresNodos.put("G", "Biblioteca");
        nombresNodos.put("H", "Cafetería");
        nombresNodos.put("I", "Servicios Médicos");
        nombresNodos.put("J", "Salud");
        nombresNodos.put("K", "Alberca");
        nombresNodos.put("L", "Gimnasio");
        nombresNodos.put("M", "Sorteo");
        nombresNodos.put("N", "Atletismo");
        nombresNodos.put("O", "Templo del Dolor");

        nodos = nombresNodos.entrySet().stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toArray(String[]::new);
    }

    public NavigatorGUI(Graph graph) {
        setTitle("Navegador UDLAP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Origen: "));
        comboOrigen = new JComboBox<>(nodos);
        topPanel.add(comboOrigen);

        topPanel.add(new JLabel("Destino: "));
        comboDestino = new JComboBox<>(nodos);
        topPanel.add(comboDestino);

        JButton calcular = new JButton("Calcular Ruta");
        topPanel.add(calcular);

        resultado = new JTextArea();
        resultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultado);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String origen = comboOrigen.getSelectedItem().toString().substring(0, 1);
                String destino = comboDestino.getSelectedItem().toString().substring(0, 1);

                Dijkstra.Result res = Dijkstra.shortestPath(graph, origen, destino);
                StringBuilder sb = new StringBuilder();
                sb.append("Ruta óptima: ");
                List<String> path = res.getPath();
                for (int i = 0; i < path.size(); i++) {
                    String nodo = path.get(i);
                    sb.append(nodo).append(" (" + nombresNodos.get(nodo) + ")");
                    if (i < path.size() - 1) sb.append(" -> ");
                }
                sb.append("\nTiempo estimado: ").append(res.getTotalCost()).append(" minutos");

                resultado.setText(sb.toString());
            }
        });

        setContentPane(panel);
    }

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
        graph.addEdge("G", "M", 4);
        graph.addEdge("M", "O", 7);
        graph.addEdge("O", "J", 4);
        graph.addEdge("O", "N", 2);
        graph.addEdge("L", "N", 1);

        SwingUtilities.invokeLater(() -> {
            new NavigatorGUI(graph).setVisible(true);
        });
    }
}