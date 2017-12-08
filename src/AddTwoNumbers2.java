public class AddTwoNumbers2 {

    public static void main(String[] args) {

        AddTwoNumbers2 solution = new AddTwoNumbers2();
        /*ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);*/

        ListNode l1 = new ListNode(7);


        ListNode l2 = new ListNode(5);

        ListNode result = solution.addTwoNumbers(l1, l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNodeHead = null;
        ListNode node = new ListNode(0);
        resultNodeHead = node;
        Integer remainder = null;
        while(l1 != null && l2 != null)
        {
            int sum = l1.val + l2.val;

            if(remainder != null){
                sum = sum + remainder;
                remainder = null;
            }

            if (sum > 9){
                remainder = sum / 10;
                node.next = new ListNode(sum % 10);
            }else{
                node.next = new ListNode(sum );
            }
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 == null && l2 != null){
            while(l2!= null){
                int sum = l2.val;

                if(remainder != null){
                    sum = sum + remainder;
                    remainder = null;
                }

                if (sum > 9){
                    remainder = sum / 10;
                    node.next = new ListNode(sum % 10);
                }else{
                    node.next = new ListNode(sum );
                }
                node = node.next;
                l2 = l2.next;
            }
        }else if (l1 != null && l2 == null){
            while(l1!= null){
                int sum = l1.val;

                if(remainder != null){
                    sum = sum + remainder;
                    remainder = null;
                }

                if (sum > 9){
                    remainder = sum / 10;
                    node.next = new ListNode(sum % 10);
                }else{
                    node.next = new ListNode(sum );
                }
                node = node.next;
                l1 = l1.next;
            }
        }

        if(remainder != null){
            node.next = new ListNode(remainder);
        }
        return resultNodeHead.next;
    }
}
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
