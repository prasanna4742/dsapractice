import java.util.ArrayList;
import java.util.List;

public class NeedleInHay {
    public static void main(String[] args) {
        // System.out.println(strStr("mississipissip", "issip"));
        System.out.println(strStr("aaaaa", "bba"));
    }

    public static int strStr(String haystack, String needle) {
        int result = -1;
        char[] hayArr = haystack.toCharArray();
        char[] nedArr = needle.toCharArray();
        List<Integer> startPoints = new ArrayList<Integer>();
        for(int i =0; i<hayArr.length; i++){
            if(hayArr[i] == nedArr[0]){
                startPoints.add(i);
            }
        }

        if(startPoints.size() == 0){
            return -1;
        }

        int startPointIndex=0;
        for(int i=startPoints.get(startPointIndex), j=0; i<startPoints.get(startPointIndex)+nedArr.length && i<hayArr.length; i++, j++ ){
            if(hayArr[i] != nedArr[j]){
                startPointIndex++;
                if(startPointIndex >= startPoints.size()){
                    return -1;
                }
                i = startPoints.get(startPointIndex)-1;
                j = -1;
            }
            else if(j == nedArr.length-1){
                return startPoints.get(startPointIndex);      
            }
        }
        return result;
    }
    
}
