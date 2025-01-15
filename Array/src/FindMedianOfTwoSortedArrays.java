public class FindMedianOfTwoSortedArrays {
    public static void main(String[] args) {
        double median = findMedianSortedArrays(new int[]{1,3,5,5}, new int[]{2,3,6,8,9});
        System.out.println("the Median is: " + median);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 解法思路:
         * 1. 合併兩者陣列為int[] arr 的長度 L，
         *    (1) 若 L 為奇數，則 median =  (double)arr[(L-1)/2]
         *    (2) 若 L 為偶數，則 median = ( (double)arr[(L/2)-1] + (double)arr[L/2] ) / 2

         * 2. 創建兩個初始值為 0 的整數型指針 i、j 以及一個長度為 L 的 mergeArray，nums1資料長度為 m、nums2資料長度為 n
         *    (1) 循環執行，滿足條件為 i 的值小於 m 以及 j 的值小於 n，進行nums1[i]以及nums2[j]的比較
         *        1) 若 nums1[i] <= nums2[j]，就將 nums1[i] 的值賦予 mergeArray[k]，然後 i 與 k 自增
         *        2) 若 nums1[i] > nums2[j]，就將 nums2[j] 的值賦予 mergeArray[k]，然後 j 與 k 自增
         *    (2) 在(1)執行完後，可能還會有剩下未比較完的資料(資料長度較大者會有剩餘)，有可能是 nums1，也可能是nums2，因此此時繼續再次循環執行：
         *        1) 循環執行，滿足條件為 i 的值小於 m，nums1[i] 的值賦予 mergeArray[k]，然後 i 與 k 自增
         *        2) 循環執行，滿足條件為 j 的值小於 n，nums2[j] 的值賦予 mergeArray[k]，然後 j 與 k 自增
         *    (3) 此時 mergeArray中為已排序(由小到大)完成且長度為 L 的陣列，利用思路 1 來返回陣列的中位數即可
         *
         * **/
        int m = nums1.length;
        int n = nums2.length;
        int mergeArr[] = new int[m+n];
        int i = 0;
        int j = 0;
        int L = 0;
        while(i<m && j<n){
            if(nums1[i] <= nums2[j]){
                mergeArr[L++] = nums1[i++];
            }else if( nums1[i] > nums2[j]) {
                mergeArr[L++] = nums2[j++];
            }
        }

        while(i < m){
            mergeArr[L++] = nums1[i++];
        }

        while(j < n){
            mergeArr[L++] = nums2[j++];
        }

        if(L % 2 == 0){
            return (( (double)(mergeArr[(L/2)-1]) + (double)(mergeArr[L/2]) ) / 2);
        }else {
            return (double)(mergeArr[(L-1)/2]);
        }
    }
}
