package p1;

import java.util.ArrayList;

public class MaxHeap implements Heap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    @Override
    public void insert(int value) {
        heap.add(value);
        balanceHeapInsertion();
    }

    private void balanceHeapInsertion() {
        int index = heap.size() - 1;

        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(parent) < heap.get(index)) {
                ///  Swap as Condition violated for max-Heap
                swap(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    @Override
    public int peek() {
        return heap.getFirst();
    }

    @Override
    public int pop() {
        int min = heap.getFirst();

        heap.set(0,heap.getLast());
        heap.removeLast();

        balanceHeapDeletion(0);
        return min;
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void balanceHeapDeletion(int index) {
        int maximum = index;/// Assume the new elem at 0th index is minimum and we are checking for then even minimal element.
        int left = maximum * 2 + 1;
        int right = maximum * 2 + 2;

        if (left < heap.size() && heap.get(left) > heap.get(maximum)) {
            maximum = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(maximum)) {
            maximum = right;
        }
        if (maximum != index) {
            swap(maximum, index);
            balanceHeapDeletion(maximum);
        }
    }


    private void swap(int index, int parent) {
        int temp = heap.get(index); /// current value at child index
        heap.set(index, heap.get(parent));/// at the child index set the value of parent.
        heap.set(parent, temp);/// at the parent index set the value of child.
    }

}
