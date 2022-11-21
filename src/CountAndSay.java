public class CountAndSay {
    
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    
    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String sayWhat= countAndSay(n-1);
        char[] sayWhatArr = sayWhat.toCharArray();
        StringBuilder sb = new StringBuilder("");
        int counter=0;
        int prevDigit = Character.getNumericValue(sayWhatArr[0]);
        for(int i =0; i<sayWhatArr.length; i++){
            int digit = Character.getNumericValue(sayWhatArr[i]);
            if(prevDigit == digit){
                counter++;
            }else{
                sb.append(counter).append(prevDigit);
                counter=1;
            }
            prevDigit=digit;
        }
        if(counter != 0){
            sb.append(counter).append(prevDigit);
        }
        return sb.toString();
    }    
}
