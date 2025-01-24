public class ReverseLinkedList {
    /**
     * 反轉鍊表
     * 說明：
     *  將一個鍊表(可能為null) head中的所有節點進行反轉，使此鍊表成為一個反轉鍊表
     * 思路：
     *  1. 定義一個 current 鍊表，將 head 賦值給它，作用是操作 current 而不動到原本的 head
     *  2. 對 current 進行遍歷，將 current 的 next 節點放入 臨時鍊表 nextTemp，要作為每次迴圈最後返回賦值給 current，做下一次迴圈的使用
     *  2. 讓 current 的 next 節點為 reverse (一開始需創建一個 reverse 鍊表初始為 null)
     *  3. 將 current 賦值給目標鍊表 reverse，此時 reverse 擁有目前 current 的鍊表狀態
     *  4. 將臨時鍊表 nextTemp 賦值為 current，以進行下一輪的迴圈
     *  5. 迴圈結束後，reverse 即為反轉 head 的鍊表
     *
     * **/


    public static ListNode reverseList(ListNode head) {
        ListNode reverse = null; // 反轉鍊表
        ListNode current = head; // 不更動head

        while (current != null) {
            ListNode nextTemp = current.next; // 臨時鍊表，先放入current的next節點，最後要再賦值給current做下次迴圈
            current.next = reverse; // 先將reverse(初始null)接在current的next節點，此時第一步current鍊表只有頭節點存在
            reverse = current; //將current的狀態賦給reverse
            current = nextTemp;
        }

        return reverse;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode list1_node5 = new ListNode(5, null);
        ListNode list1_node4 = new ListNode(4, list1_node5);
        ListNode list1_node3 = new ListNode(3, list1_node4);
        ListNode list1_node2 = new ListNode(2, list1_node3);
        ListNode list1 = new ListNode(1, list1_node2);



        ListNode result = reverseList(list1);

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
