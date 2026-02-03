package p1;

import java.util.ArrayList;

public class MinHeap implements Heap {
    private ArrayList<Integer> heap;

    public MinHeap() {
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

            if (heap.get(parent) > heap.get(index)) {
                ///  Swap as Condition violated for Min-p1.Heap
                swap(index, parent);
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

        heap.set(0, heap.getLast());
        heap.removeLast();

        balanceHeapDeletion(0);
        return min;
    }

    private void balanceHeapDeletion(int index) {
        int smallest = index;/// Assume the new elem at 0th index is minimum and we are checking for then even minimal element.
        int left = smallest * 2 + 1;
        int right = smallest * 2 + 2;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        if (smallest != index) {
            swap(smallest,index);
            balanceHeapDeletion(smallest);
        }
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void swap(int index, int parent) {
        int temp = heap.get(index); /// current value at child index
        heap.set(index, heap.get(parent));/// at the child index set the value of parent.
        heap.set(parent, temp);/// at the parent index set the value of child.
    }

}
