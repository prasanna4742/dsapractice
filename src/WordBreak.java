import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList((new String[]{"leet","code"}))));
        // System.out.println(wordBreak("applepenapple", Arrays.asList((new String[]{"apple","pen"}))));
        // System.out.println(wordBreak("catsandog", Arrays.asList((new String[]{"cats","dog","sand","and","cat"}))));
        // System.out.println(wordBreak("ddadddbdddadd", Arrays.asList((new String[]{"dd","ad","da","b"}))));
        
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
              
        
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        Set<String> dict = new HashSet<String>(wordDict);
              for(int i=1; i <= s.length(); i++){
                for(int j=0; j < i; j++){
                    if(f[j] && dict.contains(s.substring(j, i))){
                        f[i] = true;
                        break;
                    }
                }
            }
            
            return f[s.length()];
    }

    // public static boolean wordBreak(String s, List<String> wordDict) {
    //     List<String> updatedDict = new ArrayList<String>();
    //     for(String dict : wordDict){
    //         if(s.contains(dict)){
    //             updatedDict.add(dict);
    //         }
    //     }

    //     for(String dict : updatedDict){
    //         String trimmedS = s.replaceFirst(dict, "0");
    //         if(wordBreak(trimmedS, updatedDict)){
    //             return true;
    //         }
    //         if(trimmedS.chars().allMatch(Character::isDigit)){
    //             return true;
    //         }    
    //     }

    //     return false;
    // }    
}
