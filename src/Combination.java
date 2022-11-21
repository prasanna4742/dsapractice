import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        // System.out.println(combine(3,2));
        // System.out.println(combine(4,2));
        // System.out.println(combine(5,2));
        System.out.println(combine(3,3));
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        recGeneration(n,k,1,new ArrayList<Integer>(),retList);
        return retList;

    }

    private static void recGeneration(int n, int k, int start, List<Integer> currList, List<List<Integer>> retList) {
        if(currList.size() == k)
        {
            retList.add(new ArrayList<>(currList));
            return;
        }

        retList.add(new ArrayList<>(currList));
        for(int i=start; i<=n; i++){
            currList.add(i);
            recGeneration(n,k,i+1,currList,retList);
            currList.remove(currList.size()-1);
        }
    }
}
