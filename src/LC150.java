import java.util.Stack;

public class LC150 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        System.out.println(evalRPN(new String[]{"3","11","+","5","-"}));
        System.out.println(evalRPN(new String[]{"3","11","5","+","-"}));
        
    }

    public static int evalRPN(String[] tokens) {

        if(tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }

        int result = 0;
        Stack<String> stack = new Stack<String>();
        for(int i=0; i<tokens.length; i++){
            switch(tokens[i]){
                case "+":
                    int first = Integer.parseInt(stack.pop());
                    int second = Integer.parseInt(stack.pop());
                    result = second + first;
                    stack.push(String.valueOf(result));
                    break;

                case "-":
                    first = Integer.parseInt(stack.pop());
                    second = Integer.parseInt(stack.pop());
                    result = second - first;
                    stack.push(String.valueOf(result));
                    break;
                
                case "*":
                    first = Integer.parseInt(stack.pop());
                    second = Integer.parseInt(stack.pop());
                    result = second * first;
                    stack.push(String.valueOf(result));
                    break;
                
                case "/":
                    first = Integer.parseInt(stack.pop());
                    second = Integer.parseInt(stack.pop());
                    result = second / first;
                    stack.push(String.valueOf(result));
                    break;

                default:
                    stack.push(tokens[i]);
                    break;
            }
        }
        return result;
    }

}