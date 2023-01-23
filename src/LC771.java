public class LC771 {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    public static int numJewelsInStones(String jewels, String stones) {
     
        char[] jArrSmall = new char[26];
        char[] jArrCaps = new char[26];
        
        for(char c: jewels.toCharArray()){
            if(Character.isUpperCase(c)){
                jArrCaps[c-'A'] = 1;
            }
            else{
                jArrSmall[c-'a'] = 1;
            }

        }

        int jCnt = 0;
        for(char s : stones.toCharArray()){

            if(Character.isUpperCase(s)){
                if(jArrCaps[s-'A'] == 1){
                    jCnt++;
                }
                
            }
            else if(jArrSmall[s-'a'] == 1){
                jCnt++;
            }

        }

        return jCnt;
    }    
}
