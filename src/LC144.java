import java.util.ArrayList;
import java.util.List;

public class LC144 {
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> retList = new ArrayList<Integer>();
        poRec(root, retList);
        return retList;        
    }

    private static void poRec(TreeNode root, List<Integer> retList) {
        if(root == null){            
            return;
        }        
        retList.add(root.val);
        poRec(root.left, retList);
        poRec(root.right, retList);
        return;
    }  
}
