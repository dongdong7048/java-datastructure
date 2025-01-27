import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    /**
     * 二元樹的後序遍歷(左子樹->右子樹->根節點)
     * 說明： 將一個以 TreeNode 組成的二元樹 root，利用 Stack 來進行二元樹的後序遍歷，最後返回一個 List<Integer> result 的有序整數集合
     * 限制條件：
     * 1. 根節點總數量落於 0 ~ 100.
     * 2. -100 <= Node.val <= 100
     *
     **/

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>(); // 模擬後序遍歷的反轉過程
        stack.push(root);

        while (!stack.isEmpty()) {
            // 彈出當前節點，壓入輸出堆疊
            TreeNode current = stack.pop();
            output.push(current);

            // 先壓入左子節點，再壓入右子節點（最後會反轉為左 -> 右 -> 根）
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        // 將輸出堆疊中的元素彈出並加入結果
        while (!output.isEmpty()) {
            result.add(output.pop().val);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(postorderTraversal(root));
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
