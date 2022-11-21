import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        
        int[] ret = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(ret[0]+","+ret[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> remainMap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++)
        {
            if(remainMap.containsKey(target-nums[i])){                
                return new int[]{i, ((Integer)remainMap.get(target-nums[i])).intValue()};
            }
            else{
                remainMap.put(Integer.valueOf(nums[i]), Integer.valueOf(i));
            }
        }
        return new int[2];
                
    }    
}
