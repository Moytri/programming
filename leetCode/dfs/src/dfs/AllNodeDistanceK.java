package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.tree.TreeNode;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 */
public class AllNodeDistanceK {
	List<Integer> distancedK;
    List<TreeNode> path;
    Set<TreeNode> visited;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        distancedK = new ArrayList<>();
        path = new ArrayList<>();
        visited = new HashSet<>();
        
        distance(root, target, k);
        return distancedK;
    }
    
    public void distance(TreeNode root, TreeNode target, int k) {
        find(root, target, path);
        
        for (int i = path.size() - 1; i >= 0; i--) {
            visited.add(path.get(i));
            dfs(path.get(i), 0, k--);
        }
    }
    
    public void dfs(TreeNode node, int distance, int k) {
        if (node == null) return;
        if (distance == k) {
            distancedK.add(node.val);
        }
        if (!visited.contains(node.left)) dfs(node.left, distance + 1, k);
        if (!visited.contains(node.right)) dfs(node.right, distance + 1, k);
    }
    
    public boolean find(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
                
        if (root== target) {
            return true; 
        }
        
        if(find(root.left, target, path) || find(root.right, target, path))
            return true;
        
        path.remove(path.size() - 1);
        return false;
    }
}
