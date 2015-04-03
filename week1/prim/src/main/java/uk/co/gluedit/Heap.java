package uk.co.gluedit;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    ArrayList<T> pq;

    public Heap() {
        pq = new ArrayList<>();
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public void insert(T el) {
        pq.add(el);
        bubbleUp();
    }

    private void bubbleUp() {
        int index = pq.size() - 1; =
        int parent = parentForIndex(index);
        while (index > 0) {
            if (0 < pq.get(parent).compareTo(pq.get(index))) {
                swapElementsAt(parent, index);
                index = parent;
                parent = parentForIndex(index);
                continue;
            }
            break;
        }
    }

    private void bubbleDown() {
        // TODO
    }
    private void swapElementsAt(int parent, int index) {
        T temp = pq.get(index);
        pq.add(index, pq.get(parent));
        pq.add(parent, temp);
    }

    private int parentForIndex(int index) {
        if (index <= 0)
            return 0;
        return (index - 1) / 2;
    }

    public void heapify(T[] col) {
        for (T el : col)
            insert(el);
    }

    public T extractMin() {
        if (isEmpty()) return null;
        T min = pq.get(0);
        pq.add(0, pq.remove(pq.size() - 1));
        bubbleDown();
        return min;
    }

    public void remove(T el) {
        // TODO
    }
}
