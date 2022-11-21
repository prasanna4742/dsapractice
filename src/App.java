import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(missingNumber(new int[]{0,1}));
        System.out.println(missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i=0; i< n; i++)
        {
            if(i!=nums[i])
            {
                return i;
            }
        }
        return n;
    }
}

//[0,1] = 0,1,   2
//[0,1,2] = 
//[0,1,3] = 2