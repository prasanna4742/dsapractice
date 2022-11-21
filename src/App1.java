// public class App1 {

//     private static int length;
//     private static int ways;
//     public static void main(String[] args) {
//         // climbStairs(1);
//         // climbStairs(2);
//         // climbStairs(3);
//         // climbStairs(4);//5
//         // climbStairs(5);//8
//         // climbStairs(6);//13
//         climbStairs(7);
//     }

//     public static void  climbStairs(int n) {
//         length = n;
//         ways = 0;
//         findWays(0);
//         System.out.println(ways);
//     }

//     private static void findWays(int i) {
//         if(i+1 <= length)
//         {
//             findWays(i+1);
//         }
//         if(i+2 <= length)
//         {
//             findWays(i+2);
//         }
//         if(i >= length)
//         {
//             ways++;
//         }
//     }

// }
public class App1 {

    private static int length;
    private static int ways;
    public static void main(String[] args) {
        // climbStairs(1);
        // climbStairs(2);
        // climbStairs(3);
        // climbStairs(4);//5
        // climbStairs(5);//8
        // climbStairs(6);//13
        climbStairs(7);
    }

    public static void  climbStairs(int n) {
        System.out.println(findWays(0, n, 0));
    }

    private static int findWays(int i, int length, int retVal) {
        if(i+1 <= length)
        {
            findWays(i+1, length, retVal);
        }
        if(i+2 <= length)
        {
            findWays(i+2, length, retVal);
        }
        if(i >= length)
        {
            return retVal+1;
        }
        else
        {
            return retVal;
        }
    }

}
