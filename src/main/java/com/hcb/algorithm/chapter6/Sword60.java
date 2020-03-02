package com.hcb.algorithm.chapter6;

public class Sword60 {
    //剑指offer第60题：n个骰子的点数

    /*打印出和为s的所有可能值及其概率*/
    public static void printProbility(int number) {
        /*维护两个数组，通过前一个数组的值计算下一个数组的值*/
        final int MAX_VALUE = 6;
        int[][] probility = new int[2][number * MAX_VALUE + 1];
        int flag = 0;
        /*只有一个骰子时，s的取值范围为1--MAX_VALUE,可能出现的次数均为1*/
        for (int i = 0; i <= MAX_VALUE; i++)
            probility[flag][i] = 1;
        /*当有k个骰子时，最大值为number*/
        for (int k = 2; k <= number; k++) {
            /*将不可能出现的取值计数置为0，避免下一轮计算错误累加*/
            for (int i = 0; i < k; i++)
                probility[1 - flag][i] = 0;
            /*s(即i)的取值范围为k--MAX_VALUE*k*/
            for (int i = k; i < MAX_VALUE * k + 1; i++){
                /*重置另一个数组准备存贮新值*/
                probility[1 - flag][i] = 0;
                /*和为s(即i)的情况可能出现的次数由s-1,...,s-6可能出现的次数累加得到*/
                for (int j = 1; j <= i && j <= MAX_VALUE; j++){
                    probility[1 - flag][i] += probility[flag][i - j];
                }
            }
            /*交换数组的循环角色*/
            flag = 1 - flag;
        }
        /*可能的排列总数量*/
        int total = (int) Math.pow(MAX_VALUE, number);
        for (int i = number; i <= MAX_VALUE * number; i++){
            /*此处注意转化为浮点数，否则值全为0*/
            double ratio = (double) probility[flag][i] / total;
            System.out.printf("%d（和） : %e（概率）\n",i, ratio);
        }
    }

    //测试用例
    public static void main(String[] args){
        Sword60.printProbility(1); // 0.1666667
        System.out.println();
        Sword60.printProbility(6);
    }
}
