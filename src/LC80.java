public class LC80 {
    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,1,2,2,3,3,3,3,4,5,6,6,6,6,7});
        removeDuplicates(new int[]{1,1,1,2,2,3});
        removeDuplicates(new int[]{1,1,1,2,2,2,3,3});
        removeDuplicates(new int[]{0,0,1,1,1,1,2,2,2,4});
                
    }

    public static int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int prevCnt = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == prev){
                if(prevCnt >= 2){
                    nums[i] = Integer.MAX_VALUE;
                    prevCnt++;
                }
                else{
                    prevCnt++;
                }
            }
            else{
                if(prevCnt>2){
                    for(int k=i,j=i-(prevCnt-2); j<nums.length && k<nums.length; j++,k++){
                        int tmp = nums[j];
                        nums[j]=nums[k];
                        nums[k] = tmp;
                    }
                    i=i-(prevCnt-2);
                }
                prevCnt=1;
                prev=nums[i];
            }
        }

        for(int num : nums){
            System.out.print(String.valueOf(num)+",");
        }
        System.out.println();
        int size = 0;
        for(size=0;size<nums.length;size++){
            if(nums[size] == Integer.MAX_VALUE){
                break;
            }
        }
        System.out.println(size);
        return size;
    }    

    // 1,2,3,X,5,6,X,X,7,7,X,8,9,X

}
