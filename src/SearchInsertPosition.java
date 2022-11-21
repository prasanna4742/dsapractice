public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));    
    }

    //1,2,5,7, 9,11,17,20 target:10
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n;

        if(target> nums[nums.length-1]){
            return nums.length;
        }
        else if(target < nums[0]){
            return 0;
        }
        while(start <= end){
            int mid = start+(end-start)/2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target>nums[mid]){
                start = mid+1;
            }
            else if(target<nums[mid]){
                end = mid-1;
            }
        }
        return start;
    }    
}
