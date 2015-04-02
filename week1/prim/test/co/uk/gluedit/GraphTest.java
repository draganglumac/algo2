package co.uk.gluedit;

import org.junit.Before;
import org.junit.Test;
import uk.co.gluedit.Graph;
import uk.co.gluedit.Node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphTest {
    private Graph g;

    @Before public void setUp() {
        g = new Graph();
    }
    @Test public void testEmptyGraph() {
        assertEquals(g.nodes(), null);
        assertEquals(g.edgesForNode(null), null);
    }
    @Test public void testSingleVertexGraph() {
        Node n = new Node("node1");
        g.addNode(n);
        assertTrue(g.nodes().contains(n));
        assertEquals(g.nodes().size(), 1);
        assertTrue(g.edgesForNode(n).isEmpty());
    }
}