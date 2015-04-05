package uk.co.gluedit;

public class Node {
    public final String name;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return o.getClass() == this.getClass()
                && ((Node) o).name.equals(name);
    }
}