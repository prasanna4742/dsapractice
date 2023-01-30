import java.util.HashMap;
import java.util.Map;

public class LC1137 {
    public static void main(String[] args) {
        
    }

    public static int tribonacci(int n) {
        if(n == 0){
            return 0;
        }

        if( n == 1 || n == 2){
            return 1;
        }

        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = arr[2] = 1;

        for(int i=3; i<=n; i++ ){
            arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
        }
    
        return arr[n];

        // return tribonacciRec(n, new HashMap<Integer, Integer>());

    }
    //TLE for recursion, needs DP
    public static int tribonacciRec(int n, Map<Integer, Integer> cache) {
     
        if(n == 0){
            return 0;
        }
        if(n <=2){
            return 1;
        }

        if(!cache.containsKey(n)){
            cache.put(n, tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3));             
        }

        return cache.get(n);
    }    
}
