import java.util.Stack;

public class LC19 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        LC19 lc19 = new LC19();
        lc19.test();
    }

    public ListNode test() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode head = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        return removeNthFromEnd(head, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
    
        // ListNode pHead = head;
        // while(pHead!= null){
        //     System.out.println(pHead.val+"->");
        //     pHead = pHead.next;
        // }

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode node = head;
        while(node != null){
            stack.add(node);
            node = node.next;
        }

        boolean brokenFromLoop=false;
        int cnt=1;
        ListNode toBeRemoved=null;
        while(!stack.isEmpty()){
            ListNode curr = stack.pop();
            if(cnt == n){
                toBeRemoved = curr;
            }
            else if(cnt == n+1){
                curr.next = toBeRemoved.next;
                brokenFromLoop = true;
                break;              
            }       
            cnt++;     
        }

        // pHead = head;
        // while(pHead!= null){
        //     System.out.println(pHead.val+"->");
        //     pHead = pHead.next;
        // }

        if(cnt-1 == n && !brokenFromLoop){
            return head.next;
        }
        else{
            return head;
        }

    }

}
