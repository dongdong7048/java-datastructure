import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RemoveElementArray {

    /***
     * 移除陣列中指定的元素(將元素移至原陣列中非指定元素的後面，不改變整個陣列的長度)
     * 說明： [1,0,2,2,3,5,2,1]，指定移除值為2，經過調整後原陣列調整為[1,0,3,5,1,2,2,2]
     * 思路：
     *  1. 先創建一個索引指針初始值為0，對陣列做遍歷，與指定值不相同的值就依索引指針加入此陣列中，指針自增1
     *  2. 第 1 步完成後，陣列長度扣掉目前指針索引值的值，就是陣列中元素與指定值相同的個數，將這樣的個數以指定值依序賦值到原陣列即可
     *
     * */

    public static void main(String[] args) {
        int i = removeElement(new int[]{1,0,2,2,3,5,2,1}, 2);
        System.out.println("非指定剩餘元素: "+ i);
    }
    public static int removeElement(int[] nums, int val) {
        int writeIndex = 0;
        int remainingCount = 0;
        for(int num: nums){
            if(num != val){
                nums[writeIndex] = num;
                writeIndex++;
                remainingCount++;
            }
        }
        //剩餘的陣列位置以指定值賦值
        while(writeIndex < nums.length){
            nums[writeIndex] = val;
            writeIndex++;
        }

        System.out.println("陣列: "+ Arrays.toString(nums));
        return remainingCount;
    }
}
