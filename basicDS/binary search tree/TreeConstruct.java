package kormanBST;

public class TreeConstruct {
	static TreeNode root = null;
	public static void main(String [] args) {
		TreeConstruct treeConstruction = new TreeConstruct();
		int [] arr = {6,1,8,2,10,7,3};
		for(int i = 0; i < arr.length; i++) {
			treeConstruction.construct(arr[i]);
		}
	}
	
    public void construct(int data) {
    	root = construct(root, data);
    }
	
	private TreeNode construct(TreeNode node, int data) {
		if(node == null) {
			return new TreeNode(data);
		}
		if(node.data > data) {
			node.left = construct(node.left, data);
		}
		else {
			node.right = construct(node.right, data);
		}
		return node;
	}

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
			
	}
}
