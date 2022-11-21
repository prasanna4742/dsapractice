public class BinToDecimal {
    
    public static void main(String[] args) {
        String bin = "101";

        int result = 0;
        for(char c : bin.toCharArray()){
            int i = Character.getNumericValue(c);
            result = (result*2) + i;
        }

        System.out.println(result);

    }
}
