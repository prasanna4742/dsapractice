public class MergeSortedList {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }    

    public static void main(String[] args) {

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

        ListNode mergedHead =mergeTwoLists(list1, list2);
        while(true){
            if(mergedHead == null)
            {
                break;
            }
            else{
                System.out.print(mergedHead.val);
                mergedHead = mergedHead.next;
            }
        }
        System.out.println("done");
    }

    public static MergeSortedList.ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode mergedHead = null;
        ListNode mergedCurr = null;

        if(head1 != null && head2 != null)
        {
                if (head1.val < head2.val)
                {
                    mergedHead = new ListNode(head1.val);
                    mergedCurr = mergedHead;
                    head1 = head1.next;
                }
                else if (head2.val < head1.val){
                    mergedHead = new ListNode(head2.val);
                    mergedCurr = mergedHead;
                    head2 = head2.next;
                }
                else{
                    mergedHead = new ListNode(head1.val);
                    mergedCurr = mergedHead;
                    mergedCurr.next = new ListNode(head2.val);
                    mergedCurr = mergedCurr.next;

                    head1 = head1.next;
                    head2 = head2.next;
                }

            while(head1 != null || head2 != null){
                if(head1 == null)
                {
                    ListNode addNode = new ListNode(head2.val);
                    mergedCurr.next = addNode;
                    mergedCurr = mergedCurr.next;                    
                    head2 = head2.next;
                }
                else if(head2 == null) {
                    ListNode addNode = new ListNode(head1.val);
                    mergedCurr.next = addNode;
                    mergedCurr = mergedCurr.next;                    
                    head1 = head1.next;
                }
                else{
                    if(head1.val < head2.val){
                        ListNode addNode = new ListNode(head1.val);
                        mergedCurr.next = addNode;
                        mergedCurr = mergedCurr.next;                    
                        head1 = head1.next;    
                    }
                    else if(head2.val < head1.val){
                        ListNode addNode = new ListNode(head2.val);
                        mergedCurr.next = addNode;
                        mergedCurr = mergedCurr.next;                    
                        head2 = head2.next;    
                    }
                    else{
                        ListNode addNode = new ListNode(head1.val);
                        mergedCurr.next = addNode;
                        mergedCurr = mergedCurr.next;              

                        addNode = new ListNode(head2.val);
                        mergedCurr.next = addNode;
                        mergedCurr = mergedCurr.next;              

                        head2 = head2.next;    
                        head1 = head1.next;    
                    }
                }
            }
            return mergedHead;
        }
        else if(head1 == null)
        {
            return head2;
        }
        else
        {
            return head1;
        }
    }    
}
