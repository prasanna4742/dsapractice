import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC1207 {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(uniqueOccurrences(new int[]{1,2}));
        System.out.println(uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i< arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        Collection<Integer> coll = map.values();
        Set<Integer> set = new HashSet<>(coll);
        
        return (coll.size()==set.size())?true:false;
    }
}
