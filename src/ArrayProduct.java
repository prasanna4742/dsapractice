import java.util.Arrays;

public class ArrayProduct {
    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,3,4});
        productExceptSelf(new int[]{-1,1,0,-3,3});
    }

    public static int[] productExceptSelf(int[] nums) {

        // Arrays.stream(nums).forEach(System.out::print);
        // System.out.println();

        int[] ans = new int[nums.length];

        int tmpMult=1;
        for(int i=0; i< nums.length; i++){
            ans[i]=tmpMult;
            tmpMult=tmpMult*nums[i];
        }

        // Arrays.stream(ans).forEach(System.out::print);
        // System.out.println();

        tmpMult=1;
        for(int i=nums.length-1; i>=0; i--)
        {
            ans[i]=ans[i]*tmpMult;
            tmpMult=tmpMult*nums[i];
        }
        Arrays.stream(ans).forEach(x->System.out.print(x+","));
        System.out.println();

        return  ans;
    }
}
