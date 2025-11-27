package customImplementation;

public class SegmentTree {
    private class Node {
        int data;
        int startIndex;
        int endIndex;
        Node left;
        Node right;

        Node(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public String toString() {
            return "" + this.data + " Start : " + this.startIndex + " End: " + this.endIndex;
        }
    }

    Node root;

    public void populate(int[] arr) {
        if (arr.length < 1) return;
        root = insert(arr, 0, arr.length - 1);
    }

    public Node insert(int[] arr, int start, int end) {
        if (start > end) return null;
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        Node node = new Node(start, end);
        int mid = start + (end - start) / 2;
        node.left = insert(arr, start, mid);
        node.right = insert(arr, mid + 1, end);
        node.data = node.left.data + node.right.data;

        return node;
    }


    public void display() {
        display(root, "Root Node : ");
    }

    private void display(Node node, String details) {
        if (node == null) return;
        System.out.println(details + node.data);
        display(node.left, "Left Child of " + node.data + " is  : ");
        display(node.right, "Right Child of " + node.data + " is  : ");
    }


    public int getSumInRange(int start, int end) {
        return getSumInRange(root, start, end);
    }

    private int getSumInRange(Node node, int start, int end) {
        if (node.startIndex >= start && node.endIndex <= end) {
            return node.data;
        }
        if (node.startIndex > end || node.endIndex < start) return 0;
//        int left = getSumInRange(node.left,start,end);
//        int right = getSumInRange(node.right,start,end);
//        return left + right;

        return getSumInRange(node.left, start, end) + getSumInRange(node.right, start, end);
    }

    public void update(int index, int value) {
        root.data = update(root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startIndex && index <= node.endIndex) {
            if (node.startIndex == index && node.endIndex == index) {
                node.data = value;
                return value;
            } else {
                node.data = update(node.left, index, value) + update(node.right, index, value);
            }
        }
        return node.data;
    }

    static void main(String[] args) {
        SegmentTree st = new SegmentTree();

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        st.populate(arr);
        st.display();
        System.out.println("\n-----------------------------------------------------------\n");
        System.out.println(st.getSumInRange(1, 5));
        System.out.println(st.root);
        st.update(0,10);
        System.out.println(st.root);
        st.display();

    }
}
