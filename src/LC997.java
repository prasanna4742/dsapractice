import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC997 {
    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{{1,2}}));
        System.out.println(findJudge(3, new int[][]{{1,3}, {2,3}}));
        System.out.println(findJudge(3, new int[][]{{1,3}, {2,3},{3,1}}));

    }

    public static int findJudge(int n, int[][] trust) {     
            if(n == 1){
                if(trust == null || trust.length == 0){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        Map<Integer, Set<Integer>> whoTrustsMe = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Set<Integer>> whomDoITrust = new HashMap<Integer, Set<Integer>>();
        for(int[] trustEntry : trust){
            int truster = trustEntry[0];
            int trusted = trustEntry[1];

            Set<Integer> trusters = whoTrustsMe.getOrDefault(trusted, new HashSet<Integer>());
            trusters.add(truster);
            whoTrustsMe.put(trusted, trusters);

            Set<Integer> trusteds = whomDoITrust.getOrDefault(truster, new HashSet<Integer>());
            trusteds.add(trusted);
            whomDoITrust.put(truster, trusteds);
        }

        if(whomDoITrust.keySet().size() != n-1){
            //Not all entries given
            return -1;
        }

        Set<Integer> candidates = new HashSet<Integer>();
        for(int curr : whoTrustsMe.keySet()){
            if(whoTrustsMe.get(curr).size() == n-1){
                candidates.add(curr);
            }
        }

        for( int candidate : candidates){
            if(!whomDoITrust.containsKey(candidate)){
                return candidate;
            }
        }

        return -1;

    }    
}
