package microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class BinaryTreeZigZagTraversal {

	public static void main(String[] args) {
		BinaryTreeZigZagTraversal zigzag = new BinaryTreeZigZagTraversal();
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> outer = new ArrayList<>();
		Queue<LevelDetails> queue = new LinkedList<>();
		
		if (root == null) return outer;
		
		queue.add(new LevelDetails(root, 0));
		
		while(!queue.isEmpty()) {
			LevelDetails item = queue.remove();
			
			if (item.level == 0 || item.level%2 == 0) {
				if (item.node.left != null) queue.add(new LevelDetails(item.node.left, item.level + 1));
				if (item.node.right != null) queue.add(new LevelDetails(item.node.right, item.level + 1));
			}
			else {
				if (item.node.right != null) queue.add(new LevelDetails(item.node.right, item.level + 1));
				if (item.node.left != null) queue.add(new LevelDetails(item.node.left, item.level + 1));
			}
			
			if (outer.size() <= item.level) {
				List<Integer> inner = new ArrayList<>();
				outer.add(inner);
			}
			
			List<Integer> tempInner = outer.get(item.level);
			tempInner.add(item.node);			
		}
		
		return outer;
	}
	
	class LevelDetails {
		TreeNode node;
		int level;
		
		public LevelDetails(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

}
