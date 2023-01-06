import java.util.Arrays;

public class LC452 {
    public static void main(String[] args) {
        findMinArrowShots(new int[][]{{1,7},{10,16},{2,8},{1,6},{7,12}});
    }

    public static int findMinArrowShots(int[][] points) {
        
        if(points==null || points.length==0 || points[0].length==0){
            return 0;
        }
        //Merge ranges
        Arrays.sort(points, (int[] x, int[] y)->{
            if(x[0] == y[0]){
                return x[1]-y[1];
            }
            else{
                return x[0]-y[0];
            }
        });

        int cnt=1;
        // List<Integer[]> mergedRanges = new ArrayList<Integer[]>();
        for(int i=1; i<points.length; i++){
            if((points[i][0] >= points[i-1][0] && points[i][0] <= points[i-1][1])
                ||points[i][1] >= points[i-1][0] && points[i][1] <= points[i-1][1]){
                    points[i][0] = Math.max(points[i][0], points[i-1][0]); 
                    points[i][1] = Math.min(points[i][1], points[i-1][1]); 
            }
            else{
                cnt++;
            }
        }
        System.out.println(cnt);
        return cnt;
    }
}
