import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    static int counter;
    public static void main(String[] args) {
        Map<String, Boolean> memo = new HashMap<String, Boolean>() ;
        System.out.println(canConstruct("abcdef", new String[]{"abc", "def", "ab", "cd", "ef","abcd", "ef"}, memo));
        System.out.println("counter:"+counter);
        memo.clear();
        System.out.println(canConstruct("stump", new String[]{"abc", "def", "ab", "cd", "ef", "abcdef"}, memo));
        memo.clear();
        System.out.println(canConstruct("stump", new String[]{"abc", "def", "ab", "cd", "ef", "abcdef", "st", "um", "p"}, memo));
        memo.clear();
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
            new String[]{"e",
                            "ee",
                            "eee",
                            "eeee",
                            "eeeee",
                            "eeeeee",
                            "eeeeeee",                                                                                                                                            
                            "eeeeeeee",                                                                                                                                            
                            "eeeeeeeee"}, memo));

    }

    private static boolean canConstruct(String target, String[] candidateArr, Map<String, Boolean> memo) {
        if(memo.containsKey(target)) {
            return memo.get(target);
        }
        if(target == null || target.length() == 0){
            return true;
        }
        for(String candidate : candidateArr)
        {
            //if(target.contains(candidate)){
            if(target.startsWith(candidate) || target.endsWith(candidate)){    
                String remainder = target.replace(candidate, "");
                boolean retVal = canConstruct(remainder, candidateArr, memo);
                memo.put(remainder, retVal);
                if(retVal==true)
                {
                    counter++;
                    return true;
                }
            }
        }        
        return false;
    }
}
