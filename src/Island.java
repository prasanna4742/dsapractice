public class Island {
   public static void main(String[] args) {
   
    // int[][] grid = new int[][] {
    //    {1,1,1,1,0},
    //    {1,1,0,1,0},
    //    {1,1,0,0,0},
    //    {0,0,0,0,0}
    // };
    int[][] grid = new int[][]{
        {1,1,0,0,0},
        {1,1,0,0,0},
        {0,0,1,0,0},
        {0,0,0,1,1}
    };
    System.out.println(numIslands(grid));   
}

private static int numIslands(int[][] grid) {
    return numIslandsRec(0,0,grid);
}

public static int numIslandsRec(int x, int y, int[][] grid) {

    int islandCnt=0;
    for(int i=x; i< grid.length; i++){
        for(int j=y; j<grid[i].length; j++){
            if(grid[i][j]==1){
                islandCnt++;
                grid[i][j]=0;
                numIslandsRec(i+1,j,grid);
                numIslandsRec(i,j+1,grid);
            }
        }
    }
    return islandCnt;
   }        
}
