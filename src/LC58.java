public class LC58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("fly me   to   the moon  "));        
    }
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length();
        int i;        
        for(i=n-1; i>=0; i--){
            if(s.charAt(i) == ' '){
                break;
            }
        }
        return n-1-i;
    }    
}
