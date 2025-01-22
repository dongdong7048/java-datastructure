public class FindLengthOfLastWordString {
    /**
     * 查找字串中最後一組文字(字串中僅有英文文字與空格)
     *
     * */

    public static int lengthOfLastWord(String s) {
        //分兩種情境處理，1. 字串最後是空格  2. 字串最後無空格
        boolean lastWordIsSpace = Character.isSpaceChar(s.charAt(s.length() - 1));
        if (lastWordIsSpace) {
            //1. 字串最後是空格
            int meetSpacesCount = 0;
            StringBuilder reverseString = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                boolean isSpace = Character.isSpaceChar(s.charAt(i));
                if (!isSpace && meetSpacesCount == 0) {
                    meetSpacesCount = 1;
                }
                if (meetSpacesCount == 1) {
                    if (Character.isLetter(s.charAt(i))) {
                        reverseString.append(s.charAt(i));
                    } else {
                        break;
                    }
                }
            }

            //System.out.println(reverseString.reverse());
            return reverseString.length();
        } else {
            // 2.字串最後無空格(文字)
            int lastWordIndex = 0;
            for (int j = s.length() - 1; j >= 0; j--) {
                boolean isSpace = Character.isSpaceChar(s.charAt(j));
                if (isSpace) {
                    lastWordIndex = j + 1;
                    break;
                }
            }
            String lastWord = s.substring(lastWordIndex, s.length());
            //System.out.println(lastWord);
            return lastWord.length();
        }
    }

    public static void main(String[] args) {
        int i = lengthOfLastWord("   fly me   to   the moon");
        System.out.println("lastWordLength: "+i);
    }
}
