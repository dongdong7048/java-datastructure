import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    /**
     * 二元樹的前序遍歷(根節點->左子樹->右子樹)
     * 說明： 將一個以 TreeNode 組成的二元樹 root，利用 Stack 來進行二元樹的前序遍歷，最後返回一個 List<Integer> result 的有序整數集合
     * 限制條件：
     * 1. 根節點總數量落於 0 ~ 100.
     * 2. -100 <= Node.val <= 100
     * 思路：
     * 1. 直接將 root 壓入 stack 中，並且對 stack 中的 root 進行遍歷(while(!stack.isEmpty()))
     *    (1) 取出棧頂元素，此為當前節點
     *    (2) 當前節點值加入result
     *    (3) stack特性為先進後出，因此要先壓入右子樹，才能先處理左子樹：若當前節點的右子樹存在，就將其右子樹壓入棧
     *    (4) 其次，若當前節點的左子樹存在，就將其左子樹壓入棧
     *    (5) 依此邏輯進行遍歷
     * 2. 最後返回 result
     **/

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); //結果
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); //root 直接壓入

        //對 stack 中的 root 進行遍歷
        while (!stack.isEmpty()) {
            //直接彈出棧頂元素，為根節點
            TreeNode current = stack.pop();
            result.add(current.val);

            //先壓入右子樹，確保左子樹可以先處理
            if (current.right != null) {
                stack.push(current.right);
            }

            //後壓入左子樹，確保右子樹最後處理
            if (current.left != null) {
                stack.push(current.left);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(preorderTraversal(root));
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
