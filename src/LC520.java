public class LC520 {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("Leetcode"));
    }

    public static boolean detectCapitalUse(String word) {
        char[] charArr = word.toCharArray();
        if(charArr[0] >= 'a'){
            for(char c: charArr){
                if(c >= 'A' && c <= 'Z'){
                    return false;
                }    
            }
            return true;
        }
        if(charArr.length == 1){
            return true;
        }

        //First char Caps
        int lowCnt = 0;
        int capCnt = 1;
        for(int i=1; i<charArr.length; i++){
            char c = charArr[i];
            if(capCnt > 1 && lowCnt > 0){
                return false;
            }            
            if(c >= 'A' && c <= 'Z'){
                capCnt++;
            }
            else{
                lowCnt++;
            }
        }

        if(capCnt == 1 && lowCnt == charArr.length-1){
            return true;
        }

        if(capCnt > 1 && lowCnt > 0){
            return false;
        }            

        return true;
    }
}
