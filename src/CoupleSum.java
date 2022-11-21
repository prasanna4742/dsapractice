import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CoupleSum {
    public static void main(String[] args) {

        int targetSum = 8;
        // int[] myArr = new int[]{1,2,4,4};
        int[] myArr = new int[]{1,2,3,4,5};

        int start = 0;
        
        int end = myArr.length-1;
        while(end > start)
        {
            if(myArr[start]+myArr[end] > targetSum){
                end--;
            }
            else if (myArr[start]+myArr[end] < targetSum){
                start++;
            }
            else {
                System.out.println(myArr[start]+","+myArr[end]);
                break;
            }
        }
        
    }

}
