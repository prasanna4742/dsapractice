import java.util.HashMap;
import java.util.Map;

public class LongS {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));   
        System.out.println(lengthOfLongestSubstring(" "));   
        System.out.println(lengthOfLongestSubstring("abcabcbb"));   
        System.out.println(lengthOfLongestSubstring("bbbbb"));   
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("ckilbkd"));   
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));   
    }

        public static int lengthOfLongestSubstring(String s) {
        char[] cArr = s.toCharArray();
        int maxCount = 0;
        int currCount = 0;
        //Set<Character> mySet = new HashSet<Character>();
        Map<Character, Integer> myMap = new HashMap<Character, Integer>();
        for(int i=0; i< cArr.length && i >-1;i++)
        {
            if(myMap.containsKey(cArr[i])){
                
                maxCount = Math.max(maxCount, currCount); 
                currCount = currCount-myMap.get(cArr[i]) ;  
                myMap.clear();            
                myMap.put(cArr[i], i);
            }
            else{
                myMap.put(cArr[i], i);
                currCount++;
            }
        }
        return Math.max(maxCount, currCount);
    }    

    // public static int lengthOfLongestSubstring(String s) {
    //     char[] cArr = s.toCharArray();
    //     int maxCount = 0;
    //     int currCount = 0;
    //     Set<Character> mySet = new HashSet<Character>();
        
    //     for(int i=0; i< cArr.length && i >-1;)
    //     {
    //         if(mySet.contains(cArr[i]))
    //         {
                
    //             maxCount = Math.max(maxCount, currCount);
    //             mySet.clear();
    //             i=i-currCount+1;
    //             currCount=0;
    //         }
    //         else{
    //             mySet.add(cArr[i]);
    //             currCount++;
    //             i++;
    //         }
    //     }
    //     return Math.max(maxCount, currCount);
    // }    
}
