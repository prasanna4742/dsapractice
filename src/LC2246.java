import java.util.ArrayList;
import java.util.List;

public class LC2246 {
    public static void main(String[] args) {
        System.out.println(longestPath(new int[]{-1,0,0,1,1,2}, "abacbe"));
        System.out.println(longestPath(new int[]{-1,0,0,0}, "aabc"));

    }
    

    public static int longestPath(int[] parent, String s) {

        if(parent.length == 1){
            return 1;
        }
        if(parent.length ==2){
            return (s.charAt(0)==s.charAt(1)?1:2);
        }

        List<Integer>[] tree = new ArrayList[parent.length];

        for(int i=0; i<tree.length; i++){
            tree[i] = new ArrayList<Integer>();
        }

        for(int i=1; i<parent.length; i++){
            tree[parent[i]].add(i);
            tree[i].add(parent[i]);
        }
        System.out.println("done");
        int ret = 0;
        int[] memo = new int[tree.length];
        // char[] labels = new char[s.length()+1];
        // for(char c : labels){

        // }

        for(int i=0; i<tree.length; i++){
            // int cur = traverseWhileTrackingLength(i, new Stack<Integer>(), tree, s.toCharArray(), 0);
            int cur = toLeafAndThenBack(-1, i, tree, s.toCharArray(), memo);
            ret = (cur>ret)?cur:ret;
        }
        return ret;
        
    }


    private static int toLeafAndThenBack(int prev, int curr, List<Integer>[] tree, char[] labels, int[] memo) {

        if(memo[curr] > 0){
            return memo[curr];
        }

        if(prev != -1 && labels[prev] == labels[curr]){
            return 0;
        }

        int max=0;
        for(int i : tree[curr]){
            if(i == prev){
                continue;
            }
            int loopCnt = toLeafAndThenBack(curr, i, tree, labels, memo);
            max = (loopCnt>max)?loopCnt:max;
        }

        memo[curr] = max+1;
        return memo[curr];
    }

    // //Works but timelimit exceedeed
    // private static int traverseWhileTrackingLength(int curr, Stack<Integer> path, List<Integer>[] tree, char[] labels, int maxValue) {
    //     if(!path.empty() && labels[path.peek()] == labels[curr]){
    //         return Math.max(path.size(), maxValue);
    //     }

    //     path.push(curr);
    //     for(int i : tree[curr]){
    //         if(path.contains(i)){
    //             continue;
    //         }
    //         maxValue = traverseWhileTrackingLength(i, path, tree, labels, maxValue);
    //     }
    //     int retVal = Math.max(path.size(), maxValue);
    //     path.pop();       
    //     return retVal;
    // }
}
