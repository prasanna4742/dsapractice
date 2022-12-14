import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC229 {
    public static void main(String[] args) {
        // System.out.println(majorityElement(new int[]{3,2,3}));
        // System.out.println(majorityElement(new int[]{1}));
        // System.out.println(majorityElement(new int[]{1,2}));
        System.out.println(majorityElement(new int[]{0,0,0}));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> retList = new ArrayList<Integer>();
        if (n == 1){
            retList.add(nums[0]);
            return retList;
        }
        if (n == 2){
            if( nums[0] != nums[1]){
                retList.add(nums[0]);
                retList.add(nums[1]);
            }
            else{
                retList.add(nums[0]);
            }
            return retList;
        }

        //Now real logic
        int nBy3 = n/3;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            int currCnt = map.getOrDefault(nums[i], 0);
            if(currCnt == nBy3){
                retList.add(nums[i]);
                map.put(nums[i], currCnt+1);
            }
            else{
                map.put(nums[i], currCnt+1);
            }            
        }
        return retList;
    }    
}
