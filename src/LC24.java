public class LC24 {
    public static void main(String[] args) {
    
        LC24 lc24 = new LC24();
        lc24.test();
    }

    public ListNode test() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        // ListNode four = new ListNode(4);
        ListNode head = one;
        one.next = two;
        two.next = three;
        // three.next = four;
        return swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        ListNode newHead = head.next;
        ListNode pHead = head;
        while(pHead!= null){
            System.out.println(pHead.val+"->");
            pHead = pHead.next;
        }

        ListNode node = head;
        ListNode prev = null;
        while(node != null && node.next != null){
            ListNode nxt = node.next;
            if(nxt !=null){
                node.next = nxt.next;
                nxt.next = node;
            }
            if(prev != null){
                prev.next = nxt;
            }            
            prev = node;
            node = node.next;
        }

        pHead = newHead;
        while(pHead!= null){
            System.out.println(pHead.val+"->");
            pHead = pHead.next;
        }

        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
