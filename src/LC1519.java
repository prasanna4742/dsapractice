import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1519 {
    public static void main(String[] args) {
        // countSubTrees(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, "abaedcd");
        // countSubTrees(4, new int[][]{{0,1},{1,2},{0,3}}, "bbbb");
        countSubTrees(4, new int[][]{{0,2},{0,3},{1,2}}, "aeed");

    }

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        int[] retArray = new int[n];
        traverseWithLabels(0, graph, labels, new HashSet<Integer>(), retArray);
        return retArray;
    }

    ///Works but timelimit exceeded
    private static void traverseWithLabels(int currNode, List<Integer>[] graph, String labels, Set<Integer> path, int[] retArray) {

        System.out.println(currNode);
        retArray[currNode]++;
        for(int parent : path){
            if(labels.charAt(parent) == labels.charAt(currNode)){
                retArray[parent]++;
            }
        }
        path.add(currNode);

        for(int i : graph[currNode]){
            if(path.contains(i)){
                continue;
            }
            traverseWithLabels(i, graph, labels, path, retArray);
        }
        path.remove(currNode);
    }
}
