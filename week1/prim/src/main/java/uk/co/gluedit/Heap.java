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
        int index = pq.size() - 1;
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

    private int getSwapIndex(int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (right < pq.size()) {
            if (0 > pq.get(right).compareTo(pq.get(left)))
                return right;
            else
                return left;
        }
        else if (left < pq.size()) {
            return left;
        }
        return index;
    }

    private void bubbleDown() {
        int index = 0;
        int swapIndex = getSwapIndex(index);
        while (swapIndex < pq.size()) {
            if (0 < pq.get(index).compareTo(pq.get(swapIndex))) {
                swapElementsAt(index, swapIndex);
                index = swapIndex;
                swapIndex = getSwapIndex(index);
                continue;
            }
            break;
        }
    }
    private void swapElementsAt(int parent, int index) {
        T temp = pq.get(index);
        pq.set(index, pq.get(parent));
        pq.set(parent, temp);
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
        if (pq.size() > 1) {
            T min = pq.get(0);
            pq.set(0, pq.remove(pq.size() - 1));
            bubbleDown();
            return min;
        }
        else
            return pq.remove(0);
    }

    public void remove(T el) {
        // TODO
    }
}
