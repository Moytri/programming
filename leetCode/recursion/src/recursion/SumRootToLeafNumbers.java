package recursion;

/**
 * Problem: https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class SumRootToLeafNumbers {

	public static void main(String[] args) {

	}
	public int sumNumbers(TreeNode root) {
        return totalSum(root, 0);
    }
    
    public int totalSum(TreeNode root, int sum) {
        if (root == null) return 0;
        
        sum = root.val + sum * 10;
        
        if (root.left == null && root.right == null) return sum;
        
        return totalSum(root.left, sum) + totalSum(root.right, sum);
    }

}
