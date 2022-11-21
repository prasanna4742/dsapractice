import java.util.EmptyStackException;
import java.util.Stack;

public class BraceCheck {
    public static void main(String[] args) {
        // System.out.println(isValid("()"));
        // System.out.println(isValid("()[]{}"));
        // System.out.println(isValid("(]"));
        // System.out.println(isValid("(]]"));
        // System.out.println(isValid("([)]"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(isValid("(("));
    }
    public static boolean isValid(String s) {

        if(s.length()%2 == 1)
        {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();

        final char round_o = '(';
        final char curly_o = '{';
        final char squar_o = '[';
        final char round_c = ')';
        final char curly_c = '}';
        final char squar_c = ']';

        for(char c : s.toCharArray())
        {
            switch (c)
            {
                case round_o:
                    stack.push(round_c);
                    break;
                case curly_o:
                    stack.push(curly_c);
                    break;
                case squar_o:
                    stack.push(squar_c);
                    break;
                default:
                    try{
                        Character popped = stack.pop();
                        if(popped.charValue() != c)
                        {
                            return false;
                        }    
                    }
                    catch(EmptyStackException es)
                    {
                        return false;
                    }
            }
        }
        if (stack.size() > 0)
        {
            return false;
        }
        return true;
    }
}
