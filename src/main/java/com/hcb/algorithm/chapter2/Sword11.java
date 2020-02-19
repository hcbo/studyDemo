package com.hcb.algorithm.chapter2;

/**
 * o(lgn)
 */

public class Sword11 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,0,1,2,3};
        int min = findMin(arr,0,arr.length-1);
        System.out.println(min);
        int[] arr2 = new int[]{0,1,2,3,4,5,6};
        int min2 = findMin(arr2,0,arr.length-1);
        System.out.println(min2);

        int[] arr3 = new int[]{1,0,1,1,1};
        int min3 = findMin2(arr3,0,arr.length-1);
        System.out.println(min3);
        int[] arr4 = new int[]{1,1,1,0,1};
        int min4 = findMin2(arr4,0,arr.length-1);
        System.out.println(min4);

    }
    // 适用于非递减
    private static int findMin2(int[] arr, int start, int end) {
        if(start == end){
            return arr[start];
        }else if(start+1 == end){
            return arr[start]<arr[end]?arr[start]:arr[end];
        }else {
            int mid = (end+start)/2;
            if(arr[mid]==arr[start] && arr[mid]==arr[end]){
                return findInOrder(arr,start,end);
            }else {
                if(arr[mid]<arr[mid+1] && arr[mid]<arr[mid-1]){
                    return arr[mid];
                }else if(arr[mid]>arr[end]){
                    return findMin(arr,mid+1,end);
                }else {
                    return findMin(arr,start,mid-1);
                }
            }

        }
    }

    private static int findInOrder(int[] arr, int start, int end) {
        int min = arr[start];
        for (int i = start+1; i <=end; i++) {
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }

    // 只适用于递增
    private static int findMin(int[] arr, int start, int end) {
        if(start == end){
            return arr[start];
        }else if(start+1 == end){
            return arr[start]<arr[end]?arr[start]:arr[end];
        }else {
            int mid = (end+start)/2;
            if(arr[mid]<arr[mid+1] && arr[mid]<arr[mid-1]){
                return arr[mid];
            }else if(arr[mid]>arr[end]){
                return findMin(arr,mid+1,end);
            }else {
                return findMin(arr,start,mid-1);
            }
        }
    }




}
