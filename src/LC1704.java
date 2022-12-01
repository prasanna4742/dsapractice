public class LC1704 {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
        System.out.println(halvesAreAlike("textbook"));
        System.out.println(halvesAreAlike("AbCdEfGh"));
        System.out.println(halvesAreAlike("tkPAdxpMfJiltOerItiv"));
    }
    

    public static boolean halvesAreAlike(String s) {
        // int v1=0;
        // int v2=0;
        int v=0;
        int n=s.length();
        for(int i =0; i<n; i++){
            switch(s.charAt(i)){
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                    if(i<n/2){
                        // v1++;
                        v++;
                    }
                    else{
                        // v2++;
                        v--;
                    }
                    break;    
            }
        }   
        // if(v1 == v2){
        if( v == 0){
            return true;
        }
        return false;
    }    
}
