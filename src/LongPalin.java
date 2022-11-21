public class LongPalin {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cadgfabbagpabccbagfh"));
        System.out.println(longestPalindrome("cadgfabbagpabcbcbagfh"));
        System.out.println(longestPalindrome("abc"));
        System.out.println(longestPalindrome("ab"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("abcdghfi"));
        System.out.println(longestPalindrome("aba"));
        System.out.println(longestPalindrome("abba"));
        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome("cccc"));
        System.out.println(longestPalindrome("ccc"));


    }

    public static String longestPalindrome(String s) {
        if(s != null && s.length()==1)
        {
            return s;
        }
        if(s != null && s.length()==2)
        {
            if(s.charAt(0)==s.charAt(1))
            {
                return s;
            }
            else
            {
                return String.valueOf(s.charAt(0));
            }
        }
        String myPalin = "";   
        for(int i=1; i<s.length(); i++){
            if(i+1<s.length() && s.charAt(i-1)==s.charAt(i+1)){
                StringBuffer currPalin=new StringBuffer("");
                currPalin.append(s.charAt(i-1)).append(s.charAt(i)).append(s.charAt(i+1));

                //Now traverese the surroundings
                int start=i-2;
                int end=i+2;
                while(start>-1 && end<s.length()){
                    if(s.charAt(start)==s.charAt(end)){
                        currPalin.insert(0, s.charAt(start));
                        currPalin.append(s.charAt(end));
                        start--;
                        end++;
                    }
                    else{
                        break;
                    }
                }
                if(myPalin.length()<currPalin.length())
                {
                    myPalin = currPalin.toString();
                }
            }         
            if(s.charAt(i)==s.charAt(i-1)){
                StringBuffer currPalin=new StringBuffer("");
                currPalin.append(s.charAt(i-1)).append(s.charAt(i));

                //Now traverese the surroundings
                int start=i-2;
                int end=i+1;
                while(start>-1 && end<s.length()){
                    if(s.charAt(start)==s.charAt(end)){
                        currPalin.insert(0, s.charAt(start));
                        currPalin.append(s.charAt(end));
                        start--;
                        end++;
                    }
                    else{
                        break;
                    }
                }
                if(myPalin.length()<currPalin.length())
                {
                    myPalin = currPalin.toString();
                }
            }
        }
        if(myPalin == "" && s.length()>1)
            return String.valueOf(s.charAt(0));
        else
            return myPalin;
    }
}
