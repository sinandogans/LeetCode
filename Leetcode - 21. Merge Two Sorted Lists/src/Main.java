import java.util.List;

public class Main {
    public static ListNode recursiveFunc(ListNode list1, ListNode list2) {
        //null check
        if (list1 != null && list2 != null) {
            //choose smaller value of list's first node, then set its next to new recursive call's smaller value and return.
            if (list1.val <= list2.val) {
                list1.next = recursiveFunc(list1.next, list2);
                return list1;
            } else {
                list2.next = recursiveFunc(list2.next, list1);
                return list2;
            }
        }
        // if list2 initially given null, return list1.
        if (list2 == null)
            return list1;
        // in all other cases list2 never gets null, instead list1 gets null.
        return list2;
    }

    public static ListNode iterativeFunc(ListNode list1, ListNode list2) {

        // output
        ListNode list3 = new ListNode();
        ListNode list3Iter = list3;

        while (list1 != null && list2 != null){
            // if list1's value smaller, add list1's node to list3, iterate both.
            if (list1.val < list2.val){
                list3Iter.next = list1;
                list1 = list1.next;
                list3Iter = list3Iter.next;
            }
            // if list2's value smaller or equal, add list2's node to list3, iterate both.
            else {
                list3Iter.next = list2;
                list2 = list2.next;
                list3Iter = list3Iter.next;
            }
        }
        // check which list is finished first, add remaining node's of not null list to list3.
        if (list1 == null){
            list3Iter.next = list2;
        }
        else{
            list3Iter.next = list1;
        }
        //trim list3's redundant head node.
        return list3.next;
    }

    public static void main(String[] args) {
        //inputs
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(8);

        ListNode list2 = new ListNode(3);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(9);

        //output
        ListNode list3 = recursiveFunc(list1, list2);
        //ListNode list4 = iterativeFunc(list1, list2);
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}