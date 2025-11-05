package linkedListImplementation_And_Usecase;

public class CustomDoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    /// Default constructor
    public CustomDoublyLinkedList() {
        this.size = 0;
    }

    /// Constructor with one element
    public CustomDoublyLinkedList(int elem) {
        add(elem);
    }

    /// Add element at the end
    public void add(int elem) {
        Node newNode = new Node(elem);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
        }
        size++;
    }

    ///  Inserting at a particular index.
    public void insert(int index, int value) {
        if (index < 0 || index > size) throw new Error("Index Out Of Bound");
        if (index == size) {///  inserting at the last index
            add(value);
            return;
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        int idx = 0;
        Node ptr = head;
        while (idx != index - 1) { ///  iterates and reach to the Node just behind the target index.
            ptr = ptr.nextNode;
            idx++;
        }
        Node newNode = new Node(value);
        ptr.nextNode.prevNode = newNode;
        newNode.nextNode = ptr.nextNode;
        newNode.prevNode = ptr;
        ptr.nextNode = newNode;
        size++;
    }

    /// Add element at the beginning
    public void addFirst(int elem) {
        Node newNode = new Node(elem);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.nextNode = head;
            head.prevNode = newNode;
            head = newNode;
        }
        size++;
    }

    /// Remove the first element
    public void removeFirst() {
        if (head == null)
            throw new RuntimeException("Linked list is empty.");
        head = head.nextNode;
        if (head == null) tail = null; /// If list becomes empty
        if (head != null)
            head.prevNode = null;
        size--;
    }

    /// Remove the last element
    public void removeLast() {
        if (head == null)
            throw new RuntimeException("Linked list is empty.");
        if (head.nextNode == null) { /// if only one node
            head = null;
            tail = null;
        } else {
            tail = tail.prevNode;
            tail.nextNode = null;
        }
        size--;
    }

    /// Get first element
    public int getFirst() {
        if (head == null)
            throw new RuntimeException("Linked list is empty.");
        return head.value;
    }

    /// Get last element
    public int getLast() {
        if (tail == null)
            throw new RuntimeException("Linked list is empty.");
        return tail.value;
    }

    /// Get size of the list
    public int size() {
        return size;
    }

    /// Print the linked list as a string
    @Override
    public String toString() {
//        if (size == 0) return "[]";
        if (size == 0) return " EMPTY ";

        StringBuilder sb = new StringBuilder();
//        sb.append("[");
        Node ptr = head;
        while (ptr != null) {
            sb.append(ptr.value).append(" -> ");
//            if (ptr.nextNode != null) sb.append(", ");
            ptr = ptr.nextNode;
        }
//        sb.append("]");
        sb.append(" END ");
        return sb.toString();
    }

    public void displayInreverse(){
        if (size == 0){
            System.out.println("Empty");
            return;
        }
        Node ptr = tail;
        while (ptr != null){
            System.out.print(ptr.value+" -> ");
//            if (ptr.nextNode != null) System.out.print(" -> ");
            ptr = ptr.prevNode;
        }
        System.out.println(" END");
    }
    /// Private Node class
    private static class Node {
        private Node prevNode;
        private int value;
        private Node nextNode;

        Node(int value) {
            this.value = value;
        }
    }
}
