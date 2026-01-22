package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFS2 {
    /**
     * LeetCode: 105 -> Construct Binary Tree from Preorder and Inorder Traversal
     * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
     *
     */
    HashMap<Integer, Integer> in = new HashMap<>();
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /// BruteForce Solution.

        // if (preorder.length < 1)
        //     return null;
        // TreeNode root = new TreeNode(preorder[0]); // root Node.
        // int idx = -1;
        // for (int i = 0; i < inorder.length; i++) {
        //     if (inorder[i] == preorder[0]) {
        //         idx = i;
        //         break;
        //     }
        // }
        // root.left = buildTree(Arrays.copyOfRange(preorder, 1, idx + 1), Arrays.copyOfRange(inorder, 0, idx));
        // root.right = buildTree(Arrays.copyOfRange(preorder,idx + 1,preorder.length), Arrays.copyOfRange(inorder, idx+1, inorder.length));
        // return root;

        /// Optimized Solution.
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[preIdx++]);
        int idx = in.get(root.val);

        root.left = build(preorder, start, idx - 1);
        root.right = build(preorder, idx + 1, end);
        return root;
    }

    /**
     * LeetCode: 297 -> Serialize and Deserialize Binary Tree
     * <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/">...</a>
     *
     */
    int idx = 0;

    /// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        preorder(root, list);
        return list.toString();
    }

    private void preorder(TreeNode node, ArrayList<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }
        list.add(node.val + "");
        preorder(node.left, list);
        preorder(node.right, list);
    }

    /// Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Remove [ ]
        data = data.substring(1, data.length() - 1);

        String[] nodes = data.split(", ");

        idx = 0;
        return build(nodes);
    }

    private TreeNode build(String[] nodes) {
        if (idx >= nodes.length)
            return null;

        String val = nodes[idx++];

        if (val.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = build(nodes);
        node.right = build(nodes);

        return node;
    }


    /**
     * LeetCode: 124 -> Binary Tree Maximum Path Sum
     * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
     * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
     * The path sum of a path is the sum of the node's values in the path.
     * Given the root of a binary tree, return the maximum path sum of any non-empty path.
     *
     */
    int ans = 0;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        helper(root);
        return ans;
    }

    public int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);

        left = Math.max(left, 0);
        right = Math.max(right, 0);

        int pSum = left + right + node.val;
        ans = Math.max(ans, pSum);

        return Math.max(left, right) + node.val;
    }


    /**
     * Given a Root Node and an integer array check whether the path with given values exists in the tree or not from the root node.
     *
     */
    public boolean pathExists(TreeNode root, int[] pathArray) {
        return helper(root, pathArray, 0);
    }

    private boolean helper(TreeNode node, int[] pathArray, int index) {
        if (index == pathArray.length) return true;
        if (node == null) return false;
        if (node.val != pathArray[index]) return false;

        return helper(node.left, pathArray, index + 1) || helper(node.right, pathArray, index + 1);
    }


    static void main(String[] args) {
        String[] nodes = {"-10", "9", "20", null, null, "15", "7"};

        TreeNode root = TreeNode.populate(nodes);
        root.prettyDisplay();

        int[] pathArray = {-10, 20, 15};
        DFS2 obj = new DFS2();

        System.out.println(obj.pathExists(root, pathArray));
    }
}
