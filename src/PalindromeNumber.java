public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(11221));
        System.out.println(isPalindrome(-11221));
    }

    // 0,1,2,3

    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        char[] s = String.valueOf(x).toCharArray();

        for(int i=0,j=s.length-1; (i<s.length&&j>=0);i++,j--){
            if(s[i] != s[j]){
                return false;
            }
        }

        return true;
    }

}
