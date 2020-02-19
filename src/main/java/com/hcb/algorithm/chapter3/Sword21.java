package com.hcb.algorithm.chapter3;

import java.util.Arrays;

public class Sword21 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(arr));
//        transArr(arr);
        transArr2(arr);
//        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));

    }
// 剑指offer书上的
    private static void transArr2(int[] arr) {
        int preIndex = 0;
        int postIndex = arr.length-1;
        int temp;
        while(preIndex < postIndex){
            while(preIndex < postIndex && arr[preIndex]%2 == 1){
                preIndex++;
            }
            while(preIndex < postIndex && arr[postIndex]%2 == 0){
                postIndex--;
            }
            if(preIndex < postIndex){
                temp = arr[preIndex];
                arr[preIndex] = arr[postIndex];
                arr[postIndex] = temp;
            }
        }
    }

// my method
    private static void transArr(int[] arr) {
        int preIndex = 0;
        int postIndex = arr.length-1;
        int tailValue = arr[arr.length-1];
        while(preIndex < postIndex){
            while(preIndex < postIndex && arr[preIndex]%2 == 1){
                preIndex++;
            }
            if(preIndex < postIndex){
                arr[postIndex] = arr[preIndex];
            }
            while(preIndex < postIndex && arr[postIndex]%2 == 0){
                postIndex--;
            }
            if(preIndex < postIndex){
                arr[preIndex] = arr[postIndex];
            }
        }
        arr[postIndex] = tailValue;
    }





    // 保证稳定性,但需要o(n)的空间复杂度
    public static void reOrderArray(int[] nums) {
        // 奇数个数
        int oddCnt = 0;
        for (int val : nums)
            if (val % 2 == 1)
                oddCnt++;
        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1)
                nums[i++] = num;
            else
                nums[j++] = num;
        }
    }

}
