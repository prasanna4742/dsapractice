import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC472 {
    public static void main(String[] args) {
        System.out.println(findAllConcatenatedWordsInADict(new String[]{"cat","dog","catdog"}));
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Set<String> retList = new HashSet<String>();
        Map<String, Boolean> memo = new HashMap<String, Boolean>();

        for(int i=0; i<words.length; i++){
            if(findWordsRec(words[i], wordSet, memo)){
                retList.add(words[i]);
            }
        }

        return new ArrayList<String>(retList);
    }

    private static boolean findWordsRec(String currWord, Set<String> wordSet, Map<String, Boolean> memo) {

        if(memo.containsKey(currWord)){
            return memo.get(currWord);
        }
        for(int i=1; i<currWord.length(); i++){
            String prefix = currWord.substring(0,i);
            if(wordSet.contains(prefix)){
                String suffix = currWord.substring(i);
                if(wordSet.contains(suffix) || findWordsRec(suffix, wordSet, memo)){
                    memo.put(currWord, true);
                    return true;
                }
            }   
        }
        memo.put(currWord, false);
        return false;
    }    
}
