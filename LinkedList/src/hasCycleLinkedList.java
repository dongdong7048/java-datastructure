public class hasCycleLinkedList {

    /***
     * 檢驗鏈表是否有環(Cycle)的存在
     * 說明： 給定一個鏈表 head 及一個 pos 整數值，pos為最後一個鏈表節點的next指向此鏈表的第幾個節點，依此檢驗這個鏈表是否有環
     * 限制：
     *  1. 鏈表長度[0, 10^4]
     *  2. -10^5 <= Node.val <= 10^5
     *  3. pos is -1 or a valid index in the linked-list.
     * 思路：
     *  要檢測鏈表是否有環，可以使用快慢指針法（Floyd's Cycle Detection Algorithm），核心邏輯如下：
     *  設定兩個指針：
     *  slow 指針每次走一步。
     *  fast 指針每次走兩步。
     *  如果鏈表中有環，fast 和 slow 最終會相遇（因為它們會在環中不斷循環）。
     *  如果鏈表中沒有環，fast 最終會到達 null，結束遍歷。
     *  
     *
     */


    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { this.val = val; this.next = null; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        boolean hasCycle = hasCycle(head);

        System.out.println("鏈表是否有環: "+ hasCycle);

    }




}
