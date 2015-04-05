package uk.co.gluedit;

public class PrimNode extends Node implements Comparable<PrimNode> {
    public Integer weight;

    public PrimNode(String name) {
        super(name);
        weight = 0;
    }

    public int compareTo(PrimNode other) {
        return weight.compareTo(other.weight);
    }
}
