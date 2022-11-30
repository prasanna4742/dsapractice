public class LC13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        String[] symbol = new String[]{"M","CM","D","CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = new int[]{1000, 900,500,400, 100, 90, 50, 40, 10,9, 5, 4, 1};
        //StringBuilder sb = new StringBuilder(s);
        int ret =0;
        for(int i =0; i< symbol.length; i++){
            while(s.indexOf(symbol[i], 0) == 0){
                ret=ret+value[i];
                s = s.replaceFirst(symbol[i], "");
            }
        }
        return ret;
    }    
}
