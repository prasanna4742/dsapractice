import java.util.ArrayList;
import java.util.List;

public class PerfSquare {
    
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(8));
        System.out.println(isPerfectSquare(217));
        System.out.println(isPerfectSquare(225));
        System.out.println(isPerfectSquare(10000));

    }

    public static boolean isPerfectSquare(int num) {
        if(num ==1){
            return true;
        }
        int start=1;
        int end = num;
        while(end-start>1){
            int mid = (end-start)/2+start;
            int res = mid*mid;
            if(res == num){
                return true;
            }
            else if(res > num){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        return false;
    }
}
