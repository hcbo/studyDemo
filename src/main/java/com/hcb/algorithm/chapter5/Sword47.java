package com.hcb.algorithm.chapter5;

public class Sword47 {
    public static void main(String[] args) {
        int num = getMost2(new int[][]{{1,10,3,8},
                                      {12,2,9,6},
                                      {5,7,4,11},
                                      {3,7,16,5}});
        System.out.println(num);
    }
    public static int getMost(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0)
            return 0;
        int n = values[0].length;
        int[] dp = new int[n];
        for (int[] value : values) {
            dp[0] += value[0];
            for (int i = 1; i < n; i++)
                //dp[i]表示上面对应元素到1的最大值,dp[i-1]表示左边元素到1的最大值
                dp[i] = Math.max(dp[i], dp[i - 1]) + value[i];
        }
        return dp[n - 1];
    }

    public static int getMost2(int[][] values){
        int[][] distances = new int[values.length][values[0].length];
        int num = getMostRec(values,distances,0,0);
        return num;
    }

    // 先进行判断,如果有值,说明计算过了,就不计算了
    private static int getMostRec(int[][] values, int[][] distances,int startI,int startJ) {
        if(startI == values.length-1 && startJ == values[0].length-1){
            return values[startI][startJ];
        }
        if (startI == values.length-1) {
            distances[startI][startJ] = values[startI][startJ] + (distances[startI][startJ+1] != 0?distances[startI][startJ+1]:getMostRec(values, distances, startI, startJ + 1));
        } else if (startJ == values[0].length-1) {
            distances[startI][startJ] = values[startI][startJ] + (distances[startI+1][startJ] != 0?distances[startI+1][startJ]:getMostRec(values, distances, startI+1, startJ));
        } else {
            distances[startI][startJ] = values[startI][startJ] + Math.max(distances[startI][startJ+1] != 0?distances[startI][startJ+1]:getMostRec(values, distances, startI, startJ + 1),
                    distances[startI+1][startJ] != 0?distances[startI+1][startJ]:getMostRec(values, distances, startI+1, startJ));
        }
        return distances[startI][startJ];
    }
}
