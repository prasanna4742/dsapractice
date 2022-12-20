import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC841 {
    public static void main(String[] args) {
        
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Set<Integer> visits = new HashSet<Integer>();  
        visits.add(0);     
        return visitRecursion(visits, rooms, 0);
    }

    private static boolean visitRecursion(Set<Integer> visits, List<List<Integer>> rooms, int key) {

        List<Integer> moreKeys = rooms.get(key);
        for( int k : moreKeys){
            if(!visits.contains(k)){
                visits.add(k);
                if(visits.size() == rooms.size()){
                    return true;
                }
                boolean retVal = visitRecursion(visits, rooms, k);
                if(retVal){
                    return true;
                }
            }

        }
        return false;
    }
}
