import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph {

    private class Node{
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }
        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge{
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }
    public void addEdge(String from, String to, int weight) {
        var fromNode = nodes.get(from);
        if(fromNode == null){
            return;
        }
        var toNode = nodes.get(to);
        if(toNode == null){
            return;
        }
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }
    public void print() {
        for (var node : nodes.values()) {
            var edges = node.getEdges();
            if (!edges.isEmpty()){
                System.out.println(node + " is connected to " + edges);
            }
        }
    }
}
