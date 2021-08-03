package com.alibaba.leetcode;

/**
 * FindMedianSortedArrays
 *
 * @author Frank Zhang
 * @date 2021-05-25 8:03 PM
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,5};
        int[] nums2 = {3,4,6};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] mergedNums = new int[totalLength];

        int i = 0; //num1的指针
        int j = 0; //num2的指针
        int t = 0; //mergedNums的指针

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                mergedNums[t++] = nums1[i++];
            }
            else{
                mergedNums[t++] = nums2[j++];
            }
        }
        while (i < nums1.length){ //将num1剩余元素填充进mergedNums中
            mergedNums[t++] = nums1[i++];
        }
        while (j < nums2.length){//将num2剩余元素填充进mergedNums中
            mergedNums[t++] = nums2[j++];
        }

        for(int k=0; k<mergedNums.length; k++){
            System.out.println(mergedNums[k]);
        }

        if (totalLength % 2 == 0) { //偶数
            return (Double.valueOf(mergedNums[totalLength/2]) + Double.valueOf(mergedNums[totalLength/2-1]))/2;
        }
        else {//奇数
            return mergedNums[(totalLength -1)/2];
        }
    }
}
