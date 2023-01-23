import java.util.HashMap;
import java.util.Map;

public class LC205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
     
        Map<Character, Character> map = new HashMap<Character, Character>();

        for(int i=0; i<s.length(); i++){

            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(map.containsKey(sChar)){
                Character mapped = map.get(sChar);
                if(mapped != tChar){
                    return false;
                }
            }
            else{
                if(map.containsValue(tChar)){
                    return false;
                }
                map.put(sChar, tChar);
            }
            
        }
        return true;
    }    
}
