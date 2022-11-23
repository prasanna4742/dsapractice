import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC423 {
    public static void main(String[] args) {
        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("fviefuro"));
        System.out.println(originalDigits("nnei"));
        System.out.println(originalDigits("zero"));
        System.out.println(originalDigits("zerozroe"));
    }

    // //Works but times out, memoization is not perfect.
    // public static String originalDigits(String s) {
    //     String[] nameNum = new String[]{"zero", "one","two", "three","four","five","six","seven","eight","nine"};
    //     Map<String, String> map = new HashMap<String, String>();        
    //     for(int i=0; i<nameNum.length;i++){
    //         List<String> retList = new ArrayList<String>();
    //         processSingle(nameNum,i,s,"",retList, map);
    //         if(!retList.isEmpty()){
    //             return retList.get(0);
    //         }
    //     }
    //     return null;
        
    // }

    // private static void processSingle(String[] nameNum, int currIndex, String s, String retString, List<String> retList, Map<String, String> map) {
                
    //     if(s.equals("")){
    //         retList.add(retString);
    //         return;
    //     }

    //     String fromMap = map.get(currIndex+","+s);
    //     if( fromMap != null){
    //         if(fromMap.equals("DISCONTINUE")){
    //             return;
    //         }
    //         else{
    //             retString = retString+currIndex;
    //         }
    //     }
    //     else{
    //         String currNum = nameNum[currIndex];
    //         String newString = s;
    
    //         for(int i=0; i<currNum.length(); i++){
    //                 newString = newString.replaceFirst(String.valueOf(currNum.charAt(i)),"");
    //             }
    
    //         if(newString.length() != s.length()-currNum.length()){
    //             map.put(currIndex+","+s,"DISCONTINUE");
    //             return;
    //         }
    //         else{                
    //             retString = retString+currIndex;
    //             map.put(currIndex+","+s,retString);
    //             if(newString.equals("")){
    //                 retList.add(retString);
    //                 return;
    //             }        
    //         }
    
    //         for(int i=0; i< nameNum.length; i++){
    //             processSingle(nameNum, i, newString,retString, retList, map);
    //             if(!retList.isEmpty()){
    //                 return;
    //             }
    //         }    
    //     }
    // }    

    public static String originalDigits(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == 'z') count[0]++;
            if (c == 'w') count[2]++;
            if (c == 'x') count[6]++;
            if (c == 's') count[7]++; //7-6
            if (c == 'g') count[8]++;
            if (c == 'u') count[4]++; 
            if (c == 'f') count[5]++; //5-4
            if (c == 'h') count[3]++; //3-8
            if (c == 'i') count[9]++; //9-8-5-6
            if (c == 'o') count[1]++; //1-0-2-4
        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++){
            for (int j = 0; j < count[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }

}
