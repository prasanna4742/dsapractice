public class LC125 {
    public static void main(String[] args) {

        // System.out.println(isPalindrome("race a ecar"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("0P"));

        // System.out.println(isPalindrome(" "));
    }

    public static boolean isPalindrome(String s) {
     
        return palinRec(s,0, s.length()-1);
    }

    private static boolean palinRec(String s, int i, int j) {

        if(i > j){
            return true;
        }

        boolean iOrjChanged = false;
        char iChar =s.charAt(i);
        char jChar =s.charAt(j);
        if(!Character.isLetterOrDigit(iChar)){
            i++;
            iOrjChanged = true;
        }
        if(!Character.isLetterOrDigit(jChar)){
            j--;
            iOrjChanged = true;
        }

        if(iOrjChanged){
            return palinRec(s, i, j);
        }

        return Character.toUpperCase(iChar) == Character.toUpperCase(jChar) && palinRec(s, i+1, j-1);        
    }    
}
