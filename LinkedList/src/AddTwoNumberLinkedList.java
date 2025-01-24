public class AddTwoNumberLinkedList {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carryNum = 0;

        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carryNum; //當前節點的和
            carryNum = sum / 10; //計算進位
            sum = sum % 10; //取個位數

            current.next = new ListNode(sum);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carryNum > 0) {
            current.next = new ListNode(carryNum);
        }
        
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode list1_node3 = new ListNode(3, null);
        ListNode list1_node2 = new ListNode(4, list1_node3);
        ListNode list1 = new ListNode(2, list1_node2);

        ListNode list2_node3 = new ListNode(4, null);
        ListNode list2_node2 = new ListNode(6, list2_node3);
        ListNode list2 = new ListNode(5, list2_node2);

        ListNode result = addTwoNumbers(list1, list2);

        printList(result);

    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
