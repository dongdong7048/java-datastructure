public class FindLongestPrefixString {
    /**
     * 查找String array中共同的前綴字串
     * 說明： 在一個String型陣列中，查找出共同的前綴字串，要求是所有元素都要有，若有其一元素沒有，則返回空字串，若只有單一元素，則返回其元素
     *
     * **/


    public static void main(String[] args) {
        String commonPrefix = longestCommonPrefix(new String[]{"aba","c","b","a","ab"});
        System.out.println("commonString is : "+ commonPrefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];

        String resultStr = "";
        int count = 0 ;
        int left = 0;
        int right = strs.length - 1;
        while(left <= right){
            String tempStr = findCommonPrefix(strs[left], strs[right]);
            if(count == 0){
                resultStr = tempStr;
                count++;
            }
            left++;
            right--;
            resultStr = findCommonPrefix(resultStr, tempStr);
            if(resultStr.isBlank()){
                break;
            }
        }

        return resultStr;
    }

    public static String findCommonPrefix(String str1, String str2){
        int maxLength = Math.min(str1.length(), str2.length());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i< maxLength ; i++){
            if(str1.charAt(i) == str2.charAt(i)){
                sb.append(str1.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }
}
