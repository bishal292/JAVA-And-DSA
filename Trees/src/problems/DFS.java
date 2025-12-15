package problems;

public class DFS {
    /*
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

    /*
     * LeetCode: 104 -> Maximum Depth of Binary Tree.
     * Given the root of a binary tree, return its maximum depth.
     * */
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right)+1;
    }


    /*
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
}
