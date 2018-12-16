package kormanBST;

import kormanBST.TreeConstruct.TreeNode;

public class TreeSuccessor {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		TreeConstruct treeConstruction = new TreeConstruct();
		TreeSuccessor successor = new TreeSuccessor();
		int [] arr = {15,2,3,9,7,4,6,13,17,18,20};
		for(int i = 0; i < arr.length; i++) {
			treeConstruction.construct(arr[i]);
		}
		
		int itemValue = 2;
		SearchItem searchedItem = new SearchItem();
		TreeNode item = searchedItem.search(treeConstruction.root, itemValue);
		
		System.out.println(successor.successor(treeConstruction.root, item).data);

	}
	
	public TreeNode successor(TreeNode node, TreeNode item) {
		TreeNode store = null;
		if(item.right != null) return treeMinimum(item.right);
		else {
			while(node != item) {
				if(node.data >= item.data) {
					store = node;
					node = node.left;
				}
				else {
					node = node.right;
				}
			}
		}
		return store;
	}

	private TreeNode treeMinimum(TreeNode node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
}
