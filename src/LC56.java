import java.util.HashSet;
import java.util.Set;

public class LC56 {
    public static void main(String[] args) {
        // merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        merge(new int[][]{{1,4},{0,2},{3,5}});        
    }

    public static int[][] merge(int[][] intervals) {

        Set<Integer> mergedIndices = new HashSet<Integer>();

        for(int i=0; i< intervals.length-1; i++){

            int[] currInterval = intervals[i];
            // boolean continueOuter = true;
            // for(Integer[] merged : mergedInterval){
            //     if( currInterval[1]<merged[0] || currInterval[0]>merged[1]){
            //         continue;
            //     }
            //     else{
            //         merged[0] = Math.min(currInterval[0],merged[0]);
            //         merged[1] = Math.max(currInterval[1],merged[1]);
            //         continueOuter = false; 
            //     }
            // }
            // if(!continueOuter){
            //     break;
            // }
            
            for(int j=i+1; j<intervals.length; j++){
                int[] nextInterval = intervals[j]; 
                if( currInterval[1]<nextInterval[0] || currInterval[0]>nextInterval[1]){
                    continue;
                }
                else{
                    nextInterval[0] = Math.min(currInterval[0],nextInterval[0]);
                    nextInterval[1] = Math.max(currInterval[1],nextInterval[1]);                    
                    mergedIndices.add(i);
                }
            }
        }

        int[][] retArray = new int[intervals.length-mergedIndices.size()][2];
        int j=0;
        for(int i=0; i<intervals.length;i++){            
            if(!mergedIndices.contains(i)){
                retArray[j]=intervals[i];
                j++;
            }
        }

        return retArray;
    }    
}
