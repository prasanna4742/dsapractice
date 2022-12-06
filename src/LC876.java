import java.util.Stack;

public class LC876 {

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    
    public static void main(String[] args) {
        
    }

    public static ListNode middleNode(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        
        int llLength = 0;
        ListNode node = head;

        while(node != null){
            stack.push(node);
            llLength++;
            node = node.next;
        }

        int mid = llLength/2 + 1;
        while(llLength > mid){
            stack.pop();
            llLength--;
        }
        return stack.pop();
    }    
}
