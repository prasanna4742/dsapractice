import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        premuteRec(nums, new ArrayList<Integer>(), retList, new HashSet<Integer>());
        System.out.println("Done");
        return retList;
    }

    private static void premuteRec(int[] nums, List<Integer> partial, List<List<Integer>> retList, Set<Integer> used) {

        if(partial.size() == nums.length){
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(partial);
            retList.add(tmp);
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used.contains(nums[i])){
                continue;
            }
            used.add(nums[i]);
            partial.add(nums[i]);
            premuteRec(nums, partial, retList, used);
            partial.remove(partial.size()-1);
            used.remove(nums[i]);
        }
    }    
}
