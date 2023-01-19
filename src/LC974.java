import java.util.HashMap;
import java.util.Map;

public class LC974 {
    public static void main(String[] args) {
        
    }

    public int subarraysDivByK(int[] nums, int k) {
     
        int ret=0;
        int runningSum = 0;
        Map<Integer, Integer> prefixMap = new HashMap<Integer, Integer>();
        prefixMap.put(0, 1);
        for(int i=0; i<nums.length; i++){
            runningSum += nums[i];
            int remainder = runningSum % k;

            if(remainder < 0){
                remainder = remainder + k;
            }
            if(prefixMap.containsKey(remainder)){
                ret = ret+ prefixMap.get(remainder);
            }
            prefixMap.put(remainder, prefixMap.getOrDefault(remainder, 0)+1);
        }

        return ret;
    }    
}
