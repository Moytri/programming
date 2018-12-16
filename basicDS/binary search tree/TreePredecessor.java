package kormanBST;

import kormanBST.TreeConstruct.TreeNode;

public class TreePredecessor {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		TreeConstruct treeConstruction = new TreeConstruct();
		TreePredecessor predecessor = new TreePredecessor();
		int [] arr = {15,2,3,9,7,4,6,13,17,18,20};
		for(int i = 0; i < arr.length; i++) {
			treeConstruction.construct(arr[i]);
		}
		
		int itemValue = 2;
		SearchItem searchedItem = new SearchItem();
		TreeNode item = searchedItem.search(treeConstruction.root, itemValue);
		
		System.out.println(predecessor.predecessor(treeConstruction.root, item));
	}
	
	public TreeNode predecessor(TreeNode node, TreeNode item) {
		TreeNode store = null;
		if(item.left != null) {
			return treeMaximun(node.left);
		}
		else {
			while(node != item) {
				if(node.data < item.data) {
					store = node; 
					node = node.right;
				}
				else {
					node = node.left;
				}
			}
		}
		return store;
	}

	private TreeNode treeMaximun(TreeNode node) {
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}

}
