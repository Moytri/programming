package kormanBST;

import kormanBST.TreeConstruct.TreeNode;

public class MinimumItem {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		TreeConstruct treeConstruction = new TreeConstruct();
		MinimumItem minItem = new MinimumItem();
		int [] arr = {6,1,8,2,10,7,3};
		for(int i = 0; i < arr.length; i++) {
			treeConstruction.construct(arr[i]);
		}
		System.out.println(minItem.minimumItem(treeConstruction.root));
	}
	
	public TreeNode minimumItem(TreeNode node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}

}
