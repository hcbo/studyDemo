package com.hcb.algorithm.chapter2;

public class Sword7 {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] mid = {4,7,2,1,5,3,8,6};
        BiTree.BinaryTreeNode bt = createTree(pre,mid,0,7,0,7);
        BiTree.prePrint(bt);
        System.out.println();
        BiTree.midPrint(bt);

    }

    private static BiTree.BinaryTreeNode createTree(int[] pre, int[] mid, int pStart, int pEnd, int mStart, int mEnd) {
        if(pStart>pEnd){
            return null;
        }else{
            int index = 0;
            for(index = mStart;index <= mEnd;++index){
                if(mid[index]==pre[pStart]){
                    break;
                }
            }
            BiTree.BinaryTreeNode bt = new BiTree.BinaryTreeNode();
            bt.value = pre[pStart];
            bt.left = createTree(pre,mid,pStart+1,index-mStart+pStart,mStart,index-1);
            bt.right = createTree(pre,mid,index-mStart+pStart+1,pEnd,index+1,mEnd);
            return bt;
        }
    }
}

