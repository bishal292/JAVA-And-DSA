package linkedListImplementation_And_Usecase;

public class Main {
    public static void main(String[] args) {
///        ------------------------------- Singly Linked List -------------------------------------
//        CustomSinglyLinkedList sll = new CustomSinglyLinkedList();
//        System.out.println(sll);
//        sll.removeLast(); /// Will throw error as linked list is empty now.
//        sll.add(12);
//        sll.add(21);
//        sll.add(1);
//        sll.add(11);
//        sll.add(23);
//        sll.add(28);
//        System.out.println(sll);
//        sll.removeLast();
//        System.out.println(sll);
//        sll.addFirst(28);
//        System.out.println(sll);
//        sll.removeFirst();
//        System.out.println(sll);
//        sll.insert(0, 1);
//        sll.insert(1, 2);
//        sll.insert(2, 3);
//        sll.insert(3, 4);
//        sll.insert(4, 5);
//        sll.insert(sll.size(), sll.size() + 1);
//        System.out.println(sll);




///        -------------------------------Doubly Linked List -------------------------------------
        CustomDoublyLinkedList ll = new CustomDoublyLinkedList();
        System.out.println(ll);
//        ll.removeLast();
//        ll.add(12);
//        ll.add(21);
//        ll.add(1);
//        ll.add(11);
//        ll.add(23);
//        ll.add(28);
//        System.out.println(ll);
//        ll.removeLast();
//        System.out.println(ll);
//        ll.addFirst(28);
//        System.out.println(ll);
//        ll.removeFirst();
//        System.out.println(ll);
//        ll.insert(0, 1);
//        ll.insert(1, 2);
//        ll.insert(2, 3);
//        ll.insert(3, 4);
//        ll.insert(4, 5);
//        ll.insert(ll.size(), ll.size() + 1);
//        System.out.println(ll);
//        ll.displayInreverse(); /// Only can be used with Doubly linked list as both way traversal is easy due to prev Pointer.

///        ------------------------------- Circular Linked List -------------------------------------

//        CircularLinkedList cll = new CircularLinkedList();
//        System.out.println(cll);
////        cll.removeLast();
//        cll.add(12);
//        cll.add(21);
//        cll.add(1);
//        cll.add(11);
//        cll.add(23);
//        cll.add(28);
//        System.out.println(cll);
//        cll.removeLast();
//        System.out.println(cll);
//        cll.addFirst(28);
//        System.out.println(cll);
//        cll.removeFirst();
//        System.out.println(cll);
//        cll.insert(0, 1);
//        cll.insert(1, 2);
//        cll.insert(2, 3);
//        cll.insert(3, 4);
//        cll.insert(4, 5);
//        cll.insert(cll.size(), cll.size() + 1);
//        System.out.println(cll);



        CustomSinglyLinkedList sll = new CustomSinglyLinkedList();
        System.out.println(sll);
        sll.add(12);
        sll.add(21);
        sll.add(1);
        sll.add(11);
        sll.add(23);
        sll.add(28);
        System.out.println(sll);
        sll.removeLast();
        System.out.println(sll);
        sll.addFirst(28);
        System.out.println(sll);
        sll.removeFirst();
        System.out.println(sll);
        sll.insertUseRec(0, 1);
        sll.insertUseRec(1, 2);
        sll.insertUseRec(2, 3);
        sll.insertUseRec(3, 4);
        sll.insertUseRec(4, 5);
        System.out.println(sll.size());
        sll.insertUseRec(sll.size(), sll.size() + 1);
        sll.insertUseRec(32,65);  /// 1 -> 2 -> 3 -> 4 -> 5 -> 12 -> 21 -> 1 -> 11 -> 23 -> 11 ->  END
        System.out.println(sll);
    }

}
