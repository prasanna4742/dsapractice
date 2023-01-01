import java.util.HashMap;
import java.util.Map;

public class LC290 {
    public static void main(String[] args) {
        // System.out.println(wordPattern("abba", "dog cat cat dog"));
        // System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        // System.out.println(wordPattern("abba", "dog dog dog dog"));
        // System.out.println(wordPattern("aaa", "aa aa aa aa"));
        System.out.println(wordPattern("jquery", "jquery"));



    }
    

    public static boolean wordPattern(String pattern, String s) {
     
        Map<Character, String> map = new HashMap<Character, String>();
        String[] tokens = s.split(" ");
        int ind = 0;
        for(char patChar : pattern.toCharArray()){
            if(ind > tokens.length-1){
                return false;
            }
            if(!map.containsKey(patChar)){
                if(map.values().contains(tokens[ind])){
                    return false;
                }
                map.put(patChar, tokens[ind++]);
                continue;
            }
            if(!map.get(patChar).equals(tokens[ind++])){
                return false;
            }
        }

        if(ind != tokens.length){
            return false;
        }

        return true;
    }    
}
