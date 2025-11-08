package problemsOnLinkedList;

public class Problems {

    /*---------------------------------------------------------------------------------------------------------
                                Recursive Approach Operation on Linked List
    ----------------------------------------------------------------------------------------------------------
*/
          /*  This is followed up from CustomSinglyLinkedList file and code.So, have a look in it.


            public void insertUseRec(int index,int value){
                head = insertUsingRec(index,value,head);
            }
            private Node insertUsingRec(int index,int value,Node cur){
                if(index == 0){
                    size++;
                    return new Node(value,cur);
                }
                if(cur == null)return null; /// if no element is left.
                cur.nextNode = insertUsingRec(index-1,value,cur.nextNode);
                return cur;
            }*/

    /* ----------------------------------------------------------------------------------------------------------------------
        LeetCode 83: Remove Duplicates from Sorted List
      -----------------------------------------------------------------------------------------------------------------------
    * */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ptr = head;
        while (ptr.next != null) { ///  runs till we reach the last Element.
            if (ptr.val == ptr.next.val) { ///  if current node's value is equal to the next Node value
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }
        return head;
    }

/* ----------------------------------------------------------------------------------------------------------------------
        LeetCode 21: Merge 2 Sorted Lists And the resulting listNode must be sorted also.
  -----------------------------------------------------------------------------------------------------------------------
**/

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(-1);
        ListNode ans = head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head.next = new ListNode(head1.val);
                head1 = head1.next;
            } else if (head1.val > head2.val) { /// Here I'm doing an addition checks which is not required just to check and add elements from both list when they are same.
                head.next = new ListNode(head2.val);
                head2 = head2.next;
            } else {
                head.next = new ListNode(head1.val, new ListNode(head2.val));
                head1 = head1.next;
                head2 = head2.next;
                head = head.next; // as 2 Nodes are added here so head pointer must move 2 steps ahead so.
            }
            head = head.next; // At least 1 elements are added in each loop so head must move 2 step at each loop iteration.
        }
        // Add the remaining Nodes it is granted that at max only 1 ListNode would be remaining
        if (head1 != null) {
            head.next = head1;
        }
        if (head2 != null) head.next = head2;
        return ans.next;
    }


    /*
      -----------------------------------------------------------------------------------------------------------------------
            LeetCode 141: Detect cycle In the Linked List. OR checking whether the list is cyclic or not
      -----------------------------------------------------------------------------------------------------------------------
    **/
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    /*
      -----------------------------------------------------------------------------------------------------------------------
            Return the cycle length from the list means how many elements are there which are forming the cycle
      -----------------------------------------------------------------------------------------------------------------------
    **/
    public static int cycleLength(ListNode head) {
        int cycleLength = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast != slow) return -1; /// What if there was no cycle.

        do {
            slow = slow.next;
            cycleLength++;
        } while (slow != fast);

        return cycleLength;
    }


    /*
    -----------------------------------------------------------------------------------------------------------------------
                LeetCode 202: Happy Number -> A Number is Happy iff its digits squared sum is equal to 1 where this process repeats till 1 is formed or it'll ends in a infinite loop.
    -----------------------------------------------------------------------------------------------------------------------
    **/
    public static boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            fast = getDigitsSquaredSum(getDigitsSquaredSum(fast));
            slow = getDigitsSquaredSum(slow);
            if (fast == 1) return true;
        } while (fast != slow);
        return false;
    }
    public static int getDigitsSquaredSum(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += (rem * rem);
            n /= 10;
        }
        return sum;
    }

    /*
  -----------------------------------------------------------------------------------------------------------------------
        LeetCode 142: Linked Cycle II: if the list does have a cycle return the starting node from where the cycle is being formed.
  -----------------------------------------------------------------------------------------------------------------------
**/
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) { ///  Runs the loop till either the pointer exceeds(reach to End) or there exists a loop.
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast != slow)return null; /// What if there was no cycle.
        fast = head;
        while(fast != slow){
            fast= fast.next;
            slow = slow.next;
        }
        return fast;
    }


    /*
  -----------------------------------------------------------------------------------------------------------------------
        LeetCode 876: Middle Node: Returns the Middle node from the LinkedList.
  -----------------------------------------------------------------------------------------------------------------------
**/
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)break;
        }
        return slow;
    }
}
