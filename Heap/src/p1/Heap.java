package p1;

public interface Heap {
    /**
     * Heaps are a special data structure implemented as a complete binary tree but usually stored in an array.
     * Heaps are used when you need fast access to highest or lowest priority elements repeatedly.
     * As we now Complete Binary Tree means each level is filled completely maybe except last level and filled from left -> Right.
     *
     */


    void insert(int value);
    int peek();
    int pop();
    int size();
    boolean isEmpty();
}
