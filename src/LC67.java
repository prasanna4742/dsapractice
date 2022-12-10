public class LC67 {
    public static void main(String[] args) {
        // System.out.println(addBinary(
        //     "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
        //     "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        if(b.length() > a.length()){
            return addBinary(b, a);
        }

        StringBuilder result = new StringBuilder();
        int co=0;
        for(int i=a.length()-1, j=b.length()-1; i>=0 || j>=0; i--, j--){
            int addition = co + a.charAt(i)-'0';
            if(j >= 0){
                addition = addition + b.charAt(j)-'0';
            }

            switch(addition){
                case 0:
                case 1:
                    result.insert(0, String.valueOf(addition));
                    co = 0;
                    break;
                case 2:
                    result.insert(0, "0");
                    co = 1;
                    break;
                case 3:
                    result.insert(0, "1");
                    co = 1;
                    break;
            }
        }
        if(co == 1){
            result.insert(0, "1");
        }
        return result.toString();
    }
}