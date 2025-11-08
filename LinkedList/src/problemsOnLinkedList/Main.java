package problemsOnLinkedList;


public class Main {
    static void main() {
//        ListNode head = new ListNode(1);
//        ListNode head2 = new ListNode(1);
//        head.add(1);
//        head.add(2);
//        head.add(4);
//        head2.add(3);
//        head2.add(4);
//        System.out.println(head);
//        System.out.println(head2);

//        ListNode merged = Problems.mergeTwoLists(head, head2); /// 1 -> 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> END
//        System.out.println(merged);

//        merged.add(-1);
//        merged.add(43);
//        merged.add(1);
//        merged.add(0);

//        System.out.println(merged); /// 1 -> 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> -1 -> 43 -> 1 -> 0 -> END

//        merged = Problems2.reverseIter(merged); /// 0 -> 1 -> 43 -> -1 -> 4 -> 4 -> 3 -> 2 -> 1 -> 1 -> 1 -> END
//        merged = Problems2.reverseRec(merged);

//        merged = Problems2.reverseBetween(merged,2,9); /// 1 -> 43 -> -1 -> 4 -> 4 -> 3 -> 2 -> 1 -> 1 -> 1 -> 0 -> END

//        System.out.println(merged);
//        merged = Problems2.sortList(merged); /// Sort the list using Merge Sort.
////        merged = Problems2.bubbleSort(merged);/// Sort the LinkedList using bubble Sort.
//        System.out.println(merged);

/*
            Check Whether the list has cycle or not.
* */
//        ListNode listWithCycle = new ListNode(12);
//        listWithCycle.add(43);
//        listWithCycle.add(1);
//        listWithCycle.add(4);
//        listWithCycle.add(3);
//        ListNode ptr = listWithCycle;
//        while (ptr.next != null) {
//            ptr = ptr.next;
//        }


        /*ptr.next = listWithCycle; /// Starts pointing to the first(head) index from tail
//        System.out.println(listWithCycle); /// Results in memory out of bound error as the list is circular or has a cycle
        System.out.println(hasCycle(listWithCycle));
        System.out.println(cycleLength(listWithCycle)); /// All the elements are forming cycle means 5.*/

        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        System.out.println(head); /// 1 -> 2 -> 3 -> 4 -> 5 -> END

//        ListNode ans = Problems2.reverseKGroup(head,2);
//        System.out.println(ans); /// 2 -> 1 -> 4 -> 3 -> 5 -> END

        head.add(6);
        head.add(7);
        head.add(8);
        head.add(9);
        head.add(10);
        head.add(11);
        System.out.println(head); /// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> END
        ListNode ans2 = Problems2.reverseKAlternateGroup(head, 2);
        System.out.println(ans2);///  2 -> 1 -> 3 -> 4 -> 6 -> 5 -> 7 -> 8 -> 10 -> 9 -> 11 -> END
        ans2 = Problems2.bubbleSort(ans2);
        System.out.println(ans2);

    }
}
