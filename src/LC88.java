public class LC88 {
    public static void main(String[] args) {


        // merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        // merge(new int[]{-1,0,0,3,3,3,0,0,0}, 6,new int[]{1,2,2},3);
        // merge(new int[]{-12,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 1,new int[]{-49,-45,-42,-41,-40,-39,-39,-39,-38,-36,-34,-34,-33,-33,-32,-31,-29,-28,-26,-26,-24,-21,-20,-20,-18,-16,-16,-14,-11,-7,-6,-5,-4,-4,-3,-3,-2,-2,-1,0,0,0,2,2,6,7,7,8,10,10,13,13,15,15,16,17,17,19,19,20,20,20,21,21,22,22,24,24,25,26,27,29,30,30,30,35,36,36,36,37,39,40,41,42,45,46,46,46,47,48},90);
        merge(new int[]{-1,0,1,1,0,0,0,0,0}, 4,new int[]{-1,0,2,2,3},5);
        
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Space complexity O(1)
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while (i>=0 && j>=0){
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--] ;
            /*
            if (nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
            */
        }
        while (j>=0) nums1[k--] = nums2[j--];        
    }

    // public static void merge(int[] nums1, int m, int[] nums2, int n) {
    //     if(n == 0){
    //         return;
    //     }
    //     if(m == 0){
    //         for(int i=0; i<nums2.length; i++){
    //             nums1[i]=nums2[i];
    //         }
    //         return;
    //     }

    //     int ptr1 = 0;
    //     int ptr2 = 0;
    //     int zptr = m;
    //     int maxNums1 = nums1[m-1];
    //     while(ptr1 < m+n && ptr2 < n){
    //         // if(nums2[ptr2] == 2 || nums2[ptr2] == 0){
    //         //     System.out.println("rest");
    //         // }
    //         if(ptr1 !=0 && nums1[ptr1] < nums1[ptr1-1]){
    //             for(int i=ptr1; i<m+n; i++){
    //                 nums1[i] = nums2[ptr2];
    //                 ptr2++;
    //             }
    //             break;
    //         }
    //         if(nums1[ptr1]<nums2[ptr2]){
    //             if(nums2[ptr2] > maxNums1 && nums1[ptr1] == 0){
    //                 nums1[ptr1]= nums2[ptr2];
    //                 ptr2++;
    //             }
    //             ptr1++;
    //         }
    //         else{
    //             //shift nums1
    //             for(int i=zptr; i>ptr1; i--){
    //                 nums1[i] = nums1[i-1];
    //             }
    //             nums1[ptr1]=nums2[ptr2];
    //             ptr2++;
    //             ptr1++;
    //             zptr++;
    //         }
    //     }
    //     for(int i : nums1){
    //         System.out.print(i);
    //     }
    //     System.out.println();

    // }
}
