package com.hcb.algorithm.chapter4;

import com.hcb.algorithm.chapter2.BiTree;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Sword36 {
    public static void main(String[] args) {
        List list = Arrays.asList(10,6,4,null,null,8,null,null,14,12,null,null,16,null,null);
        BiTree.BinaryTreeNode root = null;
        root = BiTree.createIntBiTree(list.iterator());
        BiTree.midPrint(root);
        System.out.println();
        BiTree.midPrint2(root);
//        BiTree.BinaryTreeNode node = toDList(root);
        BiTree.BinaryTreeNode node = convert(root);

        //打印双向链表
        BiTree.BinaryTreeNode pointer = node;
        do {
            System.out.println(pointer.value);
            pointer = pointer.right;
        }while(pointer.right != null);
        while(pointer != null){
            System.out.println(pointer.value);
            pointer = pointer.left;
        }

    }
// 借鉴非递归中序遍历二叉树的方法
    private static BiTree.BinaryTreeNode toDList(BiTree.BinaryTreeNode root) {
        BiTree.BinaryTreeNode head = null;
        Stack stack = new Stack();
        BiTree.BinaryTreeNode curBt = root;
        BiTree.BinaryTreeNode tmpBt = null;
//        保存上一个出栈的元素
        BiTree.BinaryTreeNode previousOut = null;
        while (!stack.empty() || curBt != null) {
            while (curBt != null) {
                stack.push(curBt);
                curBt = curBt.left;
            }
            tmpBt = (BiTree.BinaryTreeNode) stack.pop();
            curBt = tmpBt.right;

            tmpBt.left = previousOut;
            if(previousOut != null){
                previousOut.right = tmpBt;
            }else {
                head = tmpBt;
            }
            previousOut = tmpBt;
        }
        return head;
    }

    // markdown 方法
    private static BiTree.BinaryTreeNode pre = null;
    private static BiTree.BinaryTreeNode head = null;
    public static BiTree.BinaryTreeNode convert(BiTree.BinaryTreeNode root) {
        inOrder(root);
        return head;
    }

    private static void inOrder(BiTree.BinaryTreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        node.left = pre;
        if (pre != null)
            pre.right = node;
        pre = node;
        if (head == null)
            head = node;
        inOrder(node.right);
    }


}
