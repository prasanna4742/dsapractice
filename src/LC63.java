public class LC63 {

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0},{0,0},{0,0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0},{0,1}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{1,0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        
    }

    // Works, so let's memoize this
    // public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
    //     int m = obstacleGrid.length;
    //     int n = obstacleGrid[0].length;

    //     return uniquePathsWithObstaclesRecursion(obstacleGrid,m-1, n-1);
    // }

    // private static int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid, int m, int n) {

    //     if( m < 0 || n < 0 || obstacleGrid[m][n] == 1){
    //         return 0;
    //     }
    //     if (m == 0 && n ==0){
    //         return 1;
    //     }

    //     return uniquePathsWithObstaclesRecursion(obstacleGrid, m-1, n) + uniquePathsWithObstaclesRecursion(obstacleGrid, m, n-1);
    // }

    // Memoization works without timeout
    // public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
    //     int m = obstacleGrid.length;
    //     int n = obstacleGrid[0].length;
    //     int[][] memo = new int[m][n];

    //     return uniquePathsWithObstaclesRecursion(obstacleGrid,m-1, n-1, memo);
    // }

    // private static int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid, int m, int n, int[][] memo) {

    //     if( m < 0 || n < 0 || obstacleGrid[m][n] == 1){
    //         return 0;
    //     }
    //     if (m == 0 && n ==0){
    //         return 1;
    //     }
    //     if(memo[m][n] > 0){
    //         return memo[m][n];
    //     }

    //     memo[m][n] = uniquePathsWithObstaclesRecursion(obstacleGrid, m-1, n, memo) + uniquePathsWithObstaclesRecursion(obstacleGrid, m, n-1, memo);
    //     return memo[m][n];
    // }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1] == 1){
            return 0;
        }

        int[][] dp = new int[m][n];

        dp[0][0] = (obstacleGrid[0][0] == 0)?1:0;
        for(int i=1; i<m; i++){
            dp[i][0] = (obstacleGrid[i-1][0] == 0 && dp[i-1][0] == 1)?1:0;
        }

        for(int j=1; j<n; j++){
            dp[0][j] = (obstacleGrid[0][j-1] == 0 && dp[0][j-1] == 1)?1:0;
        }

        for(int i=1; i<m; i++){
            for(int j =1; j<n; j++){
                int fromTop = obstacleGrid[i-1][j] == 0?dp[i-1][j]:0;
                int fromLeft = obstacleGrid[i][j-1] == 0?dp[i][j-1]:0;
                dp[i][j] = fromTop + fromLeft;
            }
        }
        return dp[m-1][n-1];
   }
}
