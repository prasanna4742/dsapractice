import java.util.Stack;

public class LC232 {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(10);
        int param_3 = obj.peek();
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();
       System.out.println(param_3+","+param_3+","+param_4);
    }
}
class MyQueue {

    Stack<Integer> mainStack = new Stack<Integer>();
    Stack<Integer> tmpStack = new Stack<Integer>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        mainStack.push(x);
    }
    
    public int pop() {

        while(!mainStack.empty()){
            tmpStack.push(mainStack.pop());
        }
        int retValue = tmpStack.pop();

        while(!tmpStack.empty()){
            mainStack.push(tmpStack.pop());
        }
        return retValue;
        
    }
    
    public int peek() {
        while(!mainStack.empty()){
            tmpStack.push(mainStack.pop());
        }
        int retValue = tmpStack.peek();

        while(!tmpStack.empty()){
            mainStack.push(tmpStack.pop());
        }
        return retValue;
    }
    
    public boolean empty() {
        return mainStack.isEmpty();
    }
}
