package microsoft.com.all.frequencies.tree;

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
/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 *
 */
public class CountGoodNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int goodNodes(TreeNode root) {
		int max = Integer.MIN_VALUE;
		return countGoodNode(root, max);
	}
	    
	public int countGoodNode(TreeNode root, int max) {
	    if (root == null) return 0;
	    
	    if (root.val > max) {
	        max = root.val;
	    }
	
	    return (root.val >= max ? 1 : 0) + 
	        countGoodNode(root.left, max) + 
	        countGoodNode(root.right, max);
	}	

}
