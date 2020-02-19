package com.hcb.algorithm.chapter2;

import java.util.Scanner;

/**
 * 每次调用getCount都会遍历全部,但是会指行lgn次getCount,所以时间复杂度是o(nlgn),不是o(pow(n,2))
 *
 */
public class Sword3$2
{
    public static void main( String[] args )
    {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = Integer.parseInt(sc.nextLine());
        String[] strArr = str.split(" ");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        int low = 1;
        int high = len-1;  //7
        int mid = 0;
        int count = 0;

        while(low <= high){
            mid = (high + low)/2;  //4
            count = getCount(arr,low,mid); //1~4
            if(count > mid-low+1){
                // 即同一个数出现大于1次
                if(low == mid){
                    System.out.println(mid);
                    break;
                }
                high = mid;
            }else {
                if(high == mid){
                    System.out.println(mid);
                    break;
                }
                low = mid + 1;
            }
        }

    }

    private static int getCount(int[] arr, int low, int high) {
        int count = 0;
        for (int elem : arr) {
            if (elem >= low && elem <= high) {
                count++;
            }
        }
        return count;
    }
}
