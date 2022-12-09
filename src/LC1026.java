import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1026 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }   

    public static void main(String[] args) {
        
    }

    public int maxAncestorDiff(TreeNode root) {
                
        List<Integer> ancestors = new ArrayList<Integer>();
        Set<Integer> differences = new HashSet<Integer>();
        maxAncestorDiff(root, ancestors, differences);
        return differences.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    private void maxAncestorDiff(TreeNode root, List<Integer> ancestors, Set<Integer> differences) {
        if( root == null){
            return;
        }
        for(int a : ancestors){
            differences.add(Math.abs(root.val-a));
        }
        ancestors.add(root.val);

        maxAncestorDiff(root.left, ancestors, differences);
        maxAncestorDiff(root.right, ancestors, differences);
        ancestors.remove(ancestors.size()-1);
    }    
}
