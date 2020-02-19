package com.hcb.algorithm.chapter2;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Sword3
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
        int temp = 0;
        int i = 0;
        while (i<len){
            if(arr[i] == i){
                i++;
                continue;
            }else if(arr[arr[i]]==arr[i]){
                System.out.println(arr[i]);
                return;
            }else {
               temp = arr[arr[i]];
               arr[arr[i]] = arr[i];
               arr[i] = temp;
            }
        }
        System.out.println("无");
    }
}
