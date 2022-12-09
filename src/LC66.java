import java.util.Arrays;

public class LC66 {
    public static void main(String[] args) {
        // int[] retArr = plusOne(new int[]{1,2,3});        
        int[] retArr = plusOne(new int[]{9,9,9});        
        Arrays.stream(retArr).forEach(System.out::print);
        System.out.println();
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        if( digits[len-1] != 9){
            digits[len-1] = digits[len-1]+1;
            return digits;
        }

        int co = 1;
        for(int i=len-1; i>=0; i--){   
            if(co == 0){
                break;
            }         
            if(digits[i] == 9){
                if(co == 1){
                    digits[i] = 0;
                    co = 1;
                }
            }
            else{                
                digits[i] = digits[i]+1;
                co = 0;
            }
        }

        if( co == 1){
            int[] retArr = new int[len+1];
            retArr[0] = 1;
            int j =1;
            for( int i : digits){
                retArr[j++] = digits[i];
            }
            return retArr;
        }
        else{
            return digits;
        }
    }    
}