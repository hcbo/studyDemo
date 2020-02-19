package com.hcb.algorithm.chapter4;

/**
 * 采用例子的方法来确定边界条件
 */

public class Sword29{
    public static void main(String[] args) {
//        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] arr = {{1,2,3},{5,6,7},{9,10,11},{13,14,15}};
//        int[][] arr = {{1,2}};
//        int[][] arr = {{1}};
        matrixPrint(arr);
    }

    private static void matrixPrint(int[][] arr) {
        circlePrint(arr,0,arr.length-1,
                0,arr[0].length-1);
    }
    /**
    * @Description: 一圈一圈的打印
    * @Param: [arr, rStart, rEnd, cStart, cEnd]
    * @return: void
    * @Author: hcb
    * @Date: 2020-02-07
    */
    private static void circlePrint(int[][] arr, int rStart,
                                    int rEnd, int cStart, int cEnd) {
        if(rStart>rEnd || cStart>cEnd){
            return;
        }
        // 圈只有一个元素的情况
        if(rEnd-rStart == 0 && cEnd-cStart == 0){
            System.out.println(arr[rStart][cStart]);
            return;
        }
        //该圈元素个数
        int printNum = (rEnd - rStart +1)*2 + (cEnd - cStart -1)*2;
        int counter = 0;
        int i = rStart;
        int j = cStart;
        while (counter < printNum){
            System.out.println(arr[i][j]);
            counter++;
            if(counter <= cEnd-cStart){
                j++;
            }else if(counter <= (cEnd-cStart)+(rEnd-rStart)){
                i++;
            }else if(counter <= (cEnd-cStart)*2+(rEnd-rStart)){
                j--;
            }else {
                i--;
            }
        }
        circlePrint(arr,rStart+1,rEnd-1,
                cStart+1,cEnd-1);
    }

}
