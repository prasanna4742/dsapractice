import java.util.Arrays;

public class LC121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        
    }

    public static int maxProfit(int[] prices) {

        Arrays.sort(prices);
        int maxProf = 0;
        int i =0;        
        for(int j=1; j<prices.length; j++){                
            if(prices[j] < prices[i]){
                i = j;            }
            else{
                maxProf = Math.max(maxProf, prices[j]-prices[i]);                        
            }
        }

        return maxProf;
    }    


}
