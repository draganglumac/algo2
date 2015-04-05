package co.uk.gluedit;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.gluedit.Graph;
import uk.co.gluedit.MST;
import uk.co.gluedit.Prim;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class PrimTest {
    private Prim p;

    private URL getSystemResourceByName(String name) {
        return ClassLoader.getSystemResource(name);
    }

    @Before
    public void setUp() {
        p = new Prim();
    }

    @Test
    public void testLoadingFromFile() throws IOException {
        Graph g = p.loadGraph(getSystemResourceByName("edges.txt"));
        assertEquals(g.nodes().size(), 500);

        String filePath = getSystemResourceByName("klein.txt").getFile();
        g = p.loadGraph(filePath);
        assertEquals(g.nodes().size(), 3);
        assertEquals(g.edgesForNode(g.nodeForIndex(0)).size(), 1);
        assertEquals(g.edgesForNode(g.nodeForIndex(1)).size(), 2);
        assertEquals(g.edgesForNode(g.nodeForIndex(2)).size(), 1);
    }

    @Test
    public void testOneEdgePrim() throws IOException {
        Graph g = p.loadGraph(getSystemResourceByName("oneEdge.txt"));
        MST mst = p.computeMst(g);
        assertEquals(new Long(42), mst.cost());
        assertTrue(mst.edges.size() == g.nodes().size() - 1);
    }

    @Test
    public void testThreeNodePrim() throws IOException {
        Graph g = p.loadGraph(getSystemResourceByName("klein.txt"));
        MST mst = p.computeMst(g);
        assertEquals(new Long(66), mst.cost());
        assertTrue(mst.edges.size() == g.nodes().size() - 1);


        g = p.loadGraph(getSystemResourceByName("drei.txt"));
        mst = p.computeMst(g);
        assertEquals(new Long(36), mst.cost());
        assertTrue(mst.edges.size() == g.nodes().size() - 1);
    }

    @Test
    public void testFourNodePrim() throws IOException {
        Graph g = p.loadGraph(getSystemResourceByName("four.txt"));
        MST mst = p.computeMst(g);
        assertEquals(new Long(7), mst.cost());
        assertTrue(mst.edges.size() == g.nodes().size() - 1);
    }

    @Test
    public void testAssignment() throws IOException {
        Graph g = p.loadGraph(getSystemResourceByName("edges.txt"));
        MST mst = p.computeMst(g);
        assertTrue(mst.edges.size() == g.nodes().size() - 1);
        assertEquals(new Long(-3612829), mst.cost());
    }
}
