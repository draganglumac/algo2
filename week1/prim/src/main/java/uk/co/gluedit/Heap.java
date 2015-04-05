package uk.co.gluedit;

import java.util.ArrayList;
import java.util.HashMap;

public class Heap<T extends Comparable<T>> {
    ArrayList<T> pq;
    HashMap<T, Integer> indices;

    public Heap() {
        pq = new ArrayList<>();
        indices = new HashMap<>();
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public void insert(T el) {
        pq.add(el);
        int lastIndex = pq.size() - 1;
        indices.put(el, lastIndex);
        bubbleUp(lastIndex);
    }

    private void bubbleUp(int index) {
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
        } else if (left < pq.size()) {
            return left;
        }
        return index;
    }

    private void bubbleDown(int index) {
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

    private void swapElementsAt(int i1, int i2) {
        T el1 = pq.get(i1);
        T el2 = pq.get(i2);
        pq.set(i1, el2);
        indices.put(el2, i1);
        pq.set(i2, el1);
        indices.put(el1, i2);
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
        indices.remove(min);
        if (pq.size() > 1) {
            T last = pq.remove(pq.size() - 1);
            pq.set(0, last);
            indices.put(last, 0);
            bubbleDown(0);
            return min;
        } else
            return pq.remove(0);
    }

    public void remove(T el) {
        int index = indices.get(el);
        T last = pq.remove(pq.size() - 1);
        if (index < (pq.size() - 1)) {
            pq.set(index, last);
            indices.put(last, index);
            bubbleDown(index);
        }
        indices.remove(el);
    }

    public Integer indexForElement(T el) {
        return indices.get(el);
    }

    public void balanceHeapForDecrease(int i) {
        bubbleUp(i);
    }
}
