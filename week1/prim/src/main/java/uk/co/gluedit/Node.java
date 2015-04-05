package uk.co.gluedit;

public class Node {
    public final String name;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() == this.getClass())
            return ((Node) o).name.equals(name);
        return false;
    }
}