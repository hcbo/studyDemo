package com.hcb.algorithm.chapter2;


public class Sword14 {
    public static void main(String[] args) {
        int n = 5;
        int maxMul = new Sword14().getMaxMul(n).aterCutRes;
        System.out.println(maxMul);

        int maxMul2 = new Sword14().getMaxMul2(n);
        System.out.println(maxMul2);

        int maxMul3 = new Sword14().getMaxMul3(n);
        System.out.println(maxMul3);
    }

    // 贪心
    private int getMaxMul3(int n) {
        if(n==1){
            return 0;
        }else if(n==2){
            return 1;
        }else if(n==3){
            return 2;
        }else {
            int times = n/3;
            if(n%3 == 0){
                return (int) Math.pow(3,times);
            }else if(n%3 == 1){
                return (int)Math.pow(3,times-1) *2*2;
            }else {
                return (int)Math.pow(3,times)*2;
            }
        }
    }

    // 递归的方法适合分析,因为它是自上而下,而计算适合自下而上,因为这样可以减少重复计算,前提是o(n)的空间代价
    private int getMaxMul2(int n) {
        // 为方便,从角标1开始存
        int[] afterCut = new int[n+1];
        afterCut[1] = 0;
        int max =0;
        int temp = 0;
        for (int i = 2; i <=n ; i++) {
            max = 0;
            for (int j = 1; j <=i/2; j++) {
                temp = Math.max(afterCut[j],j) * Math.max(afterCut[i-j],i-j);
                if(temp > max){
                    max =temp;
                }
            }
            afterCut[i] = max;
        }
        return afterCut[n];
    }


    // 递归的方法,但是涉及大量的重复计算,时间复杂度为指数级别,因为每进入递归函数一次,就要for循环一次
    // 递归的方法适合分析,因为它是自上而下,而计算适合自下而上,因为这样可以减少重复计算
    private Result getMaxMul(int n) {
        Result result = new Result();
        result.selfValue = n;
        //两种情况,如果割,最大乘积结果为aferCutRes
        int afterCutRes = 0;
        if(n ==1){
            afterCutRes = 0;
        }
        //从下标1开始存
        int[] subMax = new int[(n/2)+1];

        for (int i = 1; i <subMax.length; i++) {
            Result res1 = getMaxMul(i);
            Result res2 = getMaxMul(n-i);
            subMax[i] = Math.max(res1.aterCutRes,res1.selfValue)*
                    Math.max(res2.aterCutRes,res2.selfValue);
            if(subMax[i]>afterCutRes){
                afterCutRes = subMax[i];
            }
        }

        result.aterCutRes = afterCutRes;
        return result;
    }

    private class Result{
        int selfValue;
        int aterCutRes;
    }




}
