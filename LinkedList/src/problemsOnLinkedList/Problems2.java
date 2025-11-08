package problemsOnLinkedList;

public class Problems2 {
    /*
-----------------------------------------------------------------------------------------------------------------------
    LeetCode 148: Sort Linked List: Given head of a linked List and using that sort the list in a ascending order
-----------------------------------------------------------------------------------------------------------------------
**/
///    Merge Sort
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMidNode(head); // get the Middle Node from the linked list.
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return Problems.mergeTwoLists(left, right);
    }

    private static ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = null;
        while (fast != null && fast.next != null) {
            slow = slow == null ? head : slow.next; /// this will make slow pointer to point to the Node just behind the MiddleNode.
            fast = fast.next.next;
            if (fast == slow) break;
        }
        fast = slow.next; /// Points to the exact mid-node.
        slow.next = null; /// Break the connection of LinkedList from the mid.
        return fast;
    }

///    Bubble Sort
    public static ListNode bubbleSort(ListNode head) {
        if (head == null || head.next == null) return head;

        boolean swapped;
        do {
            swapped = false;
            ListNode curr = head;
            ListNode prev = null; /// Previous first Node (Node just before the first node which are to be swapped.)

            while (curr != null && curr.next != null) { ///  if the Node - pointer reaches the end or last node.
                if (curr.val > curr.next.val) {
                    head = swapNodes(head, prev, curr, curr.next);
                    swapped = true;
                    if (prev == null) {
                        prev = head;
                    } else {
                        prev = prev.next;
                    }
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
        } while (swapped);

        return head;
    }

    public static ListNode swapNodes(ListNode head, ListNode prevFirst, ListNode first, ListNode second) {
        if (prevFirst == null) {  // swapping the head
            first.next = second.next;
            second.next = first;
            return second; // new head
        } else {
            prevFirst.next = second;
            first.next = second.next;
            second.next = first;
            return head;
        }
    }

    /*-------------------------------------------------------------------------------------------------------------------
            LeetCode 206: Reverse LinkedList: Reverse the linked list and returns the new head
    ---------------------------------------------------------------------------------------------------------------------
    * */
    public static ListNode reverseIter(ListNode head) {
        if (head == null || head.next == null) return head;/// if Only 1 Node is there.

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (curr != null) { ///  when curr become null at that prev will be pointing to the last node which is the head of reversed list.
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null)
                next = next.next;
        }
        return prev;
    }

    public static ListNode reverseRec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseRec(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }


    /*-------------------------------------------------------------------------------------------------------------------
                         LeetCode 92: Reverse LinkedList II Between range: Reverse the linked list and returns the new head
    ---------------------------------------------------------------------------------------------------------------------
    * */

    /// left and right are 1-indexed and head is the starting point of the head.
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head; /// if only one Node is asked to reverse.
        ListNode newHead = new ListNode(0, head);
        ListNode before = newHead;

        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        ListNode prev = null;
        ListNode curr = before.next;
        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        before.next.next = curr;
        before.next = prev;
        return newHead.next;
    }


    /*-------------------------------------------------------------------------------------------------------------------
                           LeetCode 25: Reverse Nodes in k- Group
    ---------------------------------------------------------------------------------------------------------------------
    * */

    /// Reverse each k group of nodes in the list
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;
        int count = 1;
        ListNode ptr = head; /// Pointer node to track node at each step
        ListNode curHead = head; /// pointer to track the head of the running current group of k Nodes.
        ListNode prev = null; /// Pointer to keep track of the previous last Node from the group,so that new reversed head can be connected with.
        head = null;
        while (ptr != null) {
            if (count % k == 1) { ///  if new group of k is being started
                curHead = ptr;
            }
            if (count % k == 0) { /// if successfully formed the group of k Node
                ListNode next = ptr.next; /// keeps track of the next node just after the last node at the kth pos.
                ptr.next = null; /// break the connection from the last (kth) node.
                ListNode newHead = reverseIter(curHead); /// returns the new head after the reversal of the portion
                if (prev != null) /// if this was not the first portion which is being reversed then connect the last Node from previous reversed group with the newHead.
                    prev.next = newHead;
                if (head == null) /// If this was the first group which is being traversed then the newHead will also be the head of the ans after final traversal.
                    head = newHead;

                /// As we know after reversal the head of the group becomes the tail of the reversed list so again establish the connection  with next which was broken earlier.
                curHead.next = next;
                prev = curHead; /// Now the tail of the current kth group will act as the previous Node for next k reversed Nodes
                /// As we know that after reversal the head and tail are swapped so we also need to move the pointer to the tail after reversal.
                ptr = curHead;
            }
            ptr = ptr.next;
            count++;
        }

        return head;
    }

    /*-------------------------------------------------------------------------------------------------------------------
                           Reverse Node k-grouped in alternate (means 1st k is reversed, 2nd k is as original, 3rd is reversed and so on...
    ---------------------------------------------------------------------------------------------------------------------
    * */

    public static ListNode reverseKAlternateGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;
        int count = 1;
        ListNode ptr = head; /// Pointer node to track node at each step
        ListNode curHead = head; /// pointer to track the head of the running current group of k Nodes.
        ListNode prev = null; /// Pointer to keep track of the previous last Node from the group,so that new reversed head can be connected with.
        head = null;
        while (ptr != null) {
            if (count % k == 1) { ///  if new group of k is being started
                curHead = ptr;
            }
            ///  Reverse only alternate k - group
            if (count % k == 0) { /// if successfully formed the group of k Node
                ListNode next = ptr.next; /// keeps track of the next node just after the last node at the kth pos.
                ptr.next = null; /// break the connection from the last (kth) node.
                ListNode newHead = reverseIter(curHead); /// returns the new head after the reversal of the portion
                if (prev != null) /// if this was not the first portion which is being reversed then connect the last Node from previous reversed group with the newHead.
                    prev.next = newHead;
                if (head == null) /// If this was the first group which is being traversed then the newHead will also be the head of the ans after final traversal.
                    head = newHead;

                /// As we know after reversal the head of the group becomes the tail of the reversed list so again establish the connection  with next which was broken earlier.
                curHead.next = next;
                /// As we know that after reversal the head and tail are swapped so we also need to move the pointer to the tail after reversal.
                ptr = curHead;

                /// Skips next K Nodes.
                int i = 0;
                while (ptr != null && i < k) {
                    ptr = ptr.next;
                    i++;
                }
                prev = ptr; /// Now the tail of the current kth group will act as the previous Node for next k reversed Nodes
            }

            if (ptr != null)
                ptr = ptr.next;
            count++;
        }

        return head;
    }
}