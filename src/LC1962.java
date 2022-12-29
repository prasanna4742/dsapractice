import java.util.Collections;
import java.util.PriorityQueue;

public class LC1962 {
    public static void main(String[] args) {
        minStoneSum(new int[]{5,4,9}, 2);
    }

    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<piles.length; i++){
            pQ.add(piles[i]);
        }

        for(int i=0; i<k; i++){
            int insertHalf =  Math.round((float)pQ.poll()/2);
            pQ.add(insertHalf);                               
        }

        return pQ.stream().mapToInt(Integer::intValue).sum();
    }    
}
