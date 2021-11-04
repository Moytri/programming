package recursion;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/sum-of-left-leaves/
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class SumOfLeftLeaves {

	public static void main(String[] args) {
	}
	
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }
    public int sum(TreeNode root, boolean isLeft) {
        if (root == null) return 0;

        if (isLeft && root.left == null && root.right == null) return root.val;
        return sum(root.left, true) + sum(root.right, false);
    }

}
