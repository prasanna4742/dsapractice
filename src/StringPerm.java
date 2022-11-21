public class StringPerm {
    public static void main(String[] args) {
        doPerms("ABC",0,2);
        doPerms("ABCD",0,3);

    }

    public static void doPerms(String s, int start, int end){
        if(start == s.length()){
            System.out.println(s);
            return;
        }

        for(int i=start; i<=end; i++){
            String s1 = doSwap(s,i,start);
            doPerms(s1, start+1,end);
        }
    }

    private static String doSwap(String s, int start, int i) {
        char[] stringArr = s.toCharArray();
        char tmp = stringArr[start];
        stringArr[start] = stringArr[i];
        stringArr[i] = tmp;
        return String.valueOf(stringArr);
    }
}
