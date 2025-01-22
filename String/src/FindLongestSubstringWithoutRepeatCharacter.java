import java.util.HashSet;
import java.util.Set;

public class FindLongestSubstringWithoutRepeatCharacter {
    /***
     * 查找字串中最長的子字串，其中此子字串中每一個字皆不能重複，字串文字包含英文、數字、符號以及空格
     * 思路：
     *  1. 利用動態視窗(最左邊界為左指標left、最右邊界為右指標right)對應當前字串左右邊界，以及HashSet儲存當前動態視窗中不重複的元素
     *  2. 以初始right=0右指標來遍歷字串s，若當前集合中含有s.charAt(right)，從left初始為0自增來移除集合中的s.charAt(left)，保證視窗內元素必唯一
     *  3. 將當前元素加入到集合中
     *  4. 利用maxLength = Math.max(maxLength, right - left + 1)來去獲取每一次遍歷後最大的視窗長度
     *  5. 最後返回maxLength即為字串中最長的不重複子字串
     * */

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> seenCharacters = new HashSet<>();
        int maxLength = 0;
        int left = 0; // 滑動視窗的左指標

        for (int right = 0; right < s.length(); right++) {
            // 如果右指標的字元在集合中，移動左指標以縮小視窗
            while (seenCharacters.contains(s.charAt(right))) {
                seenCharacters.remove(s.charAt(left));
                left++;
            }

            // 將當前字元加入集合
            seenCharacters.add(s.charAt(right));

            // 計算當前視窗的長度，更新最大長度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }


    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("abcabcbb");
        System.out.println("最長子字串長度: "+ i);
    }
}
