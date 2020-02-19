package com.hcb.algorithm.chapter2;

public class Sword15 {
    public static void main(String[] args) {
        int count = 0;
        int n = -9;
        count = new Sword15().getOneCount4(n);
        System.out.println(count);
//        System.out.println(Integer.toBinaryString(-9));
//        System.out.println(Integer.toBinaryString(9));
//        System.out.println(Integer.valueOf("-1001",2).toString());


    }
    // hcb 只对正数有效 可以将if判断内的也用位运算优化
    private int getOneCount(int n) {
        int count = 0;
        int temp = 0;
        while(n!=0){
            temp = n>>1;
            if(n==2*temp+1){
                count++;
            }
            n=temp;
        }
        return count;
    }

    //剑指offer 只对正数有效
    private int getOneCount2(int n) {
        int count = 0;
        while(n!=0){
            if((n&1) == 1){
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    // 对正负数都有效,但需要一次循环32位
    private int getOneCount3(int n){
        int count = 0;
        int ref = 1;
        // 从低位到高位,一共32位
        for (int i = 1; i <=32; i++) {
            if((n&ref)==ref){
                count++;
            }
            ref = ref<<1;
        }
        return count;
    }


    // 对正负数都有效
    // 对于每一个n,执行完n=n&(n-1)就会消灭一个1
    private int getOneCount4(int n){
        int count = 0;
        while (n!=0){
            //只要n不等于0,那么其二进制肯定含有1
            count++;
            n = n&(n-1);
        }
        return count;
    }
}




