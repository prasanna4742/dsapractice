public class LC34 {
    public static void main(String[] args) {
        
        LC34 lc = new LC34();
        System.out.println((lc.searchRange(new int[]{5,7,7,8,8,10}, 8)));        
        System.out.println(lc.searchRange(new int[]{5,7,7,8,8,10}, 6));        
        System.out.println(lc.searchRange(new int[]{}, 0));        
        System.out.println(lc.searchRange(new int[]{2,2}, 1));        
        System.out.println(lc.searchRange(new int[]{2,2}, 2));        
        System.out.println(lc.searchRange(new int[]{2,3}, 2));        
        System.out.println(lc.searchRange(new int[]{2,3}, 3));        
        System.out.println(lc.searchRange(new int[]{3,3,3}, 3));       
        System.out.println(lc.searchRange(new int[]{1,2,3,3,3,3,4,5,9 }, 3));       
        System.out.println(lc.searchRange(new int[]{-3,-2,-1}, 0));       
        System.out.println(lc.searchRange(new int[]{-3,-2,-1}, -5));       


    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return new int[]{-1,-1};
        }    
        if(n ==1){
            if(nums[0] == target){
                return new int[]{0,0};
            }
            else{
                return new int[]{-1,-1};
            }
        }
        if(n == 2){
            if(nums[0] == target){
                if(nums[1] == target){
                    return new int[]{0,1};
                }
                else{
                    return new int[]{0,0};
                }
            }
            if(nums[1] == target){
                return new int[]{1,1};
            }
            return new int[]{-1,-1};
        }
        int[] retArr = searchRangeB(nums, target, 0, n-1);
        System.out.println(retArr[0]+","+retArr[1]);
        return retArr;
        // return searchRangeB(nums, target, 0, n-1);       
    }    

    private int[] findIndex(int[] nums, int target, int curr){
        int found = curr;

        int lowest = found;
        while(--curr >= 0){
            if(nums[curr] == target){
                lowest = curr;
            }
            else{
                break;
            }
        }

        int highest = found;
        while(++curr < nums.length){
            if(nums[curr] == target){
                highest = curr;
            }
            else{
                break;
            }
        }

        return new int[]{lowest, highest};
    }

    private int[] searchRangeB(int[] nums, int target, int low, int high) {
        // if( target == nums[low]){
        //     return findIndex(nums, target, low);
        // }
        // if( target == nums[high]){
        //     return findIndex(nums, target, high);
        // }
        // while(low <high){
        //     int mid = low+(high-low)/2;
        //     if(target == nums[mid]){
        //         return findIndex(nums, target, mid);
        //     }
        //     if(target > nums[mid]){
        //         return searchRangeB(nums, target, mid+1, high);
        //     }
        //     else{
        //         return searchRangeB(nums, target, low, mid-1);
        //     }
        // }
        // while(low <= high && low >=0 && high < nums.length ){
        while(high-low > 1){    
            if( target == nums[low]){
                return findIndex(nums, target, low);
            }
            if( target == nums[high]){
                return findIndex(nums, target, high);
            }    
            int mid = low+(high-low)/2;
            if(target == nums[mid]){
                return findIndex(nums, target, mid);
            }
            if(target > nums[mid]){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return new int[]{-1,-1};
    }


}
