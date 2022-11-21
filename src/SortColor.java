import java.util.Arrays;

public class SortColor {
    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }

    public static void sortColors(int[] nums) {
        int zero=0,one=0,two=0;
        for (int i : nums){
            switch(i){
                case 0:
                zero++;
                break;
            case 1:
                one++;
                break;
            case 2:
                two++;
                break;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(i< zero){
                nums[i] =0;
            }
            else if(i < zero+one){
                nums[i] = 1;

            }
            else if(i < zero+one+two){
                nums[i] = 2;
            }
        }
        for(int i : nums){
            System.out.print(i+",");
        }
    }

}
