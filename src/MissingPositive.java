import java.util.Arrays;

public class MissingPositive {
   public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive(new int[]{2,1}));
        System.out.println(firstMissingPositive(new int[]{5, 2,3,0}));
        System.out.println(firstMissingPositive(new int[]{2,1,-5,-8,0,9}));
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
       
   } 

    public static int firstMissingPositive(int[] nums) {
        //1. Check if we find 1
        boolean oneFound = false;
        for(int i =0; i< nums.length; i++){
            if(nums[i] == 1)
            {
                oneFound = true;
                break;
            }
        }
        if(! oneFound){
            return 1;
        }

        //2. Santize for out of range values
        for(int i =0; i< nums.length; i++){
            if(nums[i] <= 0 || nums[i] >nums.length){
                nums[i] = 1;
            }
        }
        // Arrays.stream(nums).forEach(x->System.out.print(","+x));
        // System.out.println();

        //3.Notify indexes
        for(int i =0; i< nums.length; i++){
            int currVal = Math.abs(nums[i]); 
            if(currVal <=nums.length){
                nums[currVal-1] = Math.abs(nums[currVal-1])*-1;
            }
        }
        Arrays.stream(nums).forEach(x->System.out.print(","+x));
        System.out.println();

        //Get missing +ve
        int retVal = 0;
        for(int i =0; i< nums.length; i++){
            if(nums[i] >= 1){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
