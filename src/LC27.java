import java.util.ArrayList;
import java.util.List;

public class LC27 {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
    }
    public static int removeElement(int[] nums, int val) {
        int cnt=0;
        List<Integer> locList = new ArrayList<Integer>();
        List<Integer> nonLocList = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] == val){
                nums[i]=-1;
                cnt++;
                locList.add(i);
            }else{
                nonLocList.add(nums[i]);
            }
        }

        for(int i=0; i< nums.length-cnt; i++){
            nums[i]=nonLocList.get(i);
        }

        // for(int i : nums){
        //     System.out.print(i+",");
        // }
        // System.out.println("----------");
        return nums.length-cnt;
    }    
}
