public class LCABinTree {
    public static void main(String[] args) {
        Integer[] root = new Integer[] {3,5,1,6,2,0,8,null,null,7,4};

        TreeNode rootN = new TreeNode();
        rootN.value = root[0];

        buildTree(rootN, root, 0);

        //inOrder(rootN);
        System.out.println(lowestCommonAncestor(rootN, 4, 7).value);
    }

    public static TreeNode inOrder(TreeNode root, int p)
    {
        if(root != null){
            if(root.value == p){
                return root;
            }
            else{
                if(root.left != null){
                    TreeNode leftR = inOrder(root.left, p);
                    if(leftR != null && leftR.value == p){
                        return leftR;
                    }    
                }

                if(root.right != null){
                    TreeNode rightR = inOrder(root.right, p);
                    if(rightR != null && rightR.value == p){
                        return rightR;
                    }    
                }
            }    
        }
        return null;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null){
            return null;
        }
        if(root.value == p || root.value == q){
            return root;
        }

        TreeNode left =  lowestCommonAncestor(root.left, p,q);
        TreeNode right =  lowestCommonAncestor(root.right, p,q);

        if(left == null && right == null){
            return null;
        }
        if(left != null && right != null){
            return root;
        }
        if(left == null){
            return right;
        }
        return left;
    }

    private static void buildTree(TreeNode node, Integer[] arr, int index) {

        //Handle Left
        if(index*2+1<arr.length && arr[index*2+1] != null){
            TreeNode left = new TreeNode();
            left.value = arr[index*2+1];
            node.left = left;
            buildTree(left, arr, index*2+1);
        }

        //Handle right
        if(index*2+2<arr.length && arr[index*2+2] != null){
            TreeNode right = new TreeNode();
            right.value = arr[index*2+2];
            node.right = right;
            buildTree(right, arr, index*2+2);
        }
    }
        // Function to print tree nodes in InOrder fashion
    public static void inOrder(TreeNode root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }
}
