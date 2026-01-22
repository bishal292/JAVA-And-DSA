package problems;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    private int height;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.val = value;
        this.left = null;
        this.right = null;
    }

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.val = value;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return "" + this.val;
    }

    public static TreeNode populate(String[] nodes) {
        if (nodes == null || nodes.length == 0) return null;
        if (nodes[0] == null || nodes[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            // left child
            if (i < nodes.length && nodes[i] != null && !nodes[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(current.left);
            }
            i++;

            // right child
            if (i < nodes.length && nodes[i] != null && !nodes[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public void prettyDisplay() {
        prettyDisplay(this, 0);
    }

    private void prettyDisplay(TreeNode node, int level) {
        if (node == null) return;
        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + node.val);
        } else {
            System.out.println(node.val);
        }
        prettyDisplay(node.left, level + 1);
    }

    static void main(String[] args) {
//        String[] nodes = {"3", "4", "5", "8", "7", "2", "4", null, "6", null, null, "5", null, "6", "8"};
        String[] nodes = {"3","9",null,null,"20","15",null,null,"7"};
        TreeNode root = TreeNode.populate(nodes);
        root.prettyDisplay();
    }
}
