package p1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(7);
        maxHeap.insert(6);
        maxHeap.insert(8);

        minHeap.insert(6);
        minHeap.insert(8);
        minHeap.insert(6);
        minHeap.insert(7);
        minHeap.insert(5);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(5);
        minHeap.insert(6);

/*        for (int i = 0;i<11;i++){
            System.out.println(minHeap.pop());
        }
        System.out.println("\n");
        for (int i = 0;i<11;i++){
            System.out.println(maxHeap.pop());
        }*/


        ///  Heap sort is nothing but the max-heap or min-heap only as if we keep removing/popping elements from min-heap we'll get ascending sorted similarly for max-heap descending order.
        ArrayList<Integer> list = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            list.add(minHeap.pop());
        }
        System.out.println(list);
        while (!maxHeap.isEmpty()) {
            list.add(maxHeap.pop());
        }
        System.out.println(list);
    }
}
