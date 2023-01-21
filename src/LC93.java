import java.util.ArrayList;
import java.util.List;

public class LC93 {
    public static void main(String[] args) {
        // System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("101023"));

    }

    public static List<String> restoreIpAddresses(String s) {

        List<String> retList = new ArrayList<String>();
        restoreRec(s, retList, "", 0);
        return retList;
    }

    private static void restoreRec(String s, List<String> retList, String partial, int cnt) {

        if(cnt == 4){
            if(s.length() == 0){
                retList.add(partial.substring(0, partial.length()-1));
            }
            return;
        }

        //i==1
        if(s.length() < 1){
            return;
        }
        String part = s.substring(0,1);
        restoreRec(s.substring(1), retList, partial+part+".", cnt+1);

        //i==2
        if(s.length() < 2 || s.charAt(0) == '0'){
            return;
        }
        part = s.substring(0,2);
        restoreRec(s.substring(2), retList, partial+part+".", cnt+1);

        //i==3
        if(s.length() < 3 || s.charAt(0) == '0'){
            return;
        }
        part = s.substring(0,3);
        if(Integer.parseInt(part)<=255){
            restoreRec(s.substring(3), retList, partial+part+".", cnt+1);
        }
    }    
}
