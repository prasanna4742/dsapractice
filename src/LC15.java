public class LC15 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","floight"}));   
    }
    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        int i =0;

        for(char c : strs[0].toCharArray()){
            boolean allHaveit=true;
            for(String currString : strs){
                if(i >= currString.length() || currString.charAt(i) != c){
                    allHaveit = false;
                }
            }
            if(allHaveit){
                prefix = prefix+c;
                i++;
            }
        }        
        return prefix;
    }    
}
