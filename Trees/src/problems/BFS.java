package problems;

import java.util.*;

public class BFS {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

/*
*  Leetcode: 102 -> Binary Tree Level Order Traversal.
* Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
* */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int i = 0;
        while (i != list.size()) {
            int j = list.size();
            List<Integer> inner = new ArrayList<>();
            while (i < j) {
                TreeNode cur = list.get(i++);
                inner.add(cur.val);
                if (cur.left != null)
                    list.add(cur.left);
                if (cur.right != null)
                    list.add(cur.right);
            }
            ans.add(inner);
        }

        return ans;
    }

    /*
     *  Leetcode: 637 -> Average of Levels in Binary Tree.
     * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
     * */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null)return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size(); // get the size of current level.
            double sum = 0l;
            for(int i = 0;i<n;i++){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if(cur.left != null)queue.offer(cur.left);
                if(cur.right != null)queue.offer(cur.right);
            }
            ans.add(sum / n);
        }
        return ans;
    }

// Asked in Google -> Return the successor(element next to k in the BFS) of k.
    public static TreeNode successor(TreeNode root, int k) {
        if(root == null)return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left != null)queue.offer(cur.left);
            if(cur.right != null)queue.offer(cur.right);
            if(cur.val == k)return queue.poll();
        }
        return null;
    }


    /*
     * Leetcode: 103 -> Binary Tree Zigzag Level Order Traversal
     * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
     * */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean rev = false;
        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> inner = new ArrayList<>();
            if (!rev) {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode cur = deque.poll();
                    inner.add(cur.val);
                    if (cur.left != null)
                        deque.offer(cur.left);
                    if (cur.right != null)
                        deque.offer(cur.right);
                }
            } else {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode cur = deque.removeLast();
                    inner.add(cur.val);
                    if (cur.right != null)
                        deque.addFirst(cur.right);
                    if (cur.left != null)
                        deque.addFirst(cur.left);
                }
            }
            rev = !rev;
            ans.add(inner);
        }
        return ans;
    }



    /*
     * Leetcode: 116 -> Populating Next Right Pointers in Each Node
     * */
    public Node connect(Node root) {
        if (root == null)
            return null;
        // Queue<Node> queue = new LinkedList<>();
        // queue.offer(root);
        // while(!queue.isEmpty()){
        //     int n = queue.size();
        //     for(int i = 0;i<n;i++){
        //         Node cur = queue.poll();
        //         if(i != n-1)cur.next = queue.peek();
        //         if(cur.left != null)queue.offer(cur.left);
        //         if(cur.right != null)queue.offer(cur.right);
        //     }
        // }

        // return root;


///     Recursive and most Optimal Approach
        // Node left = root.left;
        // Node right = root.right;
        // Node next = root.next;

        // if(left!=null){// means node have both child
        //     left.next=right;
        //     if(next!=null){
        //         right.next=next.left;
        //     }
        //     connect(left);
        //     connect(right);
        // }
        // return root;


///     Iterative and most Optimal Approach
        Node leftMost = root;
        while (leftMost.left != null) {
            Node current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null)
                    current.right.next = current.next.left;
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }


    /*
     * Leetcode: 199 -> Binary Tree Right Side View.
     * */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            ans.add(queue.pollLast().val);
            for(int i = 0;i<n;i++){
                TreeNode cur = queue.poll();
                if(cur.left != null)queue.offer(cur.left);
                if(cur.right != null)queue.offer(cur.right);
            }
        }
        return ans;
    }


    /*
     * Leetcode: 993 -> Cousins in binary tree.
     * Returns true if there exists 2 node with the given values(x,y) and are on the same level with different direct parent.
     * */
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean oneFound = false;
        while(!queue.isEmpty()){
            int k = queue.size();
            for(int i = 0;i<k;i++){
                TreeNode cur = queue.poll();
                if(cur.val == x || cur.val == y){
                    if(oneFound)return true;
                    oneFound = true;
                }
                if(cur.left != null && cur.right !=null && (cur.left.val == x || cur.left.val == y) && (cur.right.val == x || cur.right.val == y))return false; // Direct Siblings.
                if(cur.left != null)queue.offer(cur.left);
                if(cur.right != null)queue.offer(cur.right);
            }
            if(oneFound)return false;
        }
        return false;
    }


    /*
     * Leetcode: 101 -> Return if the given tree is symmetric or not.
     * */
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null)continue;
            if(left == null || right == null)return false;
            if(left.val != right.val) return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
