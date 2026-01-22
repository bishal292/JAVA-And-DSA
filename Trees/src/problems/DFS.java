package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFS {
    static int ans = Integer.MIN_VALUE;

    /**
    * LeetCode: 543 -> Diameter of Binary Tree.
    * Given the root of a binary tree, return the length of the diameter of the tree.
    * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
    * */
    public static int diameterOfBinaryTree(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }
    public static int dfs(TreeNode node){
        if(node == null)return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        ans= Math.max(ans,left + right);
        return Math.max(left,right) + 1;
    }

    /**
    * LeetCode: 226 -> Invert Binary Tree.
    * Given the root of a binary tree, invert the tree, and return its root.
    * */
    public TreeNode invertTree(TreeNode root) {
        if(root == null)return null;
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

    /**
     * LeetCode: 104 -> Maximum Depth of Binary Tree.
     * Given the root of a binary tree, return its maximum depth.
     * */
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right)+1;
    }


    /**
     * LeetCode: 108 -> Convert Sorted Array to Binary Search Tree.
     * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
     * */
    TreeNode root;
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        root = new TreeNode(nums[mid]);
        populate(nums,0,mid - 1);
        populate(nums,mid + 1,nums.length - 1);
        return root;
    }
    public void populate(int[] arr,int start,int end){
        if(start > end)return;
        int mid = start + (end - start)/2;
        insert(root,arr[mid]);
        populate(arr,start,mid - 1);
        populate(arr,mid + 1,end);
    }
    public TreeNode insert(TreeNode node,int val){
        if(node == null)return new TreeNode(val);
        if(node.val < val){
            node.right = insert(node.right,val);
        }else{
            node.left = insert(node.left,val);
        }
        return node;
    }


    /**
     * LeetCode: 114 -> Flatten Binary Tree to Linked List
     * Given the root of a binary tree, flatten the tree into a "linked list" where the type of linked list must be TreeNode.
     * */
    public void flatten(TreeNode root) {
//        flat(root);
        if(root == null)return;

        List<TreeNode> list = new LinkedList<>(); /// Store the nodes in a pre-Order-Traversal Order. then flatten the tree.
        pot(list,root);
        for(int i = list.size() - 2;i >= 0;i--){
            TreeNode cur = list.get(i);
            cur.left = null;
            cur.right = list.get(i + 1);
        }
    }
    public void pot(List<TreeNode> list,TreeNode node){
        if(node == null)return;
        list.add(node);
        pot(list,node.left);
        pot(list,node.right);
    }
    public TreeNode flat(TreeNode node){
        if(node == null)return null;

        TreeNode leftNode = flat(node.left);
        TreeNode rightNode = flat(node.right);

        if(leftNode != null){
            leftNode.right = node.right; // As it is recursive approach means on this level already all the right should be arranged and if there is leftNode then it would be only one.
            node.right = node.left;
            node.left = null;
        }
        if(rightNode != null)return rightNode;
        if(leftNode != null)return leftNode;
        return node;
    }

    /**
     * LeetCode: 236 -> Lowest Common Ancestor of a Binary Tree
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        return (left != null && right != null) ? root : (left != null ? left : right);
    }

    /**
     * LeetCode: 230 -> Kth Smallest Element in a BST(Binary Search Tree).
     * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
     * */
    int curIdx = 0;
    public int kthSmallest(TreeNode root, int k) {
        curIdx = 0;
        ArrayList<TreeNode> list = new ArrayList<>();
        return inorder(root,k).val;
    }
    public TreeNode inorder(TreeNode node,int k){
        if(node == null)return null;
        TreeNode left = inorder(node.left,k);
        if(left != null)return left;
        curIdx++;
        if(curIdx == k)return node;
        return inorder(node.right,k);
    }

    /**
     * LeetCode: 112 -> Path Sum.
     * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
     * */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)return false;
        int v = root.val;
        if(root.left == null && root.right == null && targetSum - v == 0)return true;
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }


    /**
     * LeetCode: 129 -> Sum Root to Leaf Numbers
     * You are given the root of a binary tree containing digits from 0 to 9 only.
     * Each root-to-leaf path in the tree represents a number.
     * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
     * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
     * */
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode node, int preSum) {
        if(node == null)return 0;

        preSum = preSum * 10 + node.val;
        if(node.left == null && node.right == null)return preSum;

        return helper(node.left,preSum) + helper(node.right,preSum);
    }
    public static void main(String[] args) {
//        String[] nodes = new String[]{"5","4","8","11",null,"13","4","7","2",null,null,null,"1"};
        String[] nodes = new String[]{"1","2","3","4","5"};
        TreeNode root = TreeNode.populate(nodes);
//        root.prettyDisplay();
        System.out.println(diameterOfBinaryTree(root));
    }
}
