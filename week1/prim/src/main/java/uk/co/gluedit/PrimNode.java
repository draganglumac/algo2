package uk.co.gluedit;

public class PrimNode extends Node implements Comparable<PrimNode> {
    public Edge edge;

    public PrimNode(String name) {
        super(name);
        edge = null;
    }

    public int compareTo(PrimNode other) {
        return edge.cost.compareTo(other.edge.cost);
    }
}
