package com.hcb.algorithm.chapter4;

/**
 *
 * 用例:
 * 输入:
 */

import com.hcb.algorithm.chapter2.BiTree;

import java.util.*;

public class Sword34 {
    public static void main(String[] args) {
//        List list = Arrays.asList(10,5,4,null,null,7,null,null,12,null,null);
        List list = Arrays.asList(10,5,4,null,null,7,null,null,12,null,4,null,null);
        BiTree.BinaryTreeNode root = null;
        root = BiTree.createIntBiTree(list.iterator());
        BiTree.prePrint(root);
        System.out.println("...........");
        printPath(root,22);
    }

    private static void printPath(BiTree.BinaryTreeNode root, int sum) {
        int count = 0;
        ArrayList<Integer> path = new ArrayList<>();
        printPathRecursion(root,sum,count,path);
    }

    private static void printPathRecursion(BiTree.BinaryTreeNode root,
                                           int sum, int count, ArrayList<Integer> path) {
        if(root == null){
            return;
        }
        path.add((int)root.value);
        count = count +(int)root.value;
        if(count == sum){
            for (int elem :
                    path) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        printPathRecursion(root.left,sum,count,path);
        printPathRecursion(root.right,sum,count,path);
        path.remove(path.size()-1);
        count -= (int)root.value;
    }
}
