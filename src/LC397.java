import java.util.HashMap;
import java.util.Map;

public class LC397 {
    public static void main(String[] args) {
        System.out.println(integerReplacement(8));       
        System.out.println(integerReplacement(7));       
        System.out.println(integerReplacement(4));       
        System.out.println(integerReplacement(4));       
        System.out.println(integerReplacement(2147483647));       
        
    }

    public static int integerReplacement(int n) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        if(n == 2147483647){
            return integerReplacement(n-1, map);
        }
        return integerReplacement(n, map);
    }

    public static int integerReplacement(int n, Map<Integer, Integer> map) {
        if( n <= 1){
            return 0;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n%2 == 0){

            if(map.containsKey(n/2)){
                map.put(n, map.get(n/2)+1);
                return map.get(n);
            }
            else{
                int res = integerReplacement(n/2);
                map.put(n/2, res);
                map.put(n, res+1);
                return res +1;    
            }
        }
        else{

            int resminus1 = 0;
            if(map.containsKey(n-1)){
                resminus1 = map.get(n-1);                
            }
            else{
                resminus1 = integerReplacement(n-1);
                map.put(n-1, resminus1);
            }

            int resplus1 = 0;
            if(map.containsKey(n+1)){
                resplus1 = map.get(n+1);                
            }
            else{
                resplus1 = integerReplacement(n+1);
                map.put(n+1, resplus1);
            }
            int res = Math.min(resminus1, resplus1);
            map.put(n, 1+res);
            return 1 + res;
        }
    }    
}
