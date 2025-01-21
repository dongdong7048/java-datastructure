import java.util.Stack;

public class FindValidParentheses {
    /**
     * 字串 s 中的括號是否合法
     * 說明：
     *  字串 s 中的括號「()」，「{}」，「[]」是否有滿足正確的開閉順序，只有單一括號「{」「]」「)」不合法，非正確開閉順序「][」「)(」「}{」不合法
     * 限制：
     *  1. 1 <= s.length <= 104
     *  2. s consists of parentheses only '()[]{}'
     * 思路：
     *  1. 如果 s 長度只有 1，則返回false，反之，創建一個Character型stack
     *  2. 遍歷 s，每一個遍歷單位是char c
     *     (1) 如果 c 為左符號 [ ( {，則壓入 stack
     *     (2) 如果 c 為右符號 ] ) }
     *         i.  如果 stack 中沒有資料，則無法匹配，返回 false
     *         ii. 如果 stack 中有資料，拿 stack 棧頂資料與 c 進行匹配，要能滿足[] () {} 才返回true，否則返回 false
     *  3. 最後 stack 必須為空，否則返回false
     * ***/

    public static boolean isValid(String s) {
        if(s.length() == 1)
            return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatchingPair(char open, char close){
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']') ;
    }

    public static void main(String[] args) {
        boolean valid = isValid("(}{)");
        System.out.println("字串中是否有合法括號符號組 : "+ valid);
    }
}
