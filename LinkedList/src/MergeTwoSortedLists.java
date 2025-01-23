public class MergeTwoSortedLists {
    /***
     * 將兩個已排序過的鍊表合併成一個排序過的鍊表
     * 思路：
     * 1. 先創建一個虛擬頭節點dummy，值可以任意取，也創建一個當前節點current，將dummy賦予給current
     * 2. 遍歷兩個鍊表list1、list2
     *    1) 兩個鍊表都不為null時，進行當前list1、list2節點值比較：
     *       1) 若list1的值小於list2的值，就將當前list1賦予到current.next，並讓 list1 往下一個節點走 list1 = list1.next
     *       2) 若list1的值大於list2的值，就將當前list2賦予到current.next，並讓 list2 往下一個節點走 list2 = list2.next
     *       3) 迴圈進行比較直到list1為null或list2為null
     *    2) 若兩個鍊表其一為null，則將另一鍊表直接賦予給current
     * 3. 最後，將 dummy 的下一個節點返回，即所求的兩個有序鍊表合併為一有序鍊表
     *
     * **/

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 建立一個虛擬頭節點，方便處理
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // 遍歷兩個鏈表，依次比較節點值
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 將剩下的鏈表接到結果鏈表的尾部
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        // 返回新鏈表的頭部
        return dummy.next;
    }

    // 自定義的ListNode
    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 進行測試
    public static void main(String[] args) {
        ListNode list1_node3 = new ListNode(4, null);
        ListNode list1_node2 = new ListNode(2, list1_node3);
        ListNode list1 = new ListNode(1, list1_node2);

        ListNode list2_node3 = new ListNode(4, null);
        ListNode list2_node2 = new ListNode(3, list2_node3);
        ListNode list2 = new ListNode(1, list2_node2);

        ListNode result = mergeTwoLists(list1, list2);

        printList(result);

    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
