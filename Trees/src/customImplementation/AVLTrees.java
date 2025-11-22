package customImplementation;

public class AVLTrees {
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

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (node.value < value) node.right = insert(value, node.right);
        else node.left = insert(value, node.left);

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotateIfUnbalanced(node);
    }

    private Node rotateIfUnbalanced(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            ///  Left - Sub Tree is heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                ///  Left - Left Heavy
                return rightRotate(node);
            } else { ///  As it is confirmed to be left Heavy and if it is not left-left heavy then it is obviously left-right heavy.
                node = leftRotate(node);
                return rightRotate(node);
            }
        }
        if (height(node.left) - height(node.right) < -1) {
            ///  Right - Sub Tree is heavy
            if (height(node.right.right) - height(node.right.left) > 0) {
                ///  Right - Right Heavy
                return leftRotate(node);
            } else { ///  As it is confirmed to be Right Heavy and if it is not Right-Right heavy then it is obviously right-left heavy.
                node = rightRotate(node);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node parent) {
        Node child = parent.left;
        Node t2 = child.right;

        child.right = parent;
        parent.left = t2;

        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;

        return child;
    }

    private Node leftRotate(Node parent) {
        Node child = parent.right;
        Node t2 = child.left;

        child.left = parent;
        parent.right = t2;

        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;

        return child;
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

    public int getHeightTree() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return -1;
        return node.height;
    }

    ///  Node -> Left -> Right
    public void preOrder() {
        System.out.print("Start -> ");
        preOrder(root);
        System.out.println(" END ");
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.value + " -> ");
        preOrder(node.left);
        preOrder(node.right);
    }

    ///  Left -> Node -> Right
    public void inOrder() {
        System.out.print("Start -> ");
        inOrder(root);
        System.out.println(" END ");
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " -> ");
        inOrder(node.right);
    }

    /// Left -> Right -> Node
    public void postOrder() {
        System.out.print("Start -> ");
        postOrder(root);
        System.out.println(" END ");
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " -> ");
    }


    static void main(String[] args) {
        AVLTrees avlTrees = new AVLTrees();
        for (int i = 1; i < 20; i++) {
            avlTrees.insert(i);
        }
        System.out.println(avlTrees.getHeightTree());
        avlTrees.display();
        System.out.println((int) (Math.log10(1000) / Math.log10(2)) + 1);
    }
}
