public class TreeNode {
    TreeNode() {}
    public TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public int val = 0;
    public TreeNode left;
    public TreeNode right;
}
