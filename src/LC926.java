public class LC926 {
    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00110"));
        System.out.println(minFlipsMonoIncr("010110"));
        System.out.println(minFlipsMonoIncr("00011000"));
    }

    public static int minFlipsMonoIncr(String s) {     
        int oneCounter = 0;
        int flipCounter = 0;
        for(char c : s.toCharArray()){
            if(c == '1'){
                oneCounter++;
            }
            else{
                flipCounter++;
            }
            flipCounter = Math.min(oneCounter, flipCounter);
        }

        return flipCounter;
    }    
}
