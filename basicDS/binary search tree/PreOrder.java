package kormanBST;

import java.util.Stack;

import kormanBST.TreeConstruct.TreeNode;

public class PreOrder {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		TreeConstruct treeConstruction = new TreeConstruct();
		PreOrder preOrderPrint = new PreOrder();
		int [] arr = {6,1,8,2,10,7,3};
		for(int i = 0; i < arr.length; i++) {
			treeConstruction.construct(arr[i]);
		}
		preOrderPrint.preOrder(treeConstruction.root);
		System.out.println();
		preOrderPrint.preOrder(treeConstruction.root);
	}
	
	public void preOrder(TreeNode node) {
		if(node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void preOrderPrint(TreeNode node) {
		Stack<TreeNode> stack = new Stack<>();
		
		if(node == null) return;		
		stack.push(node);
		
		while(!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			System.out.print(curr.data + " ");
			stack.push(curr.left);
			stack.push(curr.right);
		}
	}

}
