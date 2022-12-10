import java.util.ArrayList;
import java.util.List;

public class LC1339 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2; node1.right = node3;
        node2.left = node4; node2.right = node5;
        node3.left = node6;
       
        System.out.println(maxProduct(node1));
    }

    public static int maxProduct(TreeNode root) {
        List<Long> subTreeValues = new ArrayList<Long>();
        long rootVal = traverseTree(root, subTreeValues);
        subTreeValues.remove(subTreeValues.size()-1);

        Long retVal = subTreeValues.stream()
            .mapToLong(x -> (rootVal-x)*x)
            .max()
            .getAsLong();
        return (int)(retVal%(Math.pow(10, 9)+7));
    }

    private static long traverseTree(TreeNode root, List<Long> subTreeValues) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            subTreeValues.add(Long.valueOf(root.val));
            return root.val;
        }
        long leftSum = traverseTree(root.left, subTreeValues);
        long rightSum = traverseTree(root.right, subTreeValues);
        long sum = leftSum+rightSum+root.val;
        subTreeValues.add(sum);
        return sum;
    }    
}
