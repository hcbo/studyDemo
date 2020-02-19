package com.hcb.algorithm.others;

import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len =Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        String[] str_arr = str.split(" ");
        int [] arr = new int[str_arr.length];
        for (int i = 0; i < str_arr.length ; i++) {
            arr[i] = Integer.parseInt(str_arr[i]);
        }
        long max = getMaxMulti(arr);
        System.out.println(max);

    }

    private static long getMaxMulti(int[] arr) {
        boolean zeroFlag = false;
        boolean posFlag = false;
        // 三个元素按递增排列
        int[] po3 = {0,0,0}; //(1) 正
        int[] po1ne2 = {0,0,0}; //(3) 正
        int[] ne3 = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE}; // (4) 负
        if(arr.length == 3){
            return (long)arr[0]*(long)arr[1]*(long)arr[2];
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                zeroFlag = true;
            }
            else if(arr[i] > 0){
                posFlag = true;
                // (2)(4)不考虑

                //(1)
                if(arr[i]>po3[2]){
                    po3[0] = po3[1];
                    po3[1] = po3[2];
                    po3[2] = arr[i];
                }else if(arr[i]>po3[1]){
                    po3[0] = po3[1];
                    po3[1] = arr[i];
                }else if(arr[i]>po3[0]){
                    po3[0] = arr[i];
                }

                //(3)
                if(arr[i] > po1ne2[2]){
                    po1ne2[2] = arr[i];
                }

            }else {


                // (3) 两个负的越小越好
                if(arr[i]< po1ne2[1]){
                    if(arr[i]<po1ne2[0]){
                        po1ne2[1] = po1ne2[0];
                        po1ne2[0] = arr[i];
                    }else {
                        po1ne2[1] = arr[i];
                    }
                }

                // (4) 三个负的越大越好

                if(arr[i]>ne3[2]){
                    ne3[0] = ne3[1];
                    ne3[1] = ne3[2];
                    ne3[2] = arr[i];
                }else if(arr[i]>ne3[1]){
                    ne3[0] = ne3[1];
                    ne3[1] = arr[i];
                }else if(arr[i] > ne3[0]){
                    ne3[0] = arr[i];
                }

            }
        }


        if(posFlag){
            return Math.max((long)(po3[0]*(long)po3[1]*(long)po3[2]),((long)po1ne2[0]*(long)po1ne2[1]*(long)po1ne2[2]));
        }else if(zeroFlag){
            return 0;
        }else {
            return (long)ne3[0]*(long)ne3[1]*(long)ne3[2];
        }

    }
}
