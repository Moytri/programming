package microsoft;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 */
/*
//Definition for a Node.
class Node {
 public int val;
 public Node left;
 public Node right;
 public Node next;

 public Node() {}
 
 public Node(int _val) {
     val = _val;
 }

 public Node(int _val, Node _left, Node _right, Node _next) {
     val = _val;
     left = _left;
     right = _right;
     next = _next;
 }
};
*/
public class NextRightPointer {

	public static void main(String[] args) {
		NextRightPointer nextRight = new NextRightPointer();
	}
	
	public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<LevelDetails> queue = new LinkedList<>();        
        queue.add(new LevelDetails(root, 0));
        
        while (!queue.isEmpty()) {
            LevelDetails item = queue.remove();
            
            if (item.node == root) item.node.next = null;
            else {
                if (!queue.isEmpty() && item.level == queue.peek().level) {
                    item.node.next = queue.peek().node;
                }
                else {
                    item.node.next = null;
                }
            }
            
            if (item.node.left != null) queue.add(new LevelDetails(item.node.left, item.level + 1));
            if (item.node.right != null) queue.add(new LevelDetails(item.node.right, item.level + 1));
        }
        
        return root;
    }
    
    class LevelDetails {
        Node node;
        int level;
        
        public LevelDetails(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }	

}
