import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> retList = new ArrayList<String>();
        Map<Character, Character[]> digiMap = new HashMap<Character, Character[]>();
        digiMap.put('2', new Character[]{'a','b','c'});
        digiMap.put('3', new Character[]{'d','e','f'});
        digiMap.put('4', new Character[]{'g','h','i'});
        digiMap.put('5', new Character[]{'j','k','l'});
        digiMap.put('6', new Character[]{'m','n','o'});
        digiMap.put('7', new Character[]{'p','q','r','s'});
        digiMap.put('8', new Character[]{'t','u','v'});
        digiMap.put('9', new Character[]{'w','x','y','z'});

        if(digits.length() == 0){
            return retList;
        }
        // if(digits.length() == 1){
        //     List<Character> charList = Arrays.asList(digiMap.get(digits.charAt(0)));
        //     charList.stream().forEach(x -> retList.add(String.valueOf(x)));
        //     return retList;
        // }
        processChar(digiMap, "", 0, digits, retList);            
        
        return retList;
    }

    private static void processChar(Map<Character, Character[]> digiMap, String currString, int i, String digits, List<String> retList) {
        if(i>=digits.length()){
            retList.add(currString);
            return;
        }
        Character[] charArr = digiMap.get(digits.charAt(i));
        for(int j=0; j<charArr.length; j++){
            processChar(digiMap, currString+charArr[j], i+1, digits, retList);
        }
    }
}