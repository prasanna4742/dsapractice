import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1443 {
    public static void main(String[] args) {
        System.out.println(minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, Arrays.asList(new Boolean[]{false,false,true,false,true,true,false})));
        System.out.println(minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, Arrays.asList(new Boolean[]{false,false,true,false,false,true,false})));
        System.out.println(minTime(4, new int[][]{{0,1},{1,2},{0,3}}, Arrays.asList(new Boolean[]{true,true,true,true})));
        System.out.println(minTime(4, new int[][]{{0,2},{1,2},{0,3}}, Arrays.asList(new Boolean[]{false,true,false,false})));

    }
    

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] graph = new ArrayList[n];         
        for(int i =0; i<n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<edges.length; i++){
            int from = edges[i][0];
            int to =  edges[i][1];
            graph[from].add(to);
            graph[to].add(from);

        }

        Set<Integer> apple = new HashSet<Integer>();
        for(int i=1; i<hasApple.size(); i++){
            if(hasApple.get(i)){
                apple.add(i);
            }
        }

        int cnt = traverseGraph(0,graph, apple, new HashSet<Integer>());
        if(cnt >0){
            return cnt-2;
        }
        else{
            return 0;
        }
    }

    private static int traverseGraph(int start, List<Integer>[] graph, Set<Integer> apple, Set<Integer> path) {
        path.add(start);
        // System.out.println(start);
        List<Integer> myChildren = graph[start];
        if((myChildren == null || myChildren.isEmpty()) && apple.contains(start)){
            return 2;
        }

        int cnt = 0;
        for(int i: graph[start]){
            if(path.contains(i)){
                continue;
            }
            cnt += traverseGraph(i, graph, apple, path);
            path.remove(i);
        }
        
        if(cnt !=0 || apple.contains(start)){
            return cnt+2;
        }
        else{
            return 0;
        }

    }    
}
