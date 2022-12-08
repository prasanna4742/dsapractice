import java.util.ArrayList;
import java.util.List;

public class LC872 {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafList1 = new ArrayList<Integer>();
        List<Integer> leafList2 = new ArrayList<Integer>();
        traverse(root1, leafList1);
        traverse(root2, leafList2);
        System.out.println(leafList1);
        System.out.println(leafList2);
        return leafList1.equals(leafList2);
    }

    private void traverse(LC872.TreeNode root, List<Integer> leafList) {

        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafList.add(root.val);
            return;
        }
        traverse(root.left, leafList);
        traverse(root.right, leafList);
    }

}
