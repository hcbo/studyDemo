package com.hcb.algorithm.chapter2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


/**
 * 用例：
 * 输入：ABD空空空CEG空空空F空空(abd   ceg   f  )
 * 先序：abdcegf
 * 中序：dbagecf
 * 后序：dbgefca
 */

public class BiTree {



    public static class BinaryTreeNode<T> {
        public T value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
        public BinaryTreeNode parent;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(T v) {
            value = v;
        }
    }
    public static void prePrint(BinaryTreeNode  bt) {
        if (bt == null) {
            return;
        } else {
            System.out.println(bt.value + " ");
            if(bt.parent!= null){
                System.out.println("parent node:"+bt.parent.value);
            }else {
//                System.out.println("null parent");
            }
            prePrint(bt.left);
            prePrint(bt.right);
        }
    }
    public static void midPrint(BinaryTreeNode bt){
        if(bt == null){
            return;
        }else{
            midPrint(bt.left);
            System.out.print(bt.value+" ");
            midPrint(bt.right);
        }
    }
    //不使用递归的中序遍历
//    https://blog.csdn.net/zhangxiangDavaid/article/details/37115355
    public static void midPrint2(BinaryTreeNode root){
        Stack stack = new Stack();
        BinaryTreeNode curBt = root;
        BinaryTreeNode tmpBt = null;
        while(!stack.empty() || curBt != null){
            while(curBt != null){
                stack.push(curBt);
                curBt = curBt.left;
            }
            tmpBt = (BinaryTreeNode) stack.pop();
            System.out.print(tmpBt.value + " ");
            curBt = tmpBt.right;
        }
        System.out.println();
    }


    public static BinaryTreeNode createBiTree() {
        char ch = 0;
        try {
//            从键盘读取单个字符
            ch = (char)System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(ch == ' '){
            return null;
        }
        else {
            BinaryTreeNode bt = new BinaryTreeNode(ch);
            bt.left = createBiTree();
            bt.right = createBiTree();
            return bt;
        }
    }

    public static BinaryTreeNode createIntBiTree(Iterator itr){
        Object obj = itr.next();
        if(obj == null){
            return null;
        }
        else{
            BinaryTreeNode bt = new BinaryTreeNode((int)obj);
            bt.left = createIntBiTree(itr);
            bt.right = createIntBiTree(itr);
            return bt;
        }
    }

    public static BinaryTreeNode createBiTreeWithParent(BinaryTreeNode root){
        char ch = 0;
        try {
//            从键盘读取单个字符
            ch = (char)System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(ch == ' '){
            return null;
        }
        else {
            BinaryTreeNode bt = new BinaryTreeNode(ch);
            bt.parent = root;
            bt.left = createBiTreeWithParent(bt);
            bt.right = createBiTreeWithParent(bt);
            return bt;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = null;
//        root = createBiTree();
//        prePrint(root);
//        System.out.println();
//        midPrint(root);

        root = createBiTreeWithParent(root);
        prePrint(root);

    }
}
