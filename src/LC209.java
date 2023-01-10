public class LC209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1,18,20}));
        System.out.println(minSubArrayLen(213,new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
        
        System.out.println(minSubArrayLen(4,new int[]{1,4,4}));
        System.out.println(minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(minSubArrayLen(15,new int[]{1,2,3,4,5}));
        
    }

    public static int minSubArrayLen(int s, int[] a) {
        int sum=0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int i =0;
        for(i=0; i<a.length && start <a.length; i++){
            sum+= a[i];

            if(sum >= s){
                min = Math.min(min, i-start);
                if(start==0){
                    min++;
                }
                i = start+1;
                start++;
                sum=0;
            }
        }
        return min == Integer.MAX_VALUE?0:min;
    }
    // Subarray means you cannot sort;
    // public static int minSubArrayLen(int s, int[] a) {
    //     Arrays.sort(a);
    //     int sum=0;
    //     for(int i=a.length-1; i>=0; i--){
    //         sum += a[i];
    //         if(sum >= s){
    //             return a.length-i;
    //         }
    //     }

    //     return 0;
    // }    

    // public static int minSubArrayLen(int s, int[] a) {
    //     if (a == null || a.length == 0)
    //     return 0;
      
    //   int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
      
    //   while (j < a.length) {
    //     sum += a[j++];
        
    //     while (sum >= s) {
    //       min = Math.min(min, j - i);
    //       sum -= a[i++];
    //     }
    //   }
      
    //   return min == Integer.MAX_VALUE ? 0 : min;        
    // }
}
