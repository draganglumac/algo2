package co.uk.gluedit;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.gluedit.Graph;
import uk.co.gluedit.Node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class GraphTest {
    private Graph g;

    @Before
    public void setUp() {
        g = new Graph();
    }

    @Test
    public void testEqualNodes() {
        Node n1 = new Node("node"), n2 = new Node("node");
        assertEquals(n1, n2);
    }

    @Test
    public void testEmptyGraph() {
        assertEquals(g.nodes(), null);
        assertEquals(g.edgesForNode(null), null);
    }

    @Test
    public void testSingleVertexGraph() {
        Node n = new Node("node1");
        g.addNode(n);
        assertTrue(g.nodes().contains(n));
        assertEquals(g.nodes().size(), 1);
        assertTrue(g.edgesForNode(n).isEmpty());
    }

    public class TwoNodeGraphTest {
        private Node n1, n2;

        private void assertEdge(Node n1, Node n2, Integer cost) {
            assertEquals(2, g.nodes().size());
            assertTrue(g.nodes().contains(n1)
                    && g.nodes().contains(n2));
            assertEquals(g.edgesForNode(n1).size(), 1);
            assertEquals(n2, g.nodeForIndex(g.edgesForNode(n1).get(0).n2));
            assertEquals(cost, g.edgesForNode(n1).get(0).cost);
        }

        @Before
        public void setUp() {
            n1 = new Node("n1");
            n2 = new Node("n2");
        }

        @Test
        public void testSingleEdgeDirectedGraph() {
            g.addEdge(n1, n2, 42);
            assertEdge(n1, n2, 42);
            assertTrue(g.edgesForNode(n2).isEmpty());
        }

        @Test
        public void testSingleEdgeUndirectedGraph() {
            g.addEdge(n1, n2, 42);
            g.addEdge(n2, n1, 42);
            assertEdge(n1, n2, 42);
            assertEdge(n2, n1, 42);
        }

        @Test
        public void testSingleLoopGraph() {
            g.addEdge(n1, n2, 42);
            g.addEdge(n2, n1, 43);
            assertEdge(n1, n2, 42);
            assertEdge(n2, n1, 43);
        }
    }

    public class TreeTest {
        private Node n1, n2, n3;

        private void assertEdge(Node n1, Node n2, Integer cost, int index) {
            assertEquals(3, g.nodes().size());
            assertTrue(g.nodes().contains(n1)
                    && g.nodes().contains(n2));
            assertEquals(n2, g.nodeForIndex(g.edgesForNode(n1).get(index).n2));
            assertEquals(cost, g.edgesForNode(n1).get(index).cost);
        }

        private void assertEdge(Node n1, Node n2, Integer cost) {
            assertEdge(n1, n2, cost, 0);
        }

        @Before
        public void setUp() {
            n1 = new Node("n1");
            n2 = new Node("n2");
            n3 = new Node("n3");
        }

        @Test
        public void testPathGraph() {
            g.addEdge(n1, n2, 1);
            g.addEdge(n2, n3, 2);
            assertEdge(n1, n2, 1);
            assertEdge(n2, n3, 2);
        }

        @Test
        public void testTree() {
            g.addEdge(n1, n2, 1);
            g.addEdge(n1, n3, 2);
            assertEdge(n1, n2, 1);
            assertEdge(n1, n3, 2, 1);
            assertTrue(g.edgesForNode(n2).isEmpty());
            assertTrue(g.edgesForNode(n3).isEmpty());
        }

        @Test
        public void testUndirectedTree() {
            g.addEdge(n1, n2, 1);
            g.addEdge(n2, n1, 1);
            g.addEdge(n1, n3, 2);
            g.addEdge(n3, n1, 2);
            assertEdge(n1, n2, 1);
            assertEdge(n1, n3, 2, 1);
            assertEdge(n2, n1, 1);
            assertEdge(n3, n1, 2);
        }

        @Test
        public void testSourceSinkGraph() {
            g.addEdge(n1, n2, 1);
            g.addEdge(n1, n3, 2);
            g.addEdge(n2, n3, -5);
            assertEdge(n1, n2, 1);
            assertEdge(n1, n3, 2, 1);
            assertEdge(n2, n3, -5);
        }

        @Test
        public void testUndirectedLoop() {
            g.addEdge(n1, n2, 1);
            g.addEdge(n2, n1, 1);
            g.addEdge(n1, n3, 2);
            g.addEdge(n3, n1, 2);
            g.addEdge(n2, n3, 3);
            g.addEdge(n3, n2, 3);
            assertEdge(n1, n2, 1);
            assertEdge(n2, n1, 1);
            assertEdge(n1, n3, 2, 1);
            assertEdge(n3, n1, 2);
            assertEdge(n2, n3, 3, 1);
            assertEdge(n3, n2, 3, 1);
        }
    }
}