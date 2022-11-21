import java.util.HashMap;
import java.util.Map;

public class ClimbStair {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }   

    public static int climbStairs(int n) {
        return climbWithMap(n, new HashMap<Integer, Integer>());
    } 
    
    private static int climbWithMap(int n, Map<Integer, Integer> map){
        if(n <= 1){
            return 1;
        }
        int nminus1=0;
        if(map.containsKey(n-1)){
            nminus1=map.get(n-1);
        }
        else{
            nminus1=climbWithMap(n-1, map);
            map.put(n-1, nminus1);
        }

        int nminus2=0;
        if(map.containsKey(n-2)){
            nminus2=map.get(n-2);
        }
        else{
            nminus2=climbWithMap(n-2, map);
            map.put(n-2, nminus2);
        }
        return nminus1+nminus2;
    }
}
