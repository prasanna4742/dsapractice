import java.util.ArrayList;
import java.util.List;

public class Atoi{
    public static void main(String[] args) {
        // System.out.println(myAtoi("2147483646"));
        System.out.println(myAtoi("-2147483649"));        
        // System.out.println(myAtoi("words with 987"));
        // System.out.println(myAtoi("987"));
        // System.out.println(myAtoi("4193 with words"));
        // System.out.println(myAtoi("-4193 with words"));
        // // System.out.println(myAtoi("-774193 with words"));
        // System.out.println(myAtoi("-91283472332"));
        // System.out.println(myAtoi("00000-42a1234"));
        // System.out.println(myAtoi("2147483648"));
        // System.out.println(myAtoi("42"));

    }
    

    public static int myAtoi(String s){
        boolean digitsStarted=false;
        boolean expectDigits=false;
        int result = 0;
        s = s.trim();
        List<Integer> dS = new ArrayList<Integer>();
        int multiply = 1;
        if(s!= null && s.length()>0){
            char first = s.charAt(0);
            if(first == '-'){
                multiply = -1;
                expectDigits = true;
            }
            else if(first == '+'){
                multiply = 1;
                expectDigits = true;
            }
            else if(Character.isDigit(first)){
                dS.add(Character.getNumericValue(first));
                digitsStarted=true;
            }
            else
            {
                return 0;
            }

            for(int i=1; i<s.length(); i++){
                char currChar = s.charAt(i);
                boolean isDigit = Character.isDigit(currChar);

                if(digitsStarted){
                    if(!isDigit){
                        break;
                    }
                    else{
                        dS.add(Character.getNumericValue(currChar));
                    }
                }
                else{
                    if(expectDigits){
                        if(!isDigit){
                            break;
                        }
                        else{
                            dS.add(Character.getNumericValue(currChar));
                            expectDigits=true;
                        }
                            
                    }
                }
            }
        }

        int ind=0;
        while(ind < dS.size()){
            int i = dS.get(ind);
            ind++;
            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE*-1; 
            if(multiply == 1){
                if (result > max/10 || (result == max/10 && i >7)){
                        return max;
                }
            }
            else{
                if (result*-1 < min/10 || (result*-1 == min/10 && i >7)){
                    return min;
                }
            }    
            

            result = result*10 + i;
        }
        return result*multiply;
    }
}