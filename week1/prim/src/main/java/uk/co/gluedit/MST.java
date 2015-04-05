package uk.co.gluedit;

import java.util.ArrayList;
import java.util.List;

public class MST {
    public List<Edge> edges;

    public MST() {
        edges = new ArrayList<>();
    }

    public Long cost() {
        long sum = 0;
        for (Edge e : edges) {
            sum += e.cost;
        }
        return sum;
    }
}
