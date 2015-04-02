package co.uk.gluedit;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.gluedit.Heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class HeapTest {
    private Heap<Integer> heap;

    @Before public void setUp() {
        heap = new Heap<>();
    }
    @Test public void testEmptyHeap() {
        assertTrue(heap.isEmpty());
        assertEquals(heap.extractMin(), null);
    }
}
