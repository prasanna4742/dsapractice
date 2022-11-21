import java.util.HashMap;
import java.util.Map;

public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        String ret = "";
        if(num >=1000){
            int rF = num / 1000;
            ret = "M".repeat(rF);
            num = num % 1000;
        }
        if(num >= 900){
            ret = ret + "CM";
            num = num - 900;
        }
        if(num >= 500){
            ret = ret+ "D";
            num = num - 500;
        }
        if(num >= 400){
            ret = ret+ "CD";
            num = num - 400;
        }
        if(num >= 100){
            int rF = num / 100;
            ret = ret + "C".repeat(rF);
            num = num % 100;
        }
        if(num >= 90){
            ret = ret + "XC";
            num =  num - 90;
        }
        if(num >= 50){
            ret = ret + "L";
            num = num - 50;
        }
        if(num >= 40){
            ret = ret + "XL";
            num = num - 40;
        }
        if(num >= 10){
            int rF = num / 10;
            ret = ret + "X".repeat(rF);
            num = num % 10;
        }
        if(num >= 9){
            ret = ret + "IX";
            num = num-9;
        }
        if(num >= 5){
            ret = ret + "V";
            num = num-5;
        }
        if(num >= 4){
            ret = ret + "IV";
            num = num-4;
        }
        if(num >= 1){
            ret = ret + "I".repeat(num);
        }
        return ret;
    }
}
