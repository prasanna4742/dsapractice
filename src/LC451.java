import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC451 {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        Map<Integer, List<Character>> valsToChars = new HashMap<Integer, List<Character>>();
        for( Character c : map.keySet()){
            int freq = map.get(c);
            valsToChars.putIfAbsent(freq, new ArrayList<Character>());
            List<Character> cList = valsToChars.get(freq);
            cList.add(c);        
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> valList = new ArrayList<Integer>(valsToChars.keySet());
        Collections.sort(valList, Collections.reverseOrder());
        for(Integer v : valList){
            valsToChars.get(v).stream().forEach(x -> sb.append(String.valueOf(x).repeat(v)));
        }

        return sb.toString();
    }    
}
