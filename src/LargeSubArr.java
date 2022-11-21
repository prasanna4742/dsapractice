public class LargeSubArr {

    public static void main(String[] args) {
        // Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        // Output: 6
        // Explanation: [4,-1,2,1] has the largest sum = 6.        
        int max = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println("max:"+max);
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        
        for(int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
            max = Math.max(max, nums[i]); // sum of array 0'th to i'th index
            for(int j = 1; j <= i; j++) {
                int sum = nums[i] - nums[j-1]; // sum of array j'th to i'th index
                max = Math.max(max, sum);
            }
        }        
        return max;
    }
}
