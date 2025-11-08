package problemsOnLinkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void add(int value) {
        ListNode ptr = this;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new ListNode(value);
    }

    public String toString() {
        ListNode ptr = this;
        StringBuilder sb = new StringBuilder();
        while (ptr != null) {
            sb.append(ptr.val).append(" -> ");
            ptr = ptr.next;
        }
        sb.append("END");
        return sb.toString();
    }
}
