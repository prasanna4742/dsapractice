import java.util.Arrays;

public class LC136 {

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int partner = nums[0];
        boolean partnerFound = false;
        for(int i=1; i<nums.length;i++){

            if(partnerFound){
                partnerFound = false;
                partner = nums[i];
            }
            else{
                if(nums[i] == partner){
                    partnerFound = true;
                }    
                else{
                    return partner;
                }
            }
        }   
        if(!partnerFound){
            return partner;
        }
        return -1; 
    }   
    
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,3,1,3,4}));
    }
}
