package uk.co.gluedit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    private class Edges {
        public Node n;
        public ArrayList<Edge> edges;

        public Edges(Node n) {
            this.n = n;
            this.edges = new ArrayList<>();
        }
    };

    private Integer next_index;
    private HashMap<Node, Integer> nodes;
    private ArrayList<Edges> adj_list;

    public Graph() {
        nodes = new HashMap<>();
        next_index = 0;
        adj_list = new ArrayList<>();
    }
    public List<Node> nodes() {
        if (nodes.keySet().isEmpty())
            return null;
        return new ArrayList<>(nodes.keySet());
    }
    public List<Edge> edgesForNode(Node n) {
        if (n == null)
            return null;
        return adj_list.get(nodes.get(n)).edges;
    }
    public void addNode(Node n) {
        if (n != null) {
            nodes.put(n, next_index);
            adj_list.add(new Edges(n));
            next_index++;
        }
    }
}