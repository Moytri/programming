package kormanBST;

import java.util.Stack;

import kormanBST.TreeConstruct.TreeNode;

public class InOrder {

	@SuppressWarnings("static-access")
	public static void main(String [] args) {
		TreeConstruct treeConstruction = new TreeConstruct();
		InOrder inOrderPrint = new InOrder();
		int [] arr = {15,2,3,9,7,4,6,13,17,18,20};
		for(int i = 0; i < arr.length; i++) {
			treeConstruction.construct(arr[i]);
		}
		
		inOrderPrint.inOrderTraversal(treeConstruction.root);
		System.out.println();
		inOrderPrint.inOrder(treeConstruction.root);
	}
	
	public void inOrderTraversal(TreeNode node) {
		if(node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
	}
	
	public void inOrder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<>();
		
		if(node == null) return;
		TreeNode curr = node;
		
		 // traverse the tree 
        while (curr != null || stack.size() > 0) 
        { 
  
            /* Reach the left most Node of the 
            curr Node */
            while (curr !=  null) 
            { 
            	  /* place pointer to a tree node on 
                the stack before traversing 
               the node's left subtree */
                stack.push(curr); 
                curr = curr.left; 
            } 
  
            /* Current must be NULL at this point */
            curr = stack.pop(); 
  
            System.out.print(curr.data + " "); 
  
            /* we have visited the node and its 
            left subtree.  Now, it's right 
            subtree's turn */
            curr = curr.right; 
        } 
	}
}
