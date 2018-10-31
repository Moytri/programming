package ccigraphtree;

public class LowestCommonAnsestor {
	Node n1, n2, lca; 
	public static void main(String[] args) {
		LowestCommonAnsestor tree = new LowestCommonAnsestor();
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
		boolean p_left = false;
		boolean q_left = false;
		boolean p_right = false;
		boolean q_right = false;
		
		if(root == null) return null;
		
		if(root.data == p.data) p_left = p_right = true;
		else {
			p_left = search(root.left, p);
			if(!p_left) {
				p_right = search(root.right, p);
			}
		}
		
		if(root.data == q.data) q_left = q_right = true;
		else {
			q_left = search(root.left, q);
			if(!q_left) {
				q_right = search(root.right, q);
			}
		}
		
		if(p_left && q_right) return root;
		if(p_right && q_left) return root;
		if(p_left && q_left) return commonAncestor(root.left, p, q);
		return commonAncestor(root.right, p, q);
	}
	
	public boolean search(Node root, Node q) {
		if (root != null) {
			if (root.data == q.data) {
				return true;
			} else {
				return search(root.left, q) || search(root.right, q);
			}
		}
		return false;
	}
	
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
	
	static class Node { 
		int data; 
		Node left, right, parent; 

		Node(int d) { 
			data = d; 
			left = right = parent = null; 
		} 
	}
}
