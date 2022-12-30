import java.util.ArrayList;
import java.util.List;

public class LC797 {
    public static void main(String[] args) {
        // allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}});
        // allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}});
        // allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}});

        allPathsSourceTarget(new int[][]{{2},{},{1}});



        
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
     
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        traversePaths(0, graph, new ArrayList<Integer>(), paths);
        paths.forEach(System.out::println);
        return paths;
    }

    private static void traversePaths(int node, int[][] graph, List<Integer>currPath, List<List<Integer>> paths) {

        currPath.add(node);

        if(node == graph.length-1){
            List<Integer> tmpList = new ArrayList<Integer>();
            tmpList.addAll(currPath);
            paths.add(tmpList);    
            return;
        }

        int[] nodePaths = graph[node];

        if(nodePaths == null || nodePaths.length == 0){
            if(currPath.get(currPath.size()-1) == graph.length-1){
                List<Integer> tmpList = new ArrayList<Integer>();
                tmpList.addAll(currPath);
                paths.add(tmpList);    
            }
            return;
        }
        else{

        }

        for(int i=0; i<nodePaths.length; i++){
            traversePaths(nodePaths[i], graph, currPath, paths);
            currPath.remove(currPath.size()-1);
        }
    }
}
