public class Main {

    public static ListNode swapPairs(ListNode head) {
        // head is null case
        if (head == null)
            return null;
        var newHead = head;
        var iterNode = head;
        var previousNodeOfIterNode = head;

        // swap first two node
        if (iterNode.next != null) {
            var temp = iterNode.next;
            iterNode.next = temp.next;
            temp.next = iterNode;
            newHead = temp;
        }
        // swap others
        iterNode = iterNode.next;
        while (iterNode != null && iterNode.next != null) {
            var temp = iterNode.next;
            iterNode.next = temp.next;
            previousNodeOfIterNode.next = temp;
            temp.next = iterNode;

            previousNodeOfIterNode = iterNode;
            iterNode = iterNode.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        var node7 = new ListNode(2, null);
        var node6 = new ListNode(2, node7);
        var node5 = new ListNode(6, node6);
        var node4 = new ListNode(4, node5);
        var node3 = new ListNode(3, node4);
        var node2 = new ListNode(5, node3);
        var node1 = new ListNode(2, node2);

//        var node2 = new ListNode(2, null);
//        var node1 = new ListNode(1, node2);

//        var node1 = new ListNode(1, null);

        var newhead = swapPairs(node1);
        System.out.println();
    }
}

class ListNode {
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