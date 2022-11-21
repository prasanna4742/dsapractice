public class Stock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
        System.out.println(maxProfit(new int[] {7,6,8,2,5,1,2,3,4,1,9,8,10,11,8,7}));
        System.out.println(maxProfit(new int[] {1,4,2}));
        
    }
    private static int maxProfit(int[] prices) {

        // int start = 1;
        // int end = prices.length -2;
        // int min = prices[0];
        // int max = prices[prices.length -1];
        // while(end>=start)
        // {
        //     if(prices[start]<min){
        //         min = prices[start];
        //     }
        //     if(prices[end]>max){
        //         max = prices[end];
        //     }
        //     start++;
        //     end--;
        // }
        // System.out.println(min+","+max);
        // int profit = max-min;
        // if(profit>0){
        //     return profit;
        // }
        // else{
        //     return 0;
        // }
        int start = 0;
        int maxProfit = 0;
        int currProfit = 0;
        for(int end=1 ; end < prices.length; end++)
        {
            if(prices[start]<prices[end])
            {
                currProfit =  prices[end] - prices[start];
                if (currProfit>maxProfit)
                {
                    maxProfit = currProfit;
                }
            }
            else
            {
                start = end;
            }
        }
        return maxProfit;
    }
    
}
