package com.hcb.algorithm.chapter2;

public class Sword13 {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        int k = 4;
        int count = new Sword13().reachableCount(m,n,k);
        System.out.println(count);
    }

    private  int reachableCount(int rows, int columns, int k) {
        boolean[][] visited = new boolean[rows][columns];
        visited[0][0] = true;
        int count = 0;
        Index index = new Index(0,0);
        count = reachableCountRev(rows,columns,k,index,visited);
        return count;
    }

    private int reachableCountRev(int rows, int columns, int k, Index index, boolean[][] visited) {
        int count = 1;
        int travelFlag = 0;
        Index neighbor = null;
        while(travelFlag<=3){
            neighbor = nextIndex(index,travelFlag,rows,columns,visited);
            if(neighbor == null){
                travelFlag++;
                continue;
            }else {
                if(neighbor.row+neighbor.column<=k){
                    visited[neighbor.row][neighbor.column] = true;
                    count+=reachableCountRev(rows,columns,k,neighbor,visited);
                }
                travelFlag++;

            }
        }
        return count;
    }


    private  Index nextIndex(Index indexs, int direcFlag,int rows,int columns,boolean[][] traversFlag) {
        switch (direcFlag){
            case 0:
                if(indexs.row-1<0 || traversFlag[indexs.row-1][indexs.column]){
                    return null;
                }else {
                    return new Index(indexs.row-1,indexs.column);
                }
            case 1:
                if (indexs.row+1>rows-1 || traversFlag[indexs.row+1][indexs.column]){
                    return null;
                }else {
                    return new Index(indexs.row+1,indexs.column);
                }
            case 2:
                if(indexs.column-1<0 || traversFlag[indexs.row][indexs.column-1]){
                    return null;
                }else {
                    return new Index(indexs.row,indexs.column-1);
                }
            case 3:
                if (indexs.column+1>columns-1|| traversFlag[indexs.row][indexs.column+1]){
                    return null;
                }else {
                    return new Index(indexs.row,indexs.column+1);
                }
            default:return null;
        }
    }


    class Index{
        int row;
        int column;

        public Index(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}

