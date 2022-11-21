import java.util.HashMap;
import java.util.Map;

public class LC263 {
    public static void main(String[] args) {
        
    }
    public static boolean isUgly(int n) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        return isUgly(n, map);
    }

    public static boolean isUgly(int n, Map<Integer, Boolean> map) {
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        if(n%2==0){
            if(map.containsKey(n/2)){
                return map.get(n/2);
            }
            else{
                boolean res = isUgly(n/2);
                map.put(n/2, res);
                return res;
            }
        }
        if(n%3==0){
            if(map.containsKey(n/3)){
                return map.get(n/3);
            }
            else{
                boolean res = isUgly(n/3);
                map.put(n/3, res);
                return res;
            }
        }
        if(n%5==0){
            if(map.containsKey(n/5)){
                return map.get(n/5);
            }
            else{
                boolean res = isUgly(n/5);
                map.put(n/5, res);
                return res;
            }
        }
        return false;
    }    
}
