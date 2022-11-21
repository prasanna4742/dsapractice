import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGrouping {
    public static void main(String[] args) {
        // String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        String[] strs = new String[]{"a"};

        List<List<String>> retList = groupAnagrams(strs);
        retList.stream().forEach(System.out::println);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new  HashMap<String, List<String>>();
        for(String str : strs){
            char[] sortArr = str.toCharArray();
            Arrays.sort(sortArr);
            String sorted = new String(sortArr);

            List<String> curList = group.get(sorted);
            if( curList != null){
                curList.add(str);
            }
            else{
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                group.put(sorted, newList);
            }
        }

        List<List<String>> retList = new ArrayList<List<String>>();
        group.values().forEach(retList::add);
        return  retList;       
    }    
}
