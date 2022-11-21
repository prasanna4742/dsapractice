public class AddTwoLL {
    static long aLong = 0;
    public static void main(String[] args) {
        ListNode list1 = new ListNode(9);

        ListNode list2 = new ListNode(1);
        ListNode list21 = new ListNode(9);
        ListNode list22 = new ListNode(9);
        ListNode list23 = new ListNode(9);
        ListNode list24 = new ListNode(9);
        ListNode list25 = new ListNode(9);
        ListNode list26 = new ListNode(9);
        ListNode list27 = new ListNode(9);
        ListNode list28 = new ListNode(9);
        ListNode list29 = new ListNode(9);

        list2.next=list21;
        list21.next=list22;list22.next=list23;list23.next=list24;list24.next=list25;
        list25.next=list26;list26.next=list27;list27.next=list28;list28.next=list29;
        
        ListNode mergedHead = addTwoNumbers(list1, list2);
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num2 = findNumber(l2, 1);
        long num1 = findNumber(l1, 1);
        System.out.println(num1);
        System.out.println(num2);

        char c1 = '0';
        int a = c1-48;
        System.out.println(a);

        ListNode head = new ListNode();
        ListNode curr = head;
        String sum = String.valueOf(num1+num2);
                
        char[] origArr = sum.toCharArray();
        char[] charArr = new char[origArr.length];
        for(int i=0; i<origArr.length; i++)
        {
            charArr[origArr.length-1-i]=origArr[i];
        }


        for(int i=0; i<charArr.length-1; i++)
        {
            curr.val = charArr[i]-48;
            curr.next = new ListNode();
            curr = curr.next;
        }

        curr.val = charArr[charArr.length-1]-48;

        return head;
    }

    private static long findNumber(ListNode l1, long i) {
        if(l1.next == null){
            if(l1.val == 0)
            {
                return i;    
            }
            return l1.val*i;
        }
        if(l1.val == 0)
        {
            return i+findNumber(l1.next, i*10);        
        }
        
        return l1.val*i+findNumber(l1.next, i*10);    
    }    
}