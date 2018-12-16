package kormanBST;

import kormanBST.TreeConstruct.TreeNode;

public class InsertInToTree {

	public static void main(String[] args) {
		TreeConstruct treeConstruction = new TreeConstruct();
		InsertInToTree node = new InsertInToTree();
		int [] arr = {15,2,3,9,7,4,6,13,17,18,20};
		for(int i = 0; i < arr.length; i++) {
			treeConstruction.construct(arr[i]);
		}
		
		node.insert(10);

	}
	
	@SuppressWarnings("static-access")
	public TreeNode insert(int data) {
		TreeConstruct treeConstruction = new TreeConstruct();
		return insert(treeConstruction.root, data);
	}

	private TreeNode insert(TreeNode root, int data) {
		TreeNode newNode = new TreeNode(data);		
		if(root == null) return newNode;
		
		TreeNode parent = null;
		TreeNode curr = root;
		
		//iterate until leaf is null
		//to find the parent to whose 
		//left or right child will be the given node
		while(curr != null) {
			parent = curr;
			if(curr.data > data) {
				curr = curr.left;
			}
			else {
				curr = curr.right;
			}
		}
		
		if(parent.data > data) {
			parent.left = newNode;
		}
		else {
			parent.right = newNode;
		}
		
		return root;
		
	}

}
