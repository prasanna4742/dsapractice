public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
        boolean charRead = false;
        s = s.trim();
        StringBuilder ret= new StringBuilder("");
        int n = s.length();
        int end=n-1;
        char space = ' ';
        char[] sArr = s.toCharArray();
        for(int i=n-1; i>=0; i--){
            if(sArr[i] != space){
                if(!charRead){
                    charRead = true;
                    end = i;
                }
                if(i==0){
                    for(int j=0; j<=end; j++){
                        ret.append(sArr[j]);
                    }
                }
            }
            else{
                if(charRead){
                    charRead = false;
                    for(int j=i+1; j<=end; j++){
                        ret.append(sArr[j]);
                    }
                    ret.append(space);
                }
            }
        }
        return ret.toString().trim();
    }    
}
