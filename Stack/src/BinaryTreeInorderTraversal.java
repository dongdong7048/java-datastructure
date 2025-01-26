import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    /**
     * 二元樹的中序遍歷(左子樹->根節點->右子樹)
     * 說明： 將一個以 TreeNode 組成的二元樹 root，利用 Stack 來進行二元樹的中序遍歷，最後返回一個 List<Integer> result 的有序整數集合
     * 限制條件：
     *  1. 根節點總數量落於 0 ~ 100.
     *  2. -100 <= Node.val <= 100
     * 思路：
     *  1. 對 root 進行遍歷，並將 root 賦值給 current 作為當前二元樹進行操作
     *      (1) 將所有左子節點壓入 stack
     *          i.  當前節點需要先壓入，此為根節點的壓入，先進後出(FILO)的概念，將左子節點計算完後，計算到此根節點
     *          ii. i 壓入後依 current = current.left 進行左子節點的壓入
     *      (2) pop 出 stack 最頂元素，並將其值放入 result , 此即為當時壓入的最左深處的左子節點的值，反覆操作最後一個 pop 出來的元素即為根節點
     *      (3) 左子樹 以及 根節點 已操作完畢，處理右子樹 current = current.right
     *  2. 最後 current 遍歷完畢 (current = null) 及 stack 也已全數 pop (stack.isEmpty)，返回 result 即為此二元樹的中序遍歷
     *
     *
     * **/

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); //結果
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root; //先賦值為current，對current進行處理

        while(current != null || !stack.isEmpty()){
            // 把當前節點和它的所有左子節點壓入堆疊
            while(current !=null){
                stack.push(current); //當前節點壓入，第一次壓入的即為根節點
                current = current.left; //將左子節點賦值給當前節點
            }
            // 彈出堆疊頂部的節點
            current = stack.pop();
            result.add(current.val);

            // 切換至右子樹
            current = current.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(inorderTraversal(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
