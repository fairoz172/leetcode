package linkedlist;

import java.util.Arrays;
import java.util.List;

public class MergeKSortedList {

    public static ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsHelper(lists);
    }

    public static ListNode mergeKListsHelper(ListNode[] lists){
         if(lists == null || lists.length == 0){
            return null;
        }else if (lists.length == 1){
            return lists[0];
        }
        if(lists.length > 2){
            int middle = lists.length / 2;
            ListNode[] leftList = Arrays.copyOfRange(lists, 0, middle );
            ListNode[] rightList = Arrays.copyOfRange(lists, middle , lists.length) ;
            ListNode list1 = mergeKListsHelper(leftList);
            ListNode list2 = mergeKListsHelper(rightList);
            return mergeKListsHelper(new ListNode[]{list1, list2});
        }else{
            ListNode list1 = lists[0];
            ListNode list2 = lists[1];

            ListNode merged = new ListNode(1111);

            ListNode head = merged;
            int val = 0;
            while ( list1!= null && list2 != null){
                if (list1.val < list2.val){
                    val = list1.val;
                    list1 = list1.next;
                }else {
                    val = list2.val;
                    list2 = list2.next;
                }
                merged.next = new ListNode(val);
                merged = merged.next;
            }
            while ( list1!= null ){
                merged.next = new ListNode(list1.val);
                list1 = list1.next;
                merged = merged.next;
            }
            while ( list2!= null ){
                merged.next = new ListNode(list2.val);
                list2 = list2.next;
                merged = merged.next;
            }
            return head.next;
        }
    }

    public static void main(String[] args) {
        ListNode firstList = new ListNode(1);
        firstList.next = new ListNode(4);
        firstList.next.next = new ListNode(5);

        ListNode secondList = new ListNode(1);
        secondList.next = new ListNode(3);
        secondList.next.next = new ListNode(4);

        ListNode thirdList = new ListNode(2);
        thirdList.next = new ListNode(6);

        ListNode fourthList = new ListNode(-1);
        fourthList.next = new ListNode(4);
        fourthList.next.next = new ListNode(8);

        ListNode[] lists = new ListNode[3];
        lists[0] = firstList;
        lists[1] = null;
        lists[2] = thirdList;
//        lists[3] = fourthList;
        ListNode mergedListNode = mergeKLists(lists);
        while (mergedListNode != null){
            System.out.print(mergedListNode.val + " --> ");
            mergedListNode = mergedListNode.next;
        }
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}