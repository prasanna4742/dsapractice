public class RevrseInt {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(12345));
        System.out.println(reverse(1999999999));
    }
    public static int reverse(int x) {        


        int result = 0;
        while(x != 0)
        {
            if(result != 0 && ((result*10)/result != 10))
            {
                return 0;
            }
            int digit = x%10;
            result = result*10+digit;
            x = x/10;
        }
        return result;
    }
}
