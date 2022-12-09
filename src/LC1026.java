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
        ancestors.add(root.val);
        // Set<Integer> differences = new HashSet<Integer>();
        // maxAncestorDiff(root, ancestors, differences);
        // return differences.stream().mapToInt(Integer::intValue).max().getAsInt();
        return maxAncestorDiff(root, ancestors, 0);
    }

    // private void maxAncestorDiff(TreeNode root, List<Integer> ancestors, Set<Integer> differences) {
    //     if( root == null){
    //         return;
    //     }
    //     for(int a : ancestors){
    //         differences.add(Math.abs(root.val-a));
    //     }
    //     ancestors.add(root.val);

    //     maxAncestorDiff(root.left, ancestors, differences);
    //     maxAncestorDiff(root.right, ancestors, differences);
    //     ancestors.remove(ancestors.size()-1);
    // }    

    private int maxAncestorDiff(TreeNode root, List<Integer> ancestors, int maxDiff) {
        if( root == null){
            return maxDiff;
        }
        int diff = ancestors.stream().mapToInt(x -> Math.abs(x - root.val)).max().getAsInt();
        maxDiff = (diff > maxDiff)?diff:maxDiff;
        ancestors.add(root.val);

        maxDiff = maxAncestorDiff(root.left, ancestors, maxDiff);
        maxDiff = maxAncestorDiff(root.right, ancestors, maxDiff);
        ancestors.remove(ancestors.size()-1);
        return maxDiff;
    }    

}
