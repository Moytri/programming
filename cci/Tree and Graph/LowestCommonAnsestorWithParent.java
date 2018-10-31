package ccigraphtree;

import ccigraphtree.LowestCommonAnsestor.Node;

public class LowestCommonAnsestorWithParent {

	Node n1, n2, lca; 
	public static void main(String[] args) {
		LowestCommonAnsestorWithParent tree = new LowestCommonAnsestorWithParent();
		Node root = null; 
	    root = tree.insert(root, 20); 
	    root = tree.insert(root, 8); 
	    root = tree.insert(root, 22); 
	    root = tree.insert(root, 4); 
	    root = tree.insert(root, 12); 
	    root = tree.insert(root, 10); 
	    root = tree.insert(root, 14); 
	    
        tree.n1 = root.left.left; 
        tree.n2 = root.left.right; 
        tree.lca = tree.commonAncestor(root, tree.n1, tree.n2);
        
        System.out.println("LCA of " + tree.n1.data + " and " + tree.n2.data 
               + " is " + tree.lca.data);
	}
	
	public Node commonAncestor(Node root, Node p, Node q) {
		int depth_P = getDepth(p);
		int depth_Q = getDepth(q);
		int depth = depth_P - depth_Q;
		// get closer node to root as p - q == positive number so that depth of p > depth of q
		Node close = (depth > 0) ? q : p;
		Node distance = (depth > 0) ? p : q;
		distance = getUp(distance, Math.abs(depth));
		
		while(close != distance && close != null && distance != null) {
			close = close.parent;
			distance = distance.parent;
		}		
		return close == null || distance == null ? null : close;
	}
	
	public Node getUp(Node node, int depth) {
		while(depth > 0 && node != null) {
			depth--;
			node = node.parent;
		}
		return node;
	}
	
	public int getDepth(Node node) {
		int depth = 0;
		while(node != null) {
			depth++;
			node = node.parent;
		}
		return depth;
	}
	
	Node insert(Node node, int data) { 

		if (node == null) { 
			return (new Node(data)); 
		} else { 
			Node temp = null; 
			
			if (data <= node.data) { 
				temp = insert(node.left, data); 
				node.left = temp; 
				temp.parent = node; 

			} else { 
				temp = insert(node.right, data); 
				node.right = temp; 
				temp.parent = node; 
			} 
			return node; 
		} 
	} 
	
	static class Node { 
		int data; 
		Node left, right, parent; 

		Node(int d) { 
			data = d; 
			left = right = parent = null; 
		} 
	}
}
