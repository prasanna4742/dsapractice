public class MNode {
    public static void main(String[] args) {
        // long l = 9000000000L;
        System.out.println(9000000000L+900000000L);

        ListNode list1 = new ListNode(5);
        ListNode list11 = new ListNode(6);
        ListNode list12 = new ListNode(8);
        ListNode list13 = new ListNode(11);
        list12.next=list13; list11.next=list12; list1.next=list11;

        ListNode list2 = new ListNode(7);
        ListNode list21 = new ListNode(8);
        ListNode list22 = new ListNode(9);
        ListNode list23 = new ListNode(10);
        ListNode list24 = new ListNode(13);
        list23.next=list24;list22.next=list23; list21.next=list22; list2.next=list21;

        ListNode mergedHead = middleNode(list2);
        while(true){
            if(mergedHead == null)
            {
                break;
            }
            else{
                System.out.print(mergedHead.val+",");
                mergedHead = mergedHead.next;
            }
        }
        
    }
    public static ListNode middleNode(ListNode head) {
        int n =0;
        ListNode origHead = head;
        while( head.next != null)
        {
            head = head.next;
            n++;
        }


        //System.out.println(n);
        int mid = n/2;
        if(n%2 == 1)
        {
            mid++;
        }
        for(int i=0; i<mid; i++)
        {
            origHead = origHead.next;
        }

        return origHead;
    }    
}
