import java.util.ArrayList;
import java.util.List;

public class LC60 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(23, 12));
    }

    // Correct but inefficient
    // public static int uniquePaths(int m, int n) {
    //     List<Integer> path = new ArrayList<Integer>();
    //     path.add(0);
    //     upRecursive(0,0,m-1,n-1,path);
    //     return path.get(0);
    // }

    // private static void upRecursive(int row, int col, int m, int n, List<Integer> path) {

    //     if(row == m && col == n){
    //         path.add(0, path.get(0)+1);
    //         return;
    //     }
    //     if(row > m || col > n){
    //         return;
    //     }
    //     upRecursive(row+1, col, m, n, path);
    //     upRecursive(row, col+1, m, n, path);
    // }    

    //Works fine
    // public static int uniquePaths(int m, int n) {
    //     return uniqPathRecursive(m-1,n-1,new int[m][n]);
    // }

    // private static int uniqPathRecursive(int m, int n, int[][] memo) {
    //     if( m < 0 || n < 0){
    //         return 0;
    //     }
    //     if( m == 0 && n ==0){
    //         return 1;
    //     }
    //     if(memo[m][n] > 0){
    //         return memo[m][n];
    //     }

    //     memo[m][n] = uniqPathRecursive(m-1, n, memo) +  uniqPathRecursive(m, n-1, memo);
    //     return memo[m][n];
    // }

    //Let's try DP now
    public static int uniquePaths(int m, int n) {

        int[][] grid = new int[m][n];
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 || j ==0){
                    grid[i][j] = 1;
                }
                else{
                    grid[i][j] = grid[i-1][j] +grid[i][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }

}
