package kormanBST;

import kormanBST.TreeConstruct.TreeNode;

public class SearchItem {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		TreeConstruct treeConstruction = new TreeConstruct();
		SearchItem searchedItem = new SearchItem();
		int [] arr = {6,1,8,2,10,7,3};
		for(int i = 0; i < arr.length; i++) {
			treeConstruction.construct(arr[i]);
		}
		System.out.println(searchedItem.search(treeConstruction.root, 8));
		System.out.println(searchedItem.searchItem(treeConstruction.root, 8));
	}
	
	//recursive
	public TreeNode search(TreeNode node, int data) {
		if(node == null || node.data == data) return node;
		if(node.data > data) return search(node.left, data);
		return search(node.right, data);
	}
	
	//iterative
    public TreeNode searchItem(TreeNode node, int data) {
    	while(node != null) {
    		if(node.data == data) return node;
    		if(node.data > data) node = node.left;
    		else node = node.right;
    	}
    	return node;
    }
}
