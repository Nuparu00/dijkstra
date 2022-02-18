package nuparu.dijkstra.node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    public HashMap<String,Node> nodes = new HashMap<>();
    public List<Edge> edges = new ArrayList<>();

    public Node createNode(String name){
        Node node = new Node(name);
        nodes.put(name,node);
        return node;
    }

    public Node getNodeByName(String name){
        return nodes.getOrDefault(name,null);
    }

    public Edge createEdge(String a, String b, int value) {
        Edge edge = createEdge(getNodeByName(a), getNodeByName(b), value);
        edges.add(edge);
        return edge;
    }

    private Edge createEdge(Node a, Node b, int value) {
        Edge edge = new Edge(a, b, value);
        a.edges.add(edge);
        b.edges.add(edge);

        return edge;
    }
}
