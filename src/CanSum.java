import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {        
       Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
       System.out.println(canSum(7, new int[]{5,3,4,7}, memo));        
       memo.clear();
       System.out.println(canSum(7, new int[]{2,3}, memo));
       memo.clear();
       System.out.println(canSum(7, new int[]{2,3,5}, memo));
       memo.clear();
       System.out.println(canSum(300, new int[]{7,14 }, memo));

    }

    private static boolean canSum(int target, int[] js, Map<Integer, Boolean> memo) {

        if(memo.containsKey(target))
        {
            return memo.get(target);
        }
        if(target == 0)
        {
            return true;
        }
        if (target < 0)
        {
            return false;
        }
        for(int i=0; i<js.length; i++)
        {        
            int remainder = target-js[i];
            boolean retVal = canSum(remainder, js, memo);
            memo.put(remainder, retVal);
            if(retVal == true)
            {
                return true;
            }
        }
        return false;
    }
}
