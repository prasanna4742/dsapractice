import java.util.Arrays;

public class LC1833 {
    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{1,3,2,4,1}, 7));
        System.out.println(maxIceCream(new int[]{10,6,8,7,7,8}, 5));
        System.out.println(maxIceCream(new int[]{1,6,3,1,2,5}, 20));
    }

    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int cnt = 0;
        for(int c : costs){
            coins = coins-c;
            if(coins < 0){
                return cnt;
            }
            else{
                cnt++;
            }
        }
        return cnt;
    }    
}
