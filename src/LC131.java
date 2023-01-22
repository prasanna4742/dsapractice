import java.util.ArrayList;
import java.util.List;

public class LC131 {
    public static void main(String[] args) {
        // List<List<String>> retVal = partition("a");

        
        // System.out.println(checkPalindrone("abc"));
        // System.out.println(checkPalindrone("a"));
        // System.out.println(checkPalindrone("aa"));
        // System.out.println(checkPalindrone("ab"));
        // System.out.println(checkPalindrone("aba"));

        List<List<String>> retVal = partition("cbbbcc");

        retVal.forEach(System.out::println);

        //abcdefgh
        //a bcdefg
        //ab 

        //abc
        //a bc

    }

    public static List<List<String>> partition(String s) {
        List<List<String>> retVal = new ArrayList<List<String>>();

        partitionRec(s, 1, new ArrayList<String>(), retVal);

        System.out.println("Done");

        return retVal;
    }

    private static boolean checkPalindrone(String s){
        return checkPalinRec(s, 0, s.length()-1);
    }
    
    private static boolean checkPalinRec(String s, int start, int end) {
        if(start >= end ){
            return true;            
        }
        return s.charAt(start) == s.charAt(end) && checkPalinRec(s, start+1, end-1);
    }

    private static void partitionRec(String s, int start, ArrayList<String> partial, List<List<String>> retVal) {

        if(s.length() == 0){
            // boolean allPalins = partial.stream().allMatch(LC131::checkPalindrone);
            // if(allPalins){
                ArrayList<String> tmpPartial = new ArrayList<String>();
                tmpPartial.addAll(partial);
                retVal.add(tmpPartial);     
            // }
        }

        for(int i=start; i<=s.length(); i++){
            String part1 = s.substring(0, i);
            if(!checkPalindrone(part1)){
                continue;
            }
            partial.add(part1);
            partitionRec(s.substring(i), 1, partial, retVal);            
            partial.remove(partial.size()-1);
        }
    }    
}
