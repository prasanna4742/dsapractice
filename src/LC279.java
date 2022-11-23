public class LC279 {
    public static void main(String[] args) {
    //Need to learn DP more to solve this.        
        System.out.println(numSquares(4));
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }
    public static int numSquares(int n) {
        int [] dp = new int[n+1];
        
        for(int i=0;i<=n;i++)dp[i] = Integer.MAX_VALUE;
        
        dp[0]=0;
        int ind=1;
        
        while(ind*ind <= n){
            int square = ind*ind;
            
            for(int i=square;i<=n;i++){
                dp[i] = Math.min(dp[i-square]+1,dp[i]);
            }
            ind++;
        }
        
        return dp[n];
    }
}
