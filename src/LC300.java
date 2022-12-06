import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LC300 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(lengthOfLIS(new int[]{4,10,4,3,8,9}));        
        System.out.println(lengthOfLIS(new int[]{4,8,9,10,5,3,8,9}));        

    }

    //Works but in-efficient
    // public static int lengthOfLIS(int[] nums) {

    //     Set<Stack<Integer>> subSeqList = new HashSet<Stack<Integer>>();
    //     Set<Stack<Integer>> tmpList = new HashSet<Stack<Integer>>();
    //     Stack<Integer> newStack = new Stack<Integer>();
    //     newStack.push(nums[0]);
    //     subSeqList.add(newStack);

    //     for(int i=1; i< nums.length; i++){
    //         tmpList.clear();
    //         int currElement = nums[i];
    //         for( Stack<Integer> currStack : subSeqList){
    //             if(currStack.peek() == currElement){
    //                 continue;
    //             }
    //             else if(currStack.peek() < currElement){
    //                 currStack.push(currElement);
    //             }
    //             else{
    //                 Stack<Integer> clonedS = (Stack<Integer>)currStack.clone();
    //                 tmpList.add(clonedS);
    //                 currStack.pop();
    //                 while(!currStack.isEmpty()){
    //                     int ele = currStack.peek();
    //                     if(ele >= currElement){
    //                         currStack.pop();
    //                     }
    //                     else{
    //                         break;
    //                     }
    //                 }
    //                 currStack.push(currElement);
    //             }
    //         }
    //         subSeqList.addAll(tmpList);            
    //     }

    //     int max = (subSeqList.stream().mapToInt(x -> x.size()).max()).getAsInt();
        
    //     return max;
    // }    

    public static int lengthOfLIS(int[] nums) {

        return 0;
    }
}
