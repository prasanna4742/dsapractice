public class LC100 {
    public static void main(String[] args) {
        
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null){            
            if(q == null){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(q == null){
                return false;
            }
            else{
                if(p.val != q.val){
                    return false;
                }
                else{
                    boolean retVal = isSameTree(p.left, q.left);
                    if(!retVal){
                        return false;
                    }
                    else{
                        return isSameTree(p.right, q.right);
                    }
                }
            }
        }
    }    
}
