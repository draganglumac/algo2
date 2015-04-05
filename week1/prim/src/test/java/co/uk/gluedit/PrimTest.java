package co.uk.gluedit;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.gluedit.Graph;
import uk.co.gluedit.Node;
import uk.co.gluedit.Prim;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(HierarchicalContextRunner.class)
public class PrimTest {
    private URL getSystemResourceByName(String name) {
        return ClassLoader.getSystemResource(name);
    }
    @Test
    public void testLoadingFromFile() throws IOException {
        Prim p = new Prim();
        Graph g = p.loadGraph(getSystemResourceByName("edges.txt"));
        assertEquals(g.nodes().size(), 500);

        g = p.loadGraph(getSystemResourceByName("klein.txt"));
        assertEquals(g.nodes().size(), 3);
        assertEquals(g.edgesForNode(new Node("1")).size(), 1);
        assertEquals(g.edgesForNode(new Node("2")).size(), 2);
        assertEquals(g.edgesForNode(new Node("3")).size(), 1);
    }
}
