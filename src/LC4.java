import javax.security.auth.x500.X500Principal;

public class LC4 {
    public static void main(String[] args) {
        
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int mn = m+n;
        int[] mergedArr = new int[mn];
        if(mn == 1){
            if(m == 0){
                return nums2[0];
            }
            else{
                return nums1[0];
            }
        }

        // while()
        
    }

}
