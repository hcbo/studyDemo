package com.hcb.algorithm.chapter2;

/**
 * 一句代码打印数组
 * 有重复数字也可以
 */

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,2,3,8,10,5,9};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr,int startIndex,int endIndex) {
        if(startIndex>=endIndex){
            return;
        }
        int refValue = arr[startIndex];
        int lPos = startIndex;
        int rPos = endIndex;
        while(lPos < rPos){
            while(lPos<rPos){
                if(arr[rPos]<refValue){
                    arr[lPos]=arr[rPos];
                    break;
                }else {
                    rPos--;
                }
            }
            while(lPos<rPos){
                if(arr[lPos]>refValue){
                    arr[rPos] = arr[lPos];
                    break;
                }else {
                    lPos++;
                }
            }
        }
        arr[lPos]=refValue;
        quickSort(arr,startIndex,lPos-1);
        quickSort(arr,lPos+1,endIndex);
    }
}

