public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2, -2));
        System.out.println(myPow(0.44528, 0));  
        System.out.println(myPow(0.00001, 2147483647));    
    }

    public static double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        else 
        {
            if( n < 0){
                x=1/x;
                n=n*-1;
            }
            double ret = Math.pow(x, n);
            return ret;
        }
    }
    // public static double myPow(double x, int n) {
    //     if( n == 0)
    //     {
    //         return 1;
    //     }
    //     if(n<0){
    //         return muPowRec(1/x, n*-1);
    //     }
    //     else{
    //         return muPowRec(x, n);
    //     }
    // }

    // private static double muPowRec(double x, int n) {
    //     if(n == 1)
    //     {
    //         return x;
    //     }
    //     return x*muPowRec(x, n-1);
    // }
    
}
