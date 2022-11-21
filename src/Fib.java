public class Fib {
    //1,1,2,3,5,8,13,21
    public static void main(String[] args) {
        int n = 5;    
        int dpArr[] = new int[n+1];
        dpArr[1] = 1;
        dpArr[2] = 1;
        System.out.println(fib_dp(n, dpArr));
    }

    private static int fib_dp(int n, int[] dpArr) {
    
        for(int i = 3; i<=n; i++)
        {
            dpArr[i]=dpArr[i-1]+dpArr[i-2];
        }    
        return dpArr[n];
    }
    
}
