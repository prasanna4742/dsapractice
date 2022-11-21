import java.util.HashMap;
import java.util.Map;

public class Ransom {
    public static void main(String[] args) {
        
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        
        char[] ransomArr = ransomNote.toCharArray();
        char[] magArr = magazine.toCharArray();
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();

        for( char c : magArr)
        {
            if(charCount.containsKey(c)){
                charCount.put(c, charCount.get(c)+1);
            }
            else{
                charCount.put(c,1);
            }
        }
        for( char c : ransomArr){
             
            if(charCount.get(c)== null)
            {
                return false;
            }
            else{ 
                int count = charCount.get(c);
                if(count == 0)
                {
                    return false;
                }
                else
                {
                    charCount.put(c, charCount.get(c)-1);
                }
            }
        }
        return true;
    }
}
