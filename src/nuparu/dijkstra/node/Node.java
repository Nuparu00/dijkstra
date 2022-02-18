package nuparu.dijkstra.node;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int distance = Integer.MAX_VALUE;

    public String name;
    public List<Edge> edges = new ArrayList<>();

    public Node(String name){
        this.name = name;
    }
}
