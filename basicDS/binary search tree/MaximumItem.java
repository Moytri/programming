package kormanBST;

import kormanBST.TreeConstruct.TreeNode;

public class MaximumItem {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		TreeConstruct treeConstruction = new TreeConstruct();
		MaximumItem maxItem = new MaximumItem();
		int [] arr = {6,1,8,2,10,7,3};
		for(int i = 0; i < arr.length; i++) {
			treeConstruction.construct(arr[i]);
		}
		System.out.println(maxItem.maximumItem(treeConstruction.root));
	}
	
	public TreeNode maximumItem(TreeNode node) {
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}

}
