package co.uk.gluedit;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.gluedit.Graph;
import uk.co.gluedit.MST;
import uk.co.gluedit.Node;
import uk.co.gluedit.Prim;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

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
        assertEquals(g.edgesForNode(new Node("1")).size(), 1);
        assertEquals(g.edgesForNode(new Node("2")).size(), 2);
        assertEquals(g.edgesForNode(new Node("3")).size(), 1);
    }

    @Test
    public void testOneEdgePrim() throws IOException {
        Graph g = p.loadGraph(getSystemResourceByName("oneEdge.txt"));
        assertEquals((Integer) 42, p.computeMst(g).cost());
    }
}
