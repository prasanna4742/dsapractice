import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LC2244 {
    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{2,3,3}));
        System.out.println(minimumRounds(new int[]{2,2,3,3}));
    }

    public static int minimumRounds(int[] tasks) {
        int round=0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int t : tasks){
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        // Optional<Integer> possible = map.values().stream()
        //     .filter(x -> x<2)
        //     .findAny(); 
            
        // if(possible.isPresent()){
        //     return -1;
        // }


        for(int val : map.values()){
            if(val < 2){
                return -1;
            }
            round = round + val/3;
            if(val%3 != 0){
                round ++;
            }
        }
        return round;
    }    

}
