package ccigraphtree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

    
   public boolean isValidBST(TreeNode root) {
       List<TreeNode> ls = new ArrayList<>();
       copyBST(root, ls);
       for(int i = 0; i < ls.size() - 1; i++) {
           if(ls.get(i).val >= ls.get(i+1).val) return false;
       }
       return true;
   }
   
   private void copyBST(TreeNode root, List ls) {
       if(root == null) return;
       copyBST(root.left, ls);
       ls.add(root);
       copyBST(root.right, ls);
   }

}
