package com.hcb.algorithm.chapter2;

public class Sword15$2 {
    public static void main(String[] args) {
        boolean power = false;
        int n = 3;
        power = isPower(n);
        System.out.println(power);
    }
    // 判断一个整数是不是2的整数次方
    private static boolean isPower(int n) {
        return ((n&(n-1))==0);
    }

}
