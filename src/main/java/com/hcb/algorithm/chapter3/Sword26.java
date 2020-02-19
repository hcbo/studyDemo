package com.hcb.algorithm.chapter3;

/**
 * 用例
 * root1:889空空24空空7空空7空空(889  24  7  7  )
 * 先序:8892477
 * 中序:9842787
 * root2:89空空2空空(89  2  )
 * 先序:892
 * 中序:982
 */


import com.hcb.algorithm.chapter2.BiTree;

import java.io.IOException;

public class Sword26 {
    public static void main(String[] args) throws IOException {
        BiTree.BinaryTreeNode root1 = null;
        BiTree.BinaryTreeNode root2 = null;
        root1 = BiTree.createBiTree();
        BiTree.prePrint(root1);
        BiTree.midPrint(root1);
        //吸收换行符
        char absorbEnter = (char)System.in.read();
        root2 = BiTree.createBiTree();
        BiTree.prePrint(root2);
        BiTree.midPrint(root2);

        boolean isSubTree = isSubTree(root1,root2);
        System.out.println(isSubTree);


    }

    private static boolean isSubTree(BiTree.BinaryTreeNode root1, BiTree.BinaryTreeNode root2) {
        if(root1 == null){
            return false;
        }else {
            if(contains(root1,root2)){
                return true;
            }else {
                return isSubTree(root1.left,root2) || isSubTree(root1.right,root2);
            }
        }
    }
    /**
    * @Description: root2的角度遍历 看root1是否有结构相同的部分
    * @Param: [root1, root2]
    * @return: boolean
    * @Author: hcb
    * @Date: 2020-02-06
    */
    private static boolean contains(BiTree.BinaryTreeNode root1, BiTree.BinaryTreeNode root2) {
        if(root2 == null){
            return true;
        }else if(root2.value !=root1.value){
            return false;
        }else {
            return contains(root1.left,root2.left) && contains(root1.right,root2.right);
        }
    }
}
