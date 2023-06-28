public class Main {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        int counter = 0;
        while(p1.next != null){
            p1 = p1.next;
            if(counter >= n){
                p2 = p2.next;
            }
            counter++;
        }
        if(counter>=n){
            p2.next = p2.next.next;
        }
        else{
            p2 = p2.next;
            return p2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;
        ListNode newNode = removeNthFromEnd(node,1);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}