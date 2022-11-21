import java.util.HashSet;
import java.util.Set;

public class DCombination {
    public static void main(String[] args) {
        // System.out.println(combine(new int[]{1,6,8,9,11,44,67},3));
        // System.out.println(combine(new int[]{1,6,8,9},3));
        // System.out.println(combine(new int[]{1,6,8,9},2));
        // System.out.println(combine(new int[]{1,2,3,4,5,6,7,8},4));
        System.out.println(combine(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20},20));
        // System.out.println(combine(new int[]{1,6,8,9},4));
    }

    public static Set<Set<Integer>> combine(int[] n, int k) {
        Set<Set<Integer>> retSet = new HashSet<Set<Integer>>();
        recGeneration(n,k,0,new HashSet<Integer>(),retSet);
        return retSet;
    }

    private static void recGeneration(int[] n, int k, int start, Set<Integer> currSet, Set<Set<Integer>> retSet) {
        if(currSet.size() == k)
        {
            // if(!retSet.contains(currSet)) {
                retSet.add(new HashSet<>(currSet));
            // }
            return;
        }

        for(int i=start; i<n.length; i++){
            currSet.add(n[i]);
            recGeneration(n,k,start+1,currSet,retSet);
            currSet.remove(currSet.size()-1);
            start++;
        }
    }
}