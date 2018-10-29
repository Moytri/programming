package ccigraphtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*List of Depths: Given a binary tree, design an algorithm 
which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
*/


/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */


  //Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
  class Solution {
	 List<List<Integer>> outerLs = new LinkedList<>();
	 List<Integer> innerList = new ArrayList<>();;
	 Queue<Node> queue = new LinkedList<>();
    
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {      
	        if(root == null) return outerLs;
	        queue.add(new Node(root, 0));
	        
	        while(!queue.isEmpty()) {
	            Node removedData = queue.remove();
	            
	            if(removedData.data.left != null){
	                queue.add(new Node(removedData.data.left, removedData.level + 1));
	            }
	            
	            if(removedData.data.right != null){
	                 queue.add(new Node(removedData.data.right, removedData.level + 1));
	            }
	 
	            if(!queue.isEmpty() && removedData.level == queue.peek().level) {
	                innerList.add(removedData.data.val);
	                //System.out.println(removedData.data.val + " : " + innerList);
	            }
	            else {
	                innerList.add(removedData.data.val);
	                //System.out.println(removedData.data.val + " + " + innerList);
	                outerLs.add(0, innerList);
	                innerList = new ArrayList<>();
	            }           
	        }
	        return outerLs;       
	    }
    
    static class Node {
        TreeNode data;
        int level;
        Node(TreeNode data, int level) {
            this.data = data;
            this.level = level;
        }
    }
}

public class ListOfDepth {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    
    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            
            List<List<Integer>> ret = new Solution().levelOrderBottom(root);
            
            String out = int2dListToString(ret);
            
            System.out.print(out);
        }
    }
}
