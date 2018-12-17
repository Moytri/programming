package kormanBST;

import kormanBST.TreeConstruct.TreeNode;

public class TreeConstructWithParent {

	static TreeNode root = null;
	public static void main(String[] args) {
		TreeConstructWithParent treeConstruction = new TreeConstructWithParent();
		int [] arr = {15,6,3,7,13,4,2,9,18,17,20};
		for(int i = 0; i < arr.length; i++) {
			treeConstruction.construct(arr[i]);
		}
		System.out.println("Inorder: ");
		treeConstruction.inOrderTraversal(TreeConstructWithParent.root);
	}

	public void construct(int data) {
		root = insert(root, data);
	}
	
	private TreeNode insert(TreeNode node, int data) {
		TreeNode temp = null;
        if(node == null) {
        	return new TreeNode(data);
        }
        
        if(node.val >= data) {
            temp = insert(node.left, data);
            node.left = temp;
        	temp.parent = node;
        }
        else {
        	temp = insert(node.right, data);
        	node.right = temp;
        	temp.parent = node;
        }
		return node;
	}
	
	public void inOrderTraversal(TreeNode node) {
		if(node != null) {
			inOrderTraversal(node.left);
			if(node.parent != null) {
				System.out.print("node:" + node.val + " parent:" + node.parent.val + "; ");
			}
			else {
				System.out.print("node:" + node.val + " ");
			}			
			inOrderTraversal(node.right);
		}
	}

	class TreeNode {
		int val;
		TreeNode parent;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
			this.parent = null;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return "TreeNode :: val=" + val + ", parent=" + parent.val + ", left=" + left + ", right=" + right + " ; ";
		}		
	}

}
