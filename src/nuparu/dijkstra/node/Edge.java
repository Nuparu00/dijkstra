package nuparu.dijkstra.node;

public class Edge {
    public Node start;
    public Node end;
    public int value;

    public Edge(Node start, Node end, int value){
        this.start = start;
        this.end = end;
        this.value = value;
    }

    public Node getOther(Node node){
        if(node == start){
            return end;
        }
        else if(node == end){
            return start;
        }
        return null;
    }
}
