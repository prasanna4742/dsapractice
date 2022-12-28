import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC886 {
    public static void main(String[] args) {
        System.out.println(possibleBipartition(4, new int[][]{{1,2},{1,3},{2,4}}));     
        System.out.println(possibleBipartition(3, new int[][]{{1,2},{1,3},{2,3}}));     
        System.out.println(possibleBipartition(10, new int[][]{{1,2},{3,4},{5,6},{6,7},{8,9},{7,8}}));     
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> disMap = new HashMap<Integer, List<Integer>>();
        for (int i=1; i<=n; i++){
            disMap.put(i, new ArrayList<Integer>());
        }

        for(int i=0; i<dislikes.length; i++){
            disMap.get(dislikes[i][0]).add(dislikes[i][1]);
            disMap.get(dislikes[i][1]).add(dislikes[i][0]);            
        }

        int[] colors = new int[n+1];
        for(int i=1; i<=n; i++){
            Queue<Integer> nodeQ = new ArrayDeque<Integer>();

            if(colors[i] == 0){
                colors[i] = 1;
                nodeQ.add(i);
            
            while(!nodeQ.isEmpty()){
                int curr = nodeQ.poll();
                List<Integer> disLikes = disMap.get(curr); 
                for( int d : disLikes){
                    if(colors[d] == 0){
                        colors[d] = (colors[curr] == 1)?2:1;
                        nodeQ.add(d);
                    }
                    else if(colors[d] == colors[curr]) {
                        return false;
                    }
                }

            }
        }

        }
        return true;        
    }

}