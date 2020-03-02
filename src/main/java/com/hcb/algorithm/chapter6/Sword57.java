package com.hcb.algorithm.chapter6;

import java.util.HashSet;

public class Sword57 {
    public static void main(String[] args) {
//        getNumInSum(new int[]{1,2,4,7,11,15},11);
        getNumInSumHash(new int[]{1,2,4,7,11,15},11);
    }

    private static void getNumInSumHash(int[] arr, int sum) {
        HashSet<Integer> hs = new HashSet<>();
        for (int elem:
            arr ) {
            if(hs.contains(sum-elem)){
                System.out.println(sum-elem + " " + elem);
                return;
            }
            hs.add(elem);
        }
    }

    private static void getNumInSum(int[] arr,int sum) {
        //arr[left]维持 可能成为结果值中的最小值
        // arr[right]维持 可能成为结果值中的最大值
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            if(arr[left]+arr[right] == sum){
                System.out.println(arr[left]+" "+arr[right]);
                return;
            }else if(arr[left]+arr[right] > sum){
                // arr[right]与当前最小值的和都大于sum,那么arr[right]与其他值的和更大于sum,所以将
                //arr[right]排除.
                right--;
            } else {
                // arr[left]与当前最大值的和都小于sum,那么arr[left]与其他值的和更小于sum,所以将
                //arr[left]排除.
                left++;
            }
        }
    }
}
