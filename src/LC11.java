public class LC11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
        
    }

    // public static int maxArea(int[] height) {

    //     int maxArea = 0;
    //     int length = height.length-1;
    //     for(int i=0; i<= length; i++){
    //         for(int j=i+1; j<=length; j++){
    //             int area = (j-i)*Math.min(height[i],height[j]);
    //             maxArea = (area>maxArea)?area:maxArea;                
    //         }
    //     }
    //     return maxArea;
    // }    

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int right = height.length-1;
        int left = 0; 

        while(left<right){
            int wd = right-left;
            int ht = Math.min(height[right], height[left]);
            maxArea = Math.max(maxArea, wd*ht);
            if(height[right] < height[left]){
                right--;
            }
            else if(height[right] > height[left]) {
                left++;
            }
            else{
                right--;
                left++;
            }
        }
        return maxArea;
    }    

}
