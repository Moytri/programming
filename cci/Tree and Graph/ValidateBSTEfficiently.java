package ccigraphtree;

public class ValidateBSTEfficiently {

	private static Long min = Long.MIN_VALUE;
	private static Long max = Long.MAX_VALUE;
	    
   	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, min, max);
	}

	public static boolean isValidBST(TreeNode root, long min, long max) {
		if(root == null) return true;
		if(root.data <= min || root.data >= max) return false;
		return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
	}
	
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data) {
			this.data = data;
		}
	}
}
