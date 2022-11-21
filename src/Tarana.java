import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tarana {
    public static void main(String[] args) {
        // List<String> words = new ArrayList<String>(Arrays.asList(new String[]{"duel","speed","cars","dule"}));
        // List<String> queries = new ArrayList<String>(Arrays.asList(new String[]{"spede","deul"}));
        List<String> words = new ArrayList<String>(Arrays.asList(new String[]{ "allot","cat","act","peach","peahc","dusty"}));
        List<String> queries = new ArrayList<String>(Arrays.asList(new String[]{"tac","study","cheap"}));
        
        System.out.println(getSearchResults(words, queries));    
    }

    public static List<List<String>> getSearchResults(List<String> words, List<String> queries) {
        //Prepare empty output first;
        final List<List<String>> queryResList = new ArrayList<List<String>>();
        
        Map<String, List<String>> wordSignatures = new HashMap<String, List<String>>();
        for(String word : words){
            String sSign = getStringSign(word);
            wordSignatures.putIfAbsent(sSign, new ArrayList<String>());
            wordSignatures.get(sSign).add(word);
        }

        for(String query : queries){
            List<String> result = processSingleQuery(wordSignatures, query);
            //This is really unnecessary but hackerrank expects sorted outut
            Collections.sort(result);
            queryResList.add(result);
        }
        return queryResList;
    }

    private static List<String> processSingleQuery(Map<String, List<String>> wordSignatures, String query) {
        String sSign = getStringSign(query);
        List<String> retList = wordSignatures.get(sSign);
        if(retList == null){
            return new ArrayList<String>();
        }
        else{
            return retList;
        }
    }

    private static String getStringSign(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                sb.append((char) ('a' + i)).append(count[i]);
            }
        }
        return sb.toString();
    }    
}