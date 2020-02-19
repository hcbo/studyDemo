package com.hcb.algorithm.chapter2;

import java.util.Stack;

public class Sword12 {
    public static void main(String[] args) {
        char[][] chars = new char[][]{{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        String path = "bfct";
        boolean exists = containsPath(chars,path);
        System.out.println(exists);
        boolean exists2 = containsPath2(chars,path);
        System.out.println(exists2);
    }

    // 题意2的解法
    private static boolean containsPath2(char[][] chars, String path) {
        if(chars == null ||chars.length ==0 || chars[0].length==0){
            return false;
        }
        int rows = chars.length;
        int colums = chars[0].length;
        boolean[][] visited = null;
        int pos = 0;
        boolean exists = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if(chars[i][j] == path.charAt(0)){
                    visited = initFlags(rows,colums);
                    visited[i][j] = true;
                    Indexs indexs = new Indexs(i,j,chars[i][j]);
                    exists = containsPath2Core(chars,indexs,path,1,visited);
                }
            }
        }
        return exists;
    }

    private static boolean containsPath2Core(char[][] chars, Indexs indexs, String path, int pos, boolean[][] visited) {
        if(pos == path.length()){
            return true;
        }else {
            boolean flag = false;
            int direcFlag = 0;
            Indexs neighbor = null;
            while(direcFlag <=3){
                neighbor = nextIndexs(indexs,direcFlag,chars,visited);
                if(neighbor == null){
                    direcFlag++;
                    continue;
                }else {
                    visited[neighbor.rowIndex][neighbor.columIndex] = true;
                    if(neighbor.value==path.charAt(pos)){
                        flag = containsPath2Core(chars,neighbor,path,pos+1,visited);
                        if(flag){
                            return flag;
                        }
                    }
                    direcFlag++;
                }
            }
            return flag;

        }
    }



    // 题意1的解法
    private static boolean containsPath(char[][] chars, String path) {
        if(chars == null ||chars.length ==0 || chars[0].length==0){
            return false;
        }
        Stack<Indexs> stack = new Stack<>();
        //用于遍历path
        int pos = 0;
        int rows = chars.length;
        int colums = chars[0].length;
        boolean[][] flags = initFlags(rows,colums);

        //第一次遍历 符合的入栈
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if(chars[i][j]==path.charAt(pos)){
                    stack.push(new Indexs(i,j,chars[i][j]));
                }
            }
        }
        if(!stack.empty()){
            pos++;
        }

        int direcFlag = 0;
        Indexs neighbor = null;
        while(!stack.empty()){
            Indexs indexs = stack.peek();
            // 如果栈顶是path的第一个元素,则清空标志矩阵
            if(chars[indexs.rowIndex][indexs.columIndex] == path.charAt(0)){
                flags = initFlags(rows,colums);
                flags[indexs.rowIndex][indexs.columIndex] = true;
            }

            direcFlag = 0;
            neighbor = null;
            int beforeSize = stack.size();
            // 找周围的四个 0,1,2,3按照上下左右的顺序
            while(direcFlag <=3){
                neighbor = nextIndexs(indexs,direcFlag,chars,flags);
                if(neighbor == null){
                    direcFlag++;
                    continue;
                }else {
                    flags[neighbor.rowIndex][neighbor.columIndex] = true;
                    if(neighbor.value==path.charAt(pos)){
                        stack.push(neighbor);
                    }
                    direcFlag++;
                }
            }
            // 经历过循环,如果元素数量发生变化,说明有入栈的neibor或neighbors,pos向后挪一位
            if(beforeSize != stack.size()){
                pos++;
                //如果path所有的元素都遍历过了,则说明有这个路径
                if(pos == path.length()){
                    return true;
                }
            }else {
                Indexs indexs1 = stack.pop();
                //如果indx 和栈顶元素是邻居,说明以栈顶为中心的所有邻居都遍历完毕,并且没有入栈的,那么中心需要出栈并且pos--,否则不能减
                if(!stack.empty()){
                    Indexs indexs2 = stack.peek();
                    if(isNeighbor(indexs1,indexs2)){
                        pos--;
                        stack.pop();
                    }
                }
            }
        }
        // 退出说明栈空
        return false;
    }

    private static boolean isNeighbor(Indexs indexs1, Indexs indexs2) {
        if(indexs1==null || indexs2==null){
            return true;
        }else {
            if(indexs1.rowIndex == indexs2.rowIndex){
                return Math.abs(indexs1.columIndex-indexs2.columIndex)==1;
            }
            if(indexs1.columIndex == indexs2.columIndex){
                return Math.abs(indexs1.rowIndex-indexs2.rowIndex)==1;
            }
            return false;
        }
    }

    private static Indexs nextIndexs(Indexs indexs, int direcFlag,char[][] chars,boolean[][] traversFlag) {
        switch (direcFlag){
            case 0:
                if(indexs.rowIndex-1<0 || traversFlag[indexs.rowIndex-1][indexs.columIndex]){
                    return null;
                }else {
                    return new Indexs(indexs.rowIndex-1,indexs.columIndex,chars[indexs.rowIndex-1][indexs.columIndex]);
                }
            case 1:
                if (indexs.rowIndex+1>chars.length-1 || traversFlag[indexs.rowIndex+1][indexs.columIndex]){
                    return null;
                }else {
                    return new Indexs(indexs.rowIndex+1,indexs.columIndex,chars[indexs.rowIndex+1][indexs.columIndex]);
                }
            case 2:
                if(indexs.columIndex-1<0 || traversFlag[indexs.rowIndex][indexs.columIndex-1]){
                    return null;
                }else {
                    return new Indexs(indexs.rowIndex,indexs.columIndex-1,chars[indexs.rowIndex][indexs.columIndex-1]);
                }
            case 3:
                if (indexs.columIndex+1>chars[0].length-1 || traversFlag[indexs.rowIndex][indexs.columIndex+1]){
                    return null;
                }else {
                    return new Indexs(indexs.rowIndex,indexs.columIndex+1,chars[indexs.rowIndex][indexs.columIndex+1]);
                }
            default:return null;
        }
    }


    private static boolean[][] initFlags(int rows, int colums) {
        return new boolean[rows][colums];
    }
}

class Indexs{
    int rowIndex;
    int columIndex;
    int value;

    public Indexs(int rowIndex, int columIndex, int value) {
        this.rowIndex = rowIndex;
        this.columIndex = columIndex;
        this.value = value;
    }
}


















