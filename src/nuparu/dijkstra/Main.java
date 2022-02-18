package nuparu.dijkstra;

import nuparu.dijkstra.node.Edge;
import nuparu.dijkstra.node.Graph;
import nuparu.dijkstra.node.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Graph graph = createGraph();
        String start = "E";
        String end = "F";

        graph.getNodeByName(start).distance = 0;

        List<Node> unprocessedNodes = graph.nodes.values().stream().collect(Collectors.toCollection(ArrayList::new));

        while(true) {
            List<Node> mins = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for (Node node : unprocessedNodes) {
                if (node.distance != Integer.MAX_VALUE) {
                    if (node.distance < min) {
                        mins = new ArrayList<>();
                        min = node.distance;;
                        mins.add(node);
                    } else if (node.distance == min) {
                        mins.add(node);
                    }
                }
            }
            if(mins.isEmpty()) break;

            unprocessedNodes.removeAll(mins);

            for(Node node : mins){
                for(Edge edge : node.edges){
                    Node other = edge.getOther(node);
                    if(unprocessedNodes.contains(other)){
                        other.distance = Math.min(other.distance,node.distance + edge.value);
                    }
                }
            }


        }

        for(Node node : graph.nodes.values()){
            System.out.println("Distance of " + node.name + " is " + node.distance);
        }

    }

    public static Graph createGraph() {
        Graph graph = new Graph();

        graph.createNode("A");
        graph.createNode("B");
        graph.createNode("C");
        graph.createNode("D");
        graph.createNode("E");
        graph.createNode("F");
        graph.createNode("G");
        graph.createNode("H");
        graph.createNode("I");
        graph.createNode("J");
        graph.createNode("K");

        graph.createEdge("A","B",3);
        graph.createEdge("A","D",2);
        graph.createEdge("B","C",4);
        graph.createEdge("B","E",2);
        graph.createEdge("B","I",7);
        graph.createEdge("C","F",10);
        graph.createEdge("C","I",2);
        graph.createEdge("F","I",6);
        graph.createEdge("F","K",5);
        graph.createEdge("K","I",8);
        graph.createEdge("K","H",6);
        graph.createEdge("H","E",5);
        graph.createEdge("H","G",1);
        graph.createEdge("H","J",6);
        graph.createEdge("E","G",3);
        graph.createEdge("G","J",11);
        graph.createEdge("D","G",9);
        graph.createEdge("D","J",1);

        return graph;
    }
}
