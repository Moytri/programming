package tree.binary.lca;
/**
 * Problem: https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
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
public class StepByStepOneNodeToAnother {

	public static void main(String[] args) {

	}
	
	public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathForStart = new StringBuilder();
        StringBuilder pathForDest = new StringBuilder();
        
        find(root, startValue, pathForStart);
        find(root, destValue, pathForDest);
        
        int i = 0, max_i = Math.min(pathForDest.length(), pathForStart.length());
        

        while (i < max_i && pathForStart.charAt(pathForStart.length() - i - 1) 
                            == pathForDest.charAt(pathForDest.length() - i - 1)) {
            ++i;
        }
        
        return "U".repeat(pathForStart.length() - i) + pathForDest.reverse().toString().substring(i);
    }
    
    private boolean find(TreeNode node, int val, StringBuilder sb) {
        if (node.val == val) 
            return true;
        if (node.left != null && find(node.left, val, sb))
            sb.append("L");
        else if (node.right != null && find(node.right, val, sb))
            sb.append("R");
        return sb.length() > 0;
    }    	

}
