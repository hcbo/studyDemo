package com.hcb.algorithm.chapter4;

import com.hcb.algorithm.chapter2.BiTree;

public class Sword33 {
    public static void main(String[] args) {
        int[] seq = {5,7,6,9,11,10,8};
//        int[] seq = {7,4,5,6};
        boolean flag = isPostOrder(seq,0,seq.length-1);
        System.out.println(flag);
    }

    private static boolean isPostOrder(int[] seq, int start, int end) {
        if(start >= end){
            return true;
        }
        // 中轴点
        int mid = -1;
        boolean largerFlag = false;
        //判断序列是否满足左半部分小于根,有半部分大于根
        for (int i = start; i < end ; i++) {
            if(seq[i] > seq[end] && largerFlag == false){
                mid = i;
                largerFlag = true;
            }
            // 大的序列中出现小于根节点,则不符合
            if(largerFlag && seq[i] < seq[end]){
                return false;
            }
        }
        if(mid == -1){
            mid = end;
        }
        return isPostOrder(seq,start,mid-1)&&
                isPostOrder(seq,mid,end-1);


    }
}
