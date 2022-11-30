import java.util.Arrays;

public class LC198 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{0}));
        System.out.println(rob(new int[]{1,1,1}));
    }
    
    static int[] memo;
    public static int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return robRecursion(nums, nums.length - 1);
    }
    private static int robRecursion(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if(memo[i]>=0){
            return memo[i];
        }
        
        int prof = Math.max(robRecursion(nums, i - 2) + nums[i], robRecursion(nums, i - 1));    
        memo[i] = prof;
        return prof;
    }
}
