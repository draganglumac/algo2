package co.uk.gluedit;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.gluedit.Heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class HeapTest {
    private Heap<Integer>heap;

    @Before public void setUp() {
        heap = new Heap<>();
    }
    @Test public void testEmptyHeap() {
        assertTrue(heap.isEmpty());
        assertEquals(heap.extractMin(), null);
    }
    @Test public void testSingleElement() {
        heap.insert(42);
        assertFalse(heap.isEmpty());
        assertEquals(heap.extractMin(), new Integer(42));
    }
    private void assertOrder(Integer[] original, Integer[] order) {
        heap.heapify(original);
        for (Integer i : order)
            assertEquals(i, heap.extractMin());
    }
    @Test public void tesHeapify() {
        Integer[] nums = {1, 2, 3};
        assertOrder(nums, nums);

        Integer[] nums2 = {2, 1, 3};
        assertOrder(nums2, nums);

        Integer[] nums3 = {1, 3, 2};
        assertOrder(nums3, nums);

        Integer[] nums4 = {2, 3, 1};
        assertOrder(nums4, nums);

        Integer[] nums5 = {3, 1, 2};
        assertOrder(nums5, nums);

        Integer[] nums6 = {3, 2, 1};
        assertOrder(nums6, nums);
    }
    @Test public void testTwoElements() {
        heap.insert(1);
        heap.insert(2);
        assertEquals(heap.extractMin(), new Integer(1));
        assertEquals(heap.extractMin(), new Integer(2));

        heap.insert(2);
        heap.insert(1);
        assertEquals(heap.extractMin(), new Integer(1));
        assertEquals(heap.extractMin(), new Integer(2));
    }
}