package com.hcb.algorithm.chapter2;

import java.util.Scanner;

/**
 * 斐波那契数列指的是这样一个数列 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233，377，610，987，1597，2584，4181，6765，10946，17711，28657，46368........
 */
public class Sword10 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = fibonacci(n);
        System.out.println(result);
        int result2 = fibonacci2(n);
        System.out.println(result2);
        int result3 = fibonacci3(n);
        System.out.println(result3);
    }

    private static int fibonacci3(int n) {
        int[][] fiboMatx = new int[][]{{1,1},{1,0}};
        int[][] resMatx = matxPow(fiboMatx,n-1);
        return resMatx[0][0];
    }
    private static  int[][] matxMul(int[][] matx1,int[][] matx2){
        int[][] res = new int[2][2];
        res[0][0] = matx1[0][0]*matx2[0][0] + matx1[0][1]*matx2[1][0];
        res[0][1] = matx1[0][0]*matx2[0][1] + matx1[0][1]*matx2[1][1];
        res[1][0] = matx1[1][0]*matx2[0][0] + matx1[1][1]*matx2[1][0];
        res[1][1] = matx1[1][0]*matx2[0][1] + matx1[1][1]*matx2[1][1];
        return res;
    }
    private static int[][] matxPow(int[][] matx,int n){
        if(n==1){
            return matx;
        }else {
            int[][] arr = matxPow(matx,n/2);
            if(n%2 == 0){
                return matxMul(arr,arr);
            }else {
                return matxMul(matxMul(arr,arr),matx);
            }
        }

    }




    private static int fibonacci2(int n) throws Exception {
        int prePreValue = 0;
        int preValue = 1;
        int result = 0;
        if(n<0){
            throw new Exception("n can not lower than 0");
        }else {
            if(n == 0){
                return  prePreValue;
            }else if(n==1){
                return preValue;
            }else {
                for (int i = 2; i <=n ; i++) {
                    result = preValue+prePreValue;
                    prePreValue = preValue;
                    preValue = result;
                }
                return result;
            }
        }
    }

    private static int fibonacci(int n) throws Exception {
        if(n<0){
            throw new Exception("n can not lower than 0");
        }else {
            if(n == 0){
                return  0;
            }else if(n==1){
                return 1;
            }else {
                return fibonacci(n-1)+fibonacci(n-2);
            }
        }
    }
}
