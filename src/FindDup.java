import java.util.HashMap;
import java.util.Map;

public class FindDup {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }

    public static int findDuplicate(int[] nums) {
        Map<Integer,Boolean> myMap = new HashMap<Integer,Boolean>();
        for(int num : nums){
            if(myMap.containsKey(num)){
                return num;
            }
            myMap.put(num,true);
        }
        return 0;
    }

}
