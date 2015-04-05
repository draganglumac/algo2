package uk.co.gluedit;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class Prim {
    private class NodeWeight implements Comparable<NodeWeight> {
        public Node n;
        public Integer weight;

        public NodeWeight(Node n, Integer weight) {
            this.n = n;
            this.weight = weight;
        }

        public int compareTo(NodeWeight other) {
            return weight.compareTo(other.weight);
        }
    }

    private void addEdge(Graph g, String line) {
        String[] bits = line.split("\\s");
        Node src = new Node(bits[0]);
        Node dest = new Node(bits[1]);
        int cost = Integer.parseInt(bits[2]);
        g.addEdge(src, dest, cost);
    }

    private Graph graphFromInputStream(InputStream is) throws IOException {
        BufferedReader buffy = new BufferedReader(new InputStreamReader(is));
        String line;
        Graph g = new Graph();
        while ((line = buffy.readLine()) != null) {
            if (line.matches("^\\d+\\s\\d+\\s-?\\d+$")) {
                addEdge(g, line);
            }
        }
        return g;
    }

    public Graph loadGraph(URL url) throws IOException {
        InputStream is = url.openStream();
        return graphFromInputStream(is);
    }

    public Graph loadGraph(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        return graphFromInputStream(fis);
    }

    public MST computeMst(Graph g) {
        MST mst = new MST();
        HashMap<Node, Boolean> visited = new HashMap<>();
        Heap<NodeWeight> heap = new Heap<>();
        List<Node> nodes = g.nodes();
        for (Node n : nodes) {
            for (Edge e : g.edgesForNode(n)) {
                Node n2 = g.nodeForIndex(e.n2);
                if (! visited.get(n2)) {
                    if (heap.indexForElement(n2) != null) {

                    }
                }
            }
            visited.put(n, true);
        }
        return mst;
    }

}
