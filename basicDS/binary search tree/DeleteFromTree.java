package kormanBST;

import kormanBST.TreeConstruct.TreeNode;

public class DeleteFromTree {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		TreeConstruct treeConstruction = new TreeConstruct();
		DeleteFromTree deleteNode = new DeleteFromTree();
		int [] arr = {15,2,3,9,7,4,6,13,17,18,20};
		for(int i = 0; i < arr.length; i++) {
			treeConstruction.construct(arr[i]);
		}
		
		InOrder inOrderPrint = new InOrder();
		System.out.println("Tree Before deletion: ");
		inOrderPrint.inOrder(treeConstruction.root);
		
		deleteNode.delete(2);
		System.out.println("\nAfter deleting 2 the tree looks like: ");
		inOrderPrint.inOrder(treeConstruction.root);
	}
	
	@SuppressWarnings("static-access")
	public TreeNode delete(int item) {
		TreeConstruct treeConstruction = new TreeConstruct();
		return delete(treeConstruction.root, item);
	}

	private TreeNode delete(TreeNode root, int item) {
		//start with the root node
		TreeNode node = root;
		//pointer to set the parent node
		TreeNode parent = null;
		
		//case 1: Node exists and has no subtree/child
        //identify the parent pointer of the node to be deleted and set as parent node
        while(node != null && node.data != item) {
			parent = node;
			if(node.data >= item) {
				node = node.left;
			}
			else {
				node = node.right;
			}
		}
        
        //the node we want to delete does not exist
        if(node == null) return root;
		
        //deletion process
        if(node.left == null && node.right == null) {
        	if(node != root) {
        		if(parent.left == node) {
        			parent.left = null;
        		}
        		else {
        			parent.right = null;
        		}
        	}
        	//the node to be deleted exists and root node
        	else {
        		root = null;
        	}
        }
        
        //If the node to be deleted has one child/subtree
        else if((node.left == null && node.right != null) ||
                (node.left != null && node.right == null)) {
        	
        	//identify the child whether left or right of the node
        	TreeNode child = node.left == null ? node.right : node.left;
        	
        	if(node != root) {
        		if(parent.left == node) {
        			parent.left = child;
        		}
        		else {
        			parent.right = child;
        		}
        	}
        	else {
        		root = child;
        	}
        }
        
        else {
        	TreeNode successor = treeMinimum(node.right);
        	
        	int successorItem = successor.data;
        	delete(root, successorItem);
        	
        	node.data = successorItem;
        	
        }
		return root;
	}

	private TreeNode treeMinimum(TreeNode node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}

}
