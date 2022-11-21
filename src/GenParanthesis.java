import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GenParanthesis {
    public static void main(String[] args) {
        // System.out.println(generateParenthesis(1));
        // System.out.println(generateParenthesis(2));
        // System.out.println(generateParenthesis(3));
        // System.out.println(generateParenthesis(4));
        // StringBuilder sb = new StringBuilder("abc");
        // sb.insert(sb.length(), 1);
        // System.out.println(sb.toString());

        System.out.println(generateParenthesis(1, true));
        System.out.println(generateParenthesis(2, true));
        System.out.println(generateParenthesis(3, true));
        System.out.println(generateParenthesis(4, true));

    }  
    
    public static List<String> generateParenthesis(int n) {
        if(n == 1){
            List<String> baseList = new ArrayList<String>();
            baseList.add("()");
            return baseList;
        }
        Set<String> retSet = new HashSet<String>();

        List<String> baseList = generateParenthesis(n-1);
        for(String ele : baseList){
            for(int i =0; i<ele.length(); i++){

                for(int j=0; j<=ele.length(); j++){
                    StringBuilder sb = new StringBuilder(ele);
                    sb.insert(j, "(");                    
                    for(int k=j+1; k<=sb.length();k++){
                        StringBuilder sbTmp = new StringBuilder(sb.toString());
                        sbTmp.insert(k, ")");
                        retSet.add(sbTmp.toString());
                    }
                }
            }
                // retSet.add("("+ele+")");
                // retSet.add("()"+ele);
                // retSet.add(ele+"()");
        }
        List<String> retList = retSet.stream().collect(Collectors.toList());
        System.out.println(retList.size());
        return retList;
    }

    public static List<String> generateParenthesis(int n, boolean backT) {

        List<String> retList = new ArrayList<String>();
        genByBacktraciking(retList,"",0, 0, n);
        return retList;
    }

    private static void genByBacktraciking(List<String> retList, String input, int openN, int closeN, int n) {
        if(openN == n && openN == closeN){
            retList.add(input);
            return;
        }

        if(openN < n){
            genByBacktraciking(retList, input+"(", openN+1, closeN, n);
        }

        if(closeN < openN){
            genByBacktraciking(retList, input+")", openN, closeN+1, n);
        }
    
    }
}
    

// ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
// [()()()(), (()())(), (()(())), ()()(()), (())()(), (((()))), (())(()), ()((())), ()(())(), ()(()()), (()()()), ((()())), ((()))(), ((())())]