package uk.co.gluedit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {
    private class Edges {
        public Node n;
        public ArrayList<Edge> edges;

        public Edges(Node n) {
            this.n = n;
            this.edges = new ArrayList<>();
        }
    }

    ;

    private Integer next_index;
    private HashMap<String, Integer> nodes;
    private ArrayList<Edges> adj_list;

    public Graph() {
        nodes = new HashMap<>();
        next_index = 0;
        adj_list = new ArrayList<>();
    }

    public List<Node> nodes() {
        if (nodes.keySet().isEmpty()) return null;
        return nodes.keySet().stream()
                .map(Node::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Edge> edgesForNode(Node n) {
        if (n == null) return null;
        return adj_list.get(nodes.get(n.name)).edges;
    }

    public void addNode(Node n) {
        if (n != null) {
            nodes.put(n.name, next_index);
            adj_list.add(new Edges(n));
            next_index++;
        }
    }

    public Integer indexForNode(Node n) {
        if (null == nodes.get(n.name)) addNode(n);
        return nodes.get(n.name);
    }

    public Node nodeForIndex(Integer i) {
        return adj_list.get(i).n;
    }

    public void addEdge(Node n1, Node n2, int cost) {
        Integer i1 = indexForNode(n1), i2 = indexForNode(n2);
        adj_list.get(i1).edges.add(new Edge(i1, i2, cost));
    }
}