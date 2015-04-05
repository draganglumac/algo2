package uk.co.gluedit;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class Prim {
    private void addEdge(Graph g, String line, HashMap<String, PrimNode> processed) {
        String[] bits = line.split("\\s");
        PrimNode src = processed.get(bits[0]);
        if (src == null) {
            src = new PrimNode(bits[0]);
            processed.put(bits[0], src);
        }
        PrimNode dest = processed.get(bits[1]);
        if (dest == null) {
            dest = new PrimNode(bits[1]);
            processed.put(bits[1], dest);
        }
        int cost = Integer.parseInt(bits[2]);
        g.addEdge(src, dest, cost);
    }

    private Graph graphFromInputStream(InputStream is) throws IOException {
        BufferedReader buffy = new BufferedReader(new InputStreamReader(is));
        String line;
        Graph g = new Graph();
        HashMap<String, PrimNode> processed = new HashMap<>();
        while ((line = buffy.readLine()) != null) {
            if (line.matches("^\\w+\\s\\w+\\s-?\\d+$")) {
                addEdge(g, line, processed);
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
        PrimNode startNode = (PrimNode) nodes.get(0);
        heap.insert(startNode);
        while (!heap.isEmpty()) {
            PrimNode n = heap.extractMin();
            if (n.edge != null) {
                mst.edges.add(n.edge);
            }
            if (visited.get(n) == null) {
                for (Edge e : g.edgesForNode(n)) {
                    PrimNode n2 = (PrimNode) g.nodeForIndex(e.n2);
                    if (visited.get(n2) == null) {
                        if (n2.edge == null) {
                            n2.edge = e;
                            heap.insert(n2);
                        }
                        else if (0 > e.cost.compareTo(n2.edge.cost)) {
                            Integer i = heap.indexForElement(n2);
                            n2.edge = e;
                            heap.balanceHeapForDecrease(i);
                        }
                    }
                }
            }
            visited.put(n, true);
        }
        return mst;
    }

}
