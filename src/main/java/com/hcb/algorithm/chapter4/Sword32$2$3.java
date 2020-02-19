package com.hcb.algorithm.chapter4;
/**
 * print1 print2 print3 为32$2题
 * zigzagPrint和zigzagPrint2为32$3题
 */

import com.hcb.algorithm.chapter2.BiTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Sword32$2$3 {
    public static void main(String[] args) {
        BiTree.BinaryTreeNode root = null;
        root = BiTree.createBiTree();
        BiTree.prePrint(root);
        System.out.println("...........");

        // 以下两种解法来自Markdown,都是将打印的结果形成列表返回回来,不完全符合题意
//        ArrayList<ArrayList<Character>> list = print(root);
//        ArrayList<ArrayList<Character>> list2 = print2(root);
        //符合题意的解法
//        print3(root);


        zigzagPrint(root);
//        zigzagPrint2(root);
    }
    //剑指offer书上的思路,维持两个栈,不需要先将每行的序列先保存再打印
    private static void zigzagPrint2(BiTree.BinaryTreeNode root) {
        Stack<BiTree.BinaryTreeNode>[] stackPair = new Stack[2];
        stackPair[0] = new Stack<BiTree.BinaryTreeNode>();
        stackPair[1] = new Stack<BiTree.BinaryTreeNode>();
        int flag = 0;
        stackPair[0].add(root);
        while (!stackPair[flag].empty()){
            BiTree.BinaryTreeNode node = stackPair[flag].pop();
            System.out.print(node.value + " ");
            if(flag == 0){
                if(node.left != null){
                    stackPair[1-flag].push(node.left);
                }
                if(node.right != null){
                    stackPair[1-flag].push(node.right);
                }
            }else {
                if(node.right != null){
                    stackPair[1-flag].push(node.right);
                }
                if(node.left != null){
                    stackPair[1-flag].push(node.left);
                }
            }
            if(stackPair[flag].empty()){
                flag = 1-flag;
                System.out.println();
            }
        }
    }

    // my method :先保存到数组中,再打印,这样不如书上的时间复杂度低
    private static void zigzagPrint(BiTree.BinaryTreeNode pRoot) {
        if (pRoot == null) {
            return ;
        }
        //Queue 是一个接口
        Queue<BiTree.BinaryTreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int remainNum = 1;
        int nextNum = 0;
        ArrayList<Character> list = new ArrayList<>();
        // 正向打印标记
        boolean forwardFlag = true;
        while (!queue.isEmpty()) {
            BiTree.BinaryTreeNode node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
                nextNum++;
            }
            if(node.right != null){
                queue.add(node.right);
                nextNum++;
            }
            list.add((Character) node.value);
            remainNum--;
            if(remainNum == 0){
                printList(list,forwardFlag);
                System.out.println();
                list.clear();
                forwardFlag = !forwardFlag;
                remainNum = nextNum;
                nextNum = 0;
            }
        }
    }

    private static void printList(ArrayList<Character> list, boolean forwardFlag) {
        if(forwardFlag){
            for (Character ch :
                    list) {
                System.out.print(ch + " ");
            }
        }else {
            for (int i = list.size()-1; i >= 0 ; i--) {
                System.out.print(list.get(i)+" ");
            }
        }
    }

    private static void print3(BiTree.BinaryTreeNode pRoot) {
        if (pRoot == null) {
            return ;
        }
        //Queue 是一个接口
        Queue<BiTree.BinaryTreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int remainNum = 1;
        int nextNum = 0;
        while (!queue.isEmpty()) {
            BiTree.BinaryTreeNode node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
                nextNum++;
            }
            if(node.right != null){
                queue.add(node.right);
                nextNum++;
            }
            System.out.print(node.value);
            remainNum--;
            if(remainNum == 0){
                System.out.println();
                remainNum = nextNum;
                nextNum = 0;
            }
        }
    }

    private static ArrayList<ArrayList<Character>> print(BiTree.BinaryTreeNode pRoot) {
        ArrayList<ArrayList<Character>> ret = new ArrayList<>();
        if (pRoot == null) {
            return ret;
        }
        //Queue 是一个接口
        Queue<BiTree.BinaryTreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Character> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                BiTree.BinaryTreeNode node = queue.poll();
                list.add((Character) node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (list.size() != 0)
                ret.add(list);
        }
        return ret;
    }

    //更简洁的做法：用递归做的
    private static ArrayList<ArrayList<Character>> print2(BiTree.BinaryTreeNode pRoot) {
        ArrayList<ArrayList<Character>> lists = new ArrayList<>();
        depth(pRoot, 1, lists);
        return lists;
    }

    private static void depth(BiTree.BinaryTreeNode root, int depth, ArrayList<ArrayList<Character>> lists) {
        if (root == null)
            return;
        // 实际上这里的 depth 要么与 size 相等，要么大 1
        // 初始化列表
        if (depth > lists.size())
            lists.add(new ArrayList<Character>());

        // 注意这个地方是 depth-1，因为数组的下边是从 0 开始的
        lists.get(depth - 1).add((Character) root.value);

        depth(root.left, depth + 1, lists);
        depth(root.right, depth + 1, lists);
    }
}
