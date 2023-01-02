public class LC2129 {
    public static void main(String[] args) {
        System.out.println(capitalizeTitle("capiTalIze tHe OF titLe"));
    }

    public static String capitalizeTitle(String title) {
        
        StringBuilder sb = new StringBuilder();
        for(String token : title.split(" ")){
            if(token.length() <= 2){
                sb.append(token.toLowerCase());
            }
            else{
                sb.append(Character.toUpperCase(token.charAt(0)));
                for(int i=1; i<token.length(); i++){
                    sb.append(Character.toLowerCase(token.charAt(i)));
                }
            }
            sb.append(" ");
        }  
        
        return sb.toString().trim();
    }    
}
