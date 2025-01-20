import java.util.Arrays;

public class FindFirstAndLastPositonElementArray {
    /***
     * 尋找陣列中第一個和最後一個含有指定元素值的指針位置
     *
     * */

    public static void main(String[] args) {
        int[] targetArray = searchRange(new int[]{1,3}, 1);
        System.out.println("targetArray: " + Arrays.toString(targetArray));

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] targetArray = new int[]{-1, -1};
        int firstPositon = -1;
        int lastPosition = -1;
        boolean firstPositionIsCounted = false;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == target){
                if(!firstPositionIsCounted){
                    firstPositon = i;
                    firstPositionIsCounted = true;
                }else{
                    lastPosition = i;
                }
                if(nums.length == 1  && nums[i] == target){
                    firstPositon = i;
                    lastPosition = i;
                }
            }
        }

        targetArray[0] = firstPositon;
        targetArray[1] = lastPosition;

        if(firstPositon != -1 && lastPosition == -1){
            targetArray[1] = firstPositon;
        }
        return targetArray;
    }
}
