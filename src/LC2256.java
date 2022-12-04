public class LC2256 {
    public static void main(String[] args) {
        System.out.println(minimumAverageDifference(new int[]{2,5,3,9,5,3}));
        System.out.println(minimumAverageDifference(new int[]{0}));
        System.out.println(minimumAverageDifference(new int[]{0,0,0,0}));
    }

    public static int minimumAverageDifference(int[] nums) {
        int n= nums.length;
        if(n == 1){
            return 0;
        }

        long runningLeft = 0;
        long runningRight = 0;
        for(int i=n-1;i>=0; i--){
            runningRight = runningRight+nums[i];
        }
        
        long maxAvgDiff = Long.MAX_VALUE;
        int maxAvgDiffIndex = 0;
        long maxAvgDiffForLast = runningRight/n; 
        
        for(int i=0; i<n-1; i++){
            runningLeft = runningLeft+ nums[i];
            runningRight = runningRight - nums[i];

            long leftAvg = runningLeft/(i+1);
            long rightAvg = runningRight/(n-(i+1));
            long diff = Math.abs(leftAvg - rightAvg);
            // System.out.println("For "+i+":"+leftAvg+","+rightAvg);

            if(diff < maxAvgDiff){
                maxAvgDiff = diff;
                maxAvgDiffIndex = i;
            }
        }
        if(maxAvgDiffForLast < maxAvgDiff){
            maxAvgDiff = maxAvgDiffForLast;
            maxAvgDiffIndex = n-1;
        }

        // System.out.println("maxAvgDiff:"+maxAvgDiff+","+"maxAvgDiffIndex:"+maxAvgDiffIndex);
        return maxAvgDiffIndex;
    }    
}
