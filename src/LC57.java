import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC57 {
    public static void main(String[] args) {
        // insert(new int[][]{{3,4},{6,9}}, new int[]{1,2});
        // insert(new int[][]{{1,3},{6,9}}, new int[]{10,11});
        // insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
        // insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        // insert(new int[][]{{1,5}}, new int[]{2,3});
        insert(new int[][]{{2,4},{5,7},{8,10},{11,13}}, new int[]{3,6});
    }   

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        
        if(intervals == null || intervals.length == 0){
            int[][] newIntervals = new int[1][];
            newIntervals[0] = newInterval;        
            return newIntervals;
        }

        int currLength = intervals.length;
        int insStart = newInterval[0];
        int insEnd = newInterval[1];

        //New insertion is before first
        if(insEnd < intervals[0][0]){

            int[][] newIntervals = new int[currLength+1][];
            newIntervals[0] = new int[2];
            newIntervals[0][0] = insStart;
            newIntervals[0][1] = insEnd;
            for(int i =1; i<=currLength; i++){
                newIntervals[i] = intervals[i-1];
            }
            return newIntervals;
        }

        //New insertion is after last
        if(insStart > intervals[currLength-1][1]){

            int[][] newIntervals = Arrays.copyOf(intervals, currLength+1);
            newIntervals[currLength] = new int[2];
            newIntervals[currLength][0] = insStart;
            newIntervals[currLength][1] = insEnd;
            return newIntervals;
        }

        List<Integer[]> resultList = new ArrayList<Integer[]>();

        //Now the real logic
        boolean insPending = true;
        for(int i=0;i < intervals.length; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            
            if(currEnd < insStart){
                resultList.add(new Integer[]{currStart, currEnd});
            }
            else if(currStart > insEnd){
                if(insPending){
                    insPending = false;                    
                    resultList.add(new Integer[]{insStart, insEnd});
                }
                resultList.add(new Integer[]{currStart, currEnd});
            }
            else{
                insStart = Math.min(currStart, insStart);
                insEnd = Math.max(currEnd, insEnd);
            }
        }

        if(insPending){
            resultList.add(new Integer[]{insStart, insEnd});
        }

        int[][] retArray = new int[resultList.size()][];
        
        for(int i=0; i<retArray.length; i++){
            retArray[i] = new int[2];
            retArray[i][0] = resultList.get(i)[0];
            retArray[i][1] = resultList.get(i)[1];
        }

        return retArray;
    }
}
