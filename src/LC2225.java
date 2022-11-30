import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LC2225 {
    public static void main(String[] args) {
        findWinners(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}});
        findWinners(new int[][]{{2,3},{1,3},{5,4},{6,4}});

    }
    

    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winnerMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> loserMap = new HashMap<Integer, Integer>();
        for(int i=0; i<matches.length; i++){
                int winner = matches[i][0];
                winnerMap.putIfAbsent(winner, 0);
                winnerMap.put(winner, winnerMap.get(winner)+1);

                int loser = matches[i][1];
                loserMap.putIfAbsent(loser, 0);
                loserMap.put(loser, loserMap.get(loser)+1);
        }

        List<Integer> winnerList = new ArrayList<Integer>();
        for(Integer winner : winnerMap.keySet()){
            if(!loserMap.containsKey(winner)){
                winnerList.add(winner);
            }
        }

        List<Integer> runnerUpList = new ArrayList<Integer>();
        for (Entry<Integer, Integer> entry : loserMap.entrySet()){
            if(entry.getValue() == 1){
                runnerUpList.add(entry.getKey());
            }
        }

        Collections.sort(winnerList);
        Collections.sort(runnerUpList);
        System.out.println(winnerList);
        System.out.println(runnerUpList);
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        retList.add(winnerList);
        retList.add(runnerUpList);
        return retList;
    }
}
