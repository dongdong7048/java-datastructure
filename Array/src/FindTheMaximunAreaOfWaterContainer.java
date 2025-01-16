
public class FindTheMaximunAreaOfWaterContainer {
    /***
     * 尋找最大的容器面積：
     * 說明：
     *  一個有限長度的整數型陣列，要取兩條垂直線，水平線為底(陣列中某兩個元素的紙針距離)，垂直線(某兩個元素取其中較小的值)為高，求出最大的面積
     * 解法思路：
     *  (1) 為陣列設定兩個指針，一個從最左開始，一個從最右開始，往彼此方向移動，直到指針的值一樣則停止
     *  (2) 兩指針每次移動所選中的兩個元素的指針距離(底)以及兩個元素取較小的值(高)的乘積結果一一比較
     *  (3) 左右指針的移動策略，一次循環後，若左指針對應的元素值小於右指針對應的元素值，讓左指針向右移動1步並再次執行從第(1)步，反之則讓右指針向左移動1步並再次執行第(1)步
     *
     * */

    public static void main(String[] args) {
        System.out.println("maxArea is : "+ maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
