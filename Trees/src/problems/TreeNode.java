package problems;

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
        public String toString(){
            return ""+this.val;
        }
}
