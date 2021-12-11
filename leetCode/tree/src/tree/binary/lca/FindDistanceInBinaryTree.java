package tree.binary.lca;

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
 * Problem: https://leetcode.com/problems/find-distance-in-a-binary-tree/
 *
 */
public class FindDistanceInBinaryTree {

	public static void main(String[] args) {

	}
	
	public int findDistance(TreeNode root, int p, int q) {
        StringBuilder sb_p = new StringBuilder();
        StringBuilder sb_q = new StringBuilder();
        
        find(root, p, sb_p);
        find(root, q, sb_q);
        
        int i = 0; int max = Math.min(sb_p.length(), sb_q.length());
        
        while (i < max && sb_p.charAt(sb_p.length() - i - 1) 
               == sb_q.charAt(sb_q.length() - i - 1)) {
            i++;
        }
        
        return sb_p.length() - i + sb_q.length() - i;
    }
    
    private boolean find(TreeNode node, int target, StringBuilder sb) {
        if (node.val == target) return true;
        
        if (node.left != null && find(node.left, target, sb)) {
            sb.append("L");
        }
        
        else if (node.right != null && find(node.right, target, sb)) {
            sb.append("R");
        }
        
        return sb.length() > 0;
    }

}
