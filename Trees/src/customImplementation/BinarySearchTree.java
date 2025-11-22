package customImplementation;

import java.util.Arrays;

public class BinarySearchTree {
    private Node root;

    private static class Node {
        int value;
        private int height;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public boolean insert(int value) {
        insert(value, root);
        return true;
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (node.value < value) node.right = insert(value, node.right);
        else node.left = insert(value, node.left);

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return node;
    }

    public void populateTree(int[] arr) {
        if (arr.length < 1) return;
        root = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            insert(arr[i], root);
        }
    }

    public void populateSorted(int[] arr) {
        if (arr.length < 1) return;
        int mid = (arr.length - 1) / 2;
        root = new Node(arr[mid]);
        populateSorted(arr, mid + 1, arr.length - 1);
        populateSorted(arr, 0, mid - 1);
    }

    private void populateSorted(int[] arr, int start, int end) {
        if (start > end) return;
        int mid = start + (end - start) / 2;
        insert(arr[mid], root);
        populateSorted(arr, start, mid - 1);
        populateSorted(arr, mid + 1, end);
    }

    public void display() {
        display(root, "Root Node : ");
    }

    private void display(Node node, String details) {
        if (node == null) return;
        System.out.println(details + node.value);
        display(node.left, "Left Child of " + node.value + " is  : ");
        display(node.right, "Right Child of " + node.value + " is  : ");
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getHeight(Node node) {
        if (node == null) return -1;
        return node.height;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) return true;
        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    ///  Node -> Left -> Right
    public void preOrder(){
        System.out.print("Start -> ");
        preOrder(root);
        System.out.println(" END ");
    }

    private void preOrder(Node node) {
        if (node == null)return;
        System.out.print(node.value +" -> ");
        preOrder(node.left);
        preOrder(node.right);
    }

    ///  Left -> Node -> Right
    public void inOrder(){
        System.out.print("Start -> ");
        inOrder(root);
        System.out.println(" END ");
    }

    private void inOrder(Node node) {
        if (node == null)return;
        inOrder(node.left);
        System.out.print(node.value +" -> ");
        inOrder(node.right);
    }

    /// Left -> Right -> Node
    public void postOrder(){
        System.out.print("Start -> ");
        postOrder(root);
        System.out.println(" END ");
    }

    private void postOrder(Node node) {
        if (node == null)return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value +" -> ");
    }


    static void main(String[] args) {
        int[] nums = {5, 3, 2, 4, 8, 6, 6, 7, 10, 9, 11};
        BinarySearchTree bst = new BinarySearchTree();
        bst.populateTree(nums);
        bst.display();
        System.out.println("\n\n--------------------------------------------------------------------------------\n\n");
//        Arrays.sort(nums);
//        bst.populateSorted(nums);
//        bst.display();

        bst.preOrder();
        bst.inOrder();
        bst.postOrder();

    }
}
