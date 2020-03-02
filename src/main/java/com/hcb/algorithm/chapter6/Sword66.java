package com.hcb.algorithm.chapter6;

public class Sword66 {

    public static void main(String[] args) {
        int[] answer = multiply(new int[]{1,2,3,4,5});
    }

    public static int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; i++){
            /* 从左往右累乘 */
            B[i] = product;
            product *= A[i];
        }



        for (int i = n - 1, product = 1; i >= 0;  i--){
            /* 从右往左累乘 */
            B[i] *= product;
            product *= A[i];
        }

        return B;
    }
}
