public class LC944 {
    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"cba","daf","ghi"}));
        System.out.println(minDeletionSize(new String[]{"a","b"}));
        System.out.println(minDeletionSize(new String[]{"zyx","wvu","tsr"}));
    }    

    public static int minDeletionSize(String[] strs) {
        int ret = 0;
        int rowlen = strs.length;
        int collen = strs[0].length();

        char[][] grid = new char[rowlen][collen];
        for(int i =0; i<strs.length; i++){
            String s = strs[i];
            for(int j =0; j<s.length(); j++){
                grid[i][j] = s.charAt(j);
            }
        }
        //Actually we do not need grid and whole thing can be done in below loop.
        for(int col=0; col<collen; col++){
            for(int row=1; row<rowlen; row++){
                if(grid[row][col] < grid[row-1][col]){
                    ret++;
                    break;
                }
            }
        }
        return ret;        
    }
}
