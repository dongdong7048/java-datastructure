public class FindFirstSubstring {
    /**
     * 獲取目標字串在原始字串中出現的第一個索引位置
     * 說明：
     *    目標字串needle，原始字串haystack，查找needle在haystack中第一個出現的索引位置
     * **/

    public static int strStr(String haystack, String needle) {
        if(haystack.length() == 1 && needle.length() < 1)
            return -1;
        return haystack.indexOf(needle, 0);
    }

    public static void main(String[] args) {
        int index = strStr("", "b");
        System.out.println("substring apppear index: " + index);
    }
}
