package ccigraphtree;

/*Minimal Tree: Given a sorted (increasing order) array 
with unique integer elements, write an
algorithm to create a binary search tree with minimal height.*/

public class MinimalTree {
	private static Node root;
	public static void main(String[] args) {
		int [] arr = {1,2,3,5,6,8,9,10};
		createMinimalTree(arr);
	}
	
	public static void createMinimalTree(int [] arr) {
		root = createMinimalTree(arr, 0, arr.length - 1);
	}
	
	public static Node createMinimalTree(int [] arr, int start, int end) {
		if(end < start) return null;
		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);
		node.left = createMinimalTree(arr, start, mid - 1);
		node.right = createMinimalTree(arr, mid + 1, end);
		return node;
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
	}
}
