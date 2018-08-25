
100. Same Tree
DescriptionHintsSubmissionsDiscussSolution
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false

*/
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        
	        Queue<TreeNode> tree_One = new LinkedList<>();
	        Queue<TreeNode> tree_Two = new LinkedList<>();
	        
	        if(p == null && q == null) return true;
	        
	        if(p != null && q != null) {
	            if(p.val != q.val) {
	                return false;
	            } 
	            else {
	                tree_One.add(p);
	                tree_Two.add(q);
	            }
	        }

	            
	        if(p == null && q != null) return false;
	        if(p != null && q == null) return false;
	            
	        while(!tree_One.isEmpty() && !tree_Two.isEmpty()) {


	            if(tree_One.peek().val != tree_Two.peek().val) return false;

	            if((tree_One.peek().left == null && tree_Two.peek().left != null))   return false;
	            if((tree_One.peek().left != null && tree_Two.peek().left == null))   return false;
	            if((tree_One.peek().right == null && tree_Two.peek().right != null)) return false;
	            if((tree_One.peek().right != null && tree_Two.peek().right == null)) return false;

	            if(tree_One.peek().left != null && tree_Two.peek().left != null) {                  
	                    tree_One.add(tree_One.peek().left);
	                    tree_Two.add(tree_Two.peek().left);
	            }

	            if(tree_One.peek().right != null && tree_Two.peek().right != null) {
	                    tree_One.add(tree_One.peek().right);
	                    tree_Two.add(tree_Two.peek().right);
	            }  

	            tree_One.remove();
	            tree_Two.remove();
	        }
	            
	        return true;
	    }
	}
