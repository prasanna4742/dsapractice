public class LC26 {
    public static void main(String[] args) {
        // System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        int lastValidPosition = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[lastValidPosition] != nums[i])
                nums[++lastValidPosition] = nums[i];
        }
        return lastValidPosition+1;
    }    
}
