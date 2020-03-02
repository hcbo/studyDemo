package com.hcb.algorithm.chapter6;

public class Sword64 {



    public static int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
