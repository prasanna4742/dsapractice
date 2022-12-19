import java.util.Arrays;
import java.util.Stack;

public class LC739 {
    public static void main(String[] args) {
        Arrays.stream(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})).forEach(System.out::print);
        System.out.println();
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];

        // Below is brute force and times out
        // for(int i =0; i<temperatures.length-1; i++){
        //     for(int j =i+1; j<temperatures.length; j++){
        //         if(temperatures[j]>temperatures[i]){
        //             output[i] = j-i;
        //             break;
        //         }
        //     }
        // }

        // Let's try stack based
        Stack<Integer> indexStack = new Stack<Integer>();
        for(int i=0; i<temperatures.length; i++){
            while(!indexStack.empty() && temperatures[indexStack.peek()] < temperatures[i] )
            {
                int indexToUpdate = indexStack.pop();
                output[indexToUpdate] = i - indexToUpdate;
            }
            indexStack.push(i);
        }
        return output;
    }    
}
