public class LC1143 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));
        System.out.println(longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr"));

    }

    public static int longestCommonSubsequence(String text1, String text2) {
        return subSeqRec(text1, text2, 0,0, new int[text1.length()][text2.length()]);
    }

    private static int subSeqRec(String text1, String text2, int i, int j, int[][] memo) {

        if(i == text1.length() || j == text2.length() ){
            return 0;
        }

        if(memo[i][j] > 0){
            return memo[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = 1 + subSeqRec(text1, text2, i+1,j+1, memo);
            return memo[i][j];
        }
        else{
            memo[i][j] = Math.max(subSeqRec(text1, text2, i+1,j, memo), subSeqRec(text1, text2, i,j+1, memo));
            return memo[i][j];
        }   
    }
    
    }
