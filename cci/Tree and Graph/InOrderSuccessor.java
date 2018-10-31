package ccigraphtree;

public class InOrderSuccessor {	
	static Node head; 
	public static void main(String[] args) {
		InOrderSuccessor tree = new InOrderSuccessor(); 
		Node root = null; 
		root = tree.insert(root, 20); 
		root = tree.insert(root, 8); 
		root = tree.insert(root, 22); 
		root = tree.insert(root, 4); 
		root = tree.insert(root, 12); 
		root = tree.insert(root, 10); 
		root = tree.insert(root, 14); 
	}

	/* Given a binary search tree and a number, 
	inserts a new node with the given number in 
	the correct place in the tree. Returns the new 
	root pointer which the caller should then use 
	(the standard trick to avoid using reference 
	parameters). */
	Node insert(Node node, int data) { 

		/* 1. If the tree is empty, return a new,	 
		single node */
		if (node == null) { 
			return (new Node(data)); 
		} else { 

			Node temp = null; 
			
			/* 2. Otherwise, recur down the tree */
			if (data <= node.data) { 
				temp = insert(node.left, data); 
				node.left = temp; 
				temp.parent = node; 

			} else { 
				temp = insert(node.right, data); 
				node.right = temp; 
				temp.parent = node; 
			} 

			/* return the (unchanged) node pointer */
			return node; 
		} 
	} 

	Node inOrderSuccessor(Node root, Node n) {
		if(n.right != null) {
			return getMin(n.right);
		}
		Node parent = n.parent;
		while(parent != null && n == parent.right) {
			n = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	Node getMin(Node node) {
		if(node.left == null) return node;
		return getMin(node.left);
	}
	 // A binary tree node 
	static class Node { 
		int data; 
		Node left, right, parent; 

		Node(int d) { 
			data = d; 
			left = right = parent = null; 
		} 
	}
}
