import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC1971 {
    public static void main(String[] args) {
        System.out.println(validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        if(source == destination){
            return true;
        }

        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>() ;
        
        for(int i=0; i<edges.length; i++){
            Set<Integer> set = map.getOrDefault(edges[i][0], new HashSet<Integer>());
            set.add(edges[i][1]);
            map.put(edges[i][0], set);

            set = map.getOrDefault(edges[i][1], new HashSet<Integer>());
            set.add(edges[i][0]);
            map.put(edges[i][1], set);

        }

        return traverseGraph(map, source, destination);
    }

    private static boolean traverseGraph(Map<Integer, Set<Integer>> map, int source, int destination) {

        Set<String> visited = new HashSet<String>();
        Deque<Integer> q = new ArrayDeque<Integer>();   
        if(map.get(source) != null){     

            Set<Integer> set = map.get(source);
            set.forEach(x -> {
                visited.add(source+","+x);
                q.add(x);
            });
        }
        

        while(!q.isEmpty()){
            Integer head = q.poll();        
            if(head == destination){
                return true;
            }

            if(map.get(head) != null){     
                Set<Integer> set = map.get(head);
                set.forEach(x -> {
                    if(!visited.contains(head+","+x)){
                        visited.add(head+","+x);
                        q.add(x);    
                    }
                });
            }
    
        }
        return false;
    }    
}
