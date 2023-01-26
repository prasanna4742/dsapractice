import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LC909 {
    public static void main(String[] args) {
        System.out.println(snakesAndLadders(new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}));        
        System.out.println(snakesAndLadders(new int[][]{{-1,-1},{-1,3}}));
        System.out.println(snakesAndLadders(new int[][]{{-1,-1,-1},{-1,9,8},{-1,8,9}}));
        System.out.println(snakesAndLadders(new int[][]{{-1,1,2,-1},{2,13,15,-1},{-1,10,-1,-1},{-1,6,2,8}}));

    }

    //Works but time limit issue
    // public static int snakesAndLadders(int[][] board) {
     
    //     int n = board.length;
    //     Map<Integer, Integer> boardMap = new HashMap<Integer, Integer>(n*n);

    //     int currentBlockNumber = 0;
    //     boolean desc;
    //     int expectedModResult;
    //     if(n%2 == 0){
    //         desc = true; //Not really needed, expectedModResult can drive the logic, but better for now, for readability
    //         expectedModResult = 1;   
    //         currentBlockNumber = n*n;     
    //     }
    //     else{
    //         desc = false; //Not really needed, expectedModResult can drive the logic, but better for now, for readability
    //         expectedModResult = 0;   
    //         currentBlockNumber = (n*n-n)+1;          
    //     }

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<n; j++){
    //             boardMap.put(currentBlockNumber, board[i][j]);

    //             if(currentBlockNumber%n == expectedModResult){
    //                if(desc){
    //                     desc = false;
    //                     expectedModResult = 0;
    //                } 
    //                else{
    //                     desc = true;
    //                     expectedModResult = 1;
    //                }
    //                currentBlockNumber -= n;
    //                continue;
    //             }
    //             if(desc){
    //                 currentBlockNumber--;
    //             }
    //             else{
    //                 currentBlockNumber++;
    //             }
    //         }
    //     }

    //     Set<Integer> steps = new HashSet<Integer>();
    //     List<Integer> visited = new ArrayList<Integer>();

    //     dfsTraverseBoardMap(1, 0, n, boardMap, steps, visited);

    //     if(steps.isEmpty()){
    //         return -1;
    //     }
    //     // System.out.println("Done");
    //     return steps.stream().mapToInt(Integer::intValue).min().getAsInt();
    // }

    // private static void dfsTraverseBoardMap(int curr, int moves, int n, Map<Integer, Integer> boardMap, Set<Integer> steps, List<Integer> visited) {

    //     if(curr == n*n){
    //         steps.add(moves);
    //         // System.out.println("Path->");
    //         // System.out.println(visited.toString());
    //         return;
    //     }
    //     if(curr > n*n){
    //         return;
    //     }

    //     List<Integer> nextPaths = new ArrayList<Integer>();
    //     int i = curr+1;
    //     int lastMinus1 = 0;
    //     for(; i<curr+7 && i<=n*n; i++){
    //         int val = boardMap.get(i);
    //         if(val != -1){
    //             nextPaths.add(val);
    //         }
    //         else{
    //             lastMinus1 = i;
    //         }
    //     }
    //     if(lastMinus1 != 0){
    //         nextPaths.add(lastMinus1);
    //     }

    //     for(int p : nextPaths){
    //         if(visited.contains(p)){
    //             continue;
    //         }
    //         visited.add(p);    
    //         dfsTraverseBoardMap(p, moves+1, n, boardMap, steps, visited);            
    //         visited.remove(visited.size()-1);
    //     }
    //     // System.out.println("Done1");
    // }

    //BS becasue for shortest path, we use BFS
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        Map<Integer, Integer> boardMap = new HashMap<Integer, Integer>(n*n);

        int currentBlockNumber = 0;
        boolean desc;
        int expectedModResult;
        if(n%2 == 0){
            desc = true; //Not really needed, expectedModResult can drive the logic, but better for now, for readability
            expectedModResult = 1;   
            currentBlockNumber = n*n;     
        }
        else{
            desc = false; //Not really needed, expectedModResult can drive the logic, but better for now, for readability
            expectedModResult = 0;   
            currentBlockNumber = (n*n-n)+1;          
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                boardMap.put(currentBlockNumber, board[i][j]);

                if(currentBlockNumber%n == expectedModResult){
                   if(desc){
                        desc = false;
                        expectedModResult = 0;
                   } 
                   else{
                        desc = true;
                        expectedModResult = 1;
                   }
                   currentBlockNumber -= n;
                   continue;
                }
                if(desc){
                    currentBlockNumber--;
                }
                else{
                    currentBlockNumber++;
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<Integer>();
        Map<Integer,Integer> visited = new HashMap<Integer, Integer>();
        q.offer(1);
        visited.put(1,0);
        
        while(!q.isEmpty()){
            
            int curr = q.poll(); 
            
            for(int i=curr+1; i<=curr+6; i++){
                int next = i;
                int nextPos = boardMap.get(i);
                if(next>n*n){
                    return -1;
                }
                if(nextPos!=-1){
                    next = nextPos;
                }

                if(next==n*n){
                    return visited.get(curr)+1;
                } 
                if(!visited.containsKey(next)){
                    visited.put(next,visited.get(curr)+1 );
                     q.add(next);
                }   
            }
        }

        return -1;

    }

}
