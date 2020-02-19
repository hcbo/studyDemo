package com.hcb.algorithm.chapter4;

import java.util.Arrays;

public class Sword39 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        int result = moreThanHalfNum(arr);
        System.out.println(result);
        quikSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quikSort(int[] arr,int start,int end){
        if(start == end){
            return;
        }
        int index = partition(arr,start,end);
        if(index > start){
            quikSort(arr,start,index-1);
        }
        if(index < end){
            quikSort(arr,index+1,end);
        }
    }

    private static int moreThanHalfNum(int[] arr) {
        int middle = arr.length >>1;
        int start = 0;
        int end = arr.length-1;
        int index = partition(arr,start,end);
        while(index != middle){
            if(index > middle){
                index = partition(arr,start,index-1);
            }else {
                index = partition(arr,index+1,end);
            }
        }
        return arr[middle];
    }

    private static int partition(int[] arr, int start, int end) {
        int index = start + (int)(Math.random() * (end-start));
        swap(arr,index,end);
        int small = start-1;
        for(index = start;index<end;++index){
            if(arr[index]<arr[end]){
                ++small;
                if(small != index){
                    swap(arr,index,small);
                }
            }
        }
        ++small;
        swap(arr,small,end);
        return small;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
