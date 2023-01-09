import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class CodalityT2 {
    public static void main(String[] args) {
        System.out.println(upperLower("aZABaabaz"));        
        System.out.println(upperLower("aZAbaz"));        
        System.out.println(upperLower("azABaabza"));        

    }
    

    public static int upperLower(String s){

        int maxLen = -1;
        Queue<String> q = new ArrayDeque<String>();
        q.offer(s);
        while(!q.isEmpty()){
            String curr = q.poll();
            if(curr.length() == 1){
                continue;
            }
            if(curr.length() == 2){
                if(maxLen < 2 && Character.toUpperCase(curr.charAt(0)) == Character.toUpperCase(curr.charAt(1))){
                    maxLen = 2;
                }
                continue;
            }

            int i=0;
            for(; i<curr.length(); i++){
                char c = curr.charAt(i);
                char cToCheck =
                    Character.isLowerCase(c)?Character.toUpperCase(c):Character.toLowerCase(c);
                if(!curr.contains(String.valueOf(cToCheck))){
                    break;
                }
            }
            if(i != curr.length()){
                Arrays.stream(curr.split(String.valueOf(curr.charAt(i)))).forEach(q::offer);
            }
            else{
                maxLen = maxLen<curr.length()?curr.length():maxLen;
            }
        }
        return maxLen;
    }
}
