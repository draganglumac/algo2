package uk.co.gluedit;

import java.io.*;
import java.net.URL;

public class Prim {
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
}
