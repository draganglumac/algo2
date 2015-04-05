package uk.co.gluedit;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class Prim {
    private void addEdge(Graph g, String line) {
        String[] bits = line.split("\\s");
        Node src = new PrimNode(bits[0]);
        Node dest = new PrimNode(bits[1]);
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
        Heap<PrimNode> heap = new Heap<>();
        List<Node> nodes = g.nodes();
        for (Node n : nodes) {
            if (!visited.get(n)) {
                for (Edge e : g.edgesForNode(n)) {
                    PrimNode n2 = (PrimNode) g.nodeForIndex(e.n2);
                    if (!visited.get(n2)) {
                        if (n2.weight == 0) {
                            n2.weight = e.cost;
                            heap.insert(n2);
                        }
                        else {
                            Integer i = heap.indexForElement(n2);
                            if (0 > e.cost.compareTo(n2.weight)) {
                                n2.weight = e.cost;
                                heap.balanceHeapForDecrease(i);
                            }
                        }
                    }
                }
            }
            visited.put(n, true);
        }
        return mst;
    }

}
