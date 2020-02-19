package com.hcb.algorithm.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 从左下角开始,每次都能排除一行或一列
 * 二维数组的输入
 *
 */

public class Sword4
{
    public static void main( String[] args )
    {
        // 输入
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String str = null;
        while(sc.hasNextLine()){
            str=sc.nextLine();
            if(str.equals("")){
                break;
            }
            list.add(str);
        }
        int target = Integer.parseInt(list.get(0));
        int column = list.get(1).split(" ").length;
        int row = list.size()-1;
        int[][] arr = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <column ; j++) {
                arr[i][j]=Integer.parseInt(list.get(i+1).split(" ")[j]);
            }
        }

        int rowPos = row -1;
        int colPos = 0;
        while(rowPos>=0 && colPos<=column-1){
            if(arr[rowPos][colPos] == target){
                System.out.println("true");
                return;
            }
            else if(arr[rowPos][colPos]>target){
                rowPos--;
            }else {
                colPos++;
            }
        }
        System.out.println("false");

//        printArr(arr);
    }

    private static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
