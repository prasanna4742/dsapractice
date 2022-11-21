import java.util.ArrayDeque;
import java.util.Queue;

public class TraverseTree {
    public static void main(String[] args) {
    
        TreeNode node1 = new TreeNode(); node1.value=1;
        TreeNode node2 = new TreeNode(); node2.value=2;
        TreeNode node3 = new TreeNode(); node3.value=3;
        TreeNode node4 = new TreeNode(); node4.value=4;
        TreeNode node5 = new TreeNode(); node5.value=5;
        TreeNode node6 = new TreeNode(); node6.value=6;
        TreeNode node7 = new TreeNode(); node7.value=7;
        TreeNode node8 = new TreeNode(); node8.value=8;
        TreeNode node9  = new TreeNode(); node9.value=9;
        TreeNode node10  = new TreeNode(); node10.value=10;
        TreeNode node11  = new TreeNode(); node11.value=11;

        // node1.left=node2; node1.right=node3;        
        // node2.left=node4; node2.right=node7;
        // node3.left=node5; node3.right=node6;
        // node4.left=node10;
        // node6.right=node11;

    //          1
    //     2        3
    //   4   7     5  6
    //  10             11  

        node1.left=node2; node1.right=node3;
        node2.left=node4; node2.right=node5;

    
        //root,left,right
        traversePreOrder(node1);
        System.out.println();

        //left,root,right
        //10,4,2,7,1,5,3,6,11
        traverseInOrder(node1);
        System.out.println();
        
        //left,right,root
        traversePostOrder(node1);
        System.out.println();

        bfs(node1);

    }

    private static void bfs(TreeNode node) {
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(node);

        while(!q.isEmpty())
        {
            TreeNode currNode = q.remove();
            System.err.println(currNode.value);
            if(currNode.left != null){
                q.add(currNode.left);
            }
            if(currNode.right != null){
                q.add(currNode.right);
            }
        }
    }

    //root,left,right
    private static void traversePreOrder(TreeNode node) {
        System.out.print(node.value);
        if(node.left != null)
        {
            traversePreOrder(node.left);
        }
        if(node.right != null)
        {
            traversePreOrder(node.right);
        }
    }

    //left, root, right
    private static void traverseInOrder(TreeNode node) {
        if(node.left != null)
        {
            traverseInOrder(node.left);
        }
        System.out.print(node.value);
        if(node.right != null)
        {
            traverseInOrder(node.right);
        }
    }

    //left,right,root
    private static void traversePostOrder(TreeNode node) {
        if(node.left != null)
        {
            traversePostOrder(node.left);
        }
        if(node.right != null)
        {
            traversePostOrder(node.right);
        }
        System.out.print(node.value);
    }
}
