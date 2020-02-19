package com.hcb.algorithm.chapter3;

/**
 * 用例1
 * 输入:括号内的内容(865  7  67  5  )
 * 用例2
 * 输入:括号内的内容(865  7  97  5  )
 * 用例3
 * 输入:括号内的内容(777  7  77   )
 */



import com.hcb.algorithm.chapter2.BiTree;
import java.util.ArrayList;


public class Sword28 {
    public static void main(String[] args) {
        BiTree.BinaryTreeNode root = null;
        root = BiTree.createBiTree();
        BiTree.prePrint(root);
        boolean isSymmetric = isSymmetric(root);
        boolean isSymmetric2 = isSymmetric2(root);
        System.out.println(isSymmetric + " "+isSymmetric2);
    }


    // 书上答案
    private static boolean isSymmetric2(BiTree.BinaryTreeNode pRoot) {
        if (pRoot == null)
            return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private static boolean isSymmetrical(BiTree.BinaryTreeNode t1, BiTree.BinaryTreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.value != t2.value)
            return false;
        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
    }

    // 我的答案
    private static boolean isSymmetric(BiTree.BinaryTreeNode root) {
        //list1 是按照根左右(先序)方式遍历,list2 是按照根右左的方式遍历的
        // list 是按照插入顺序排列的(即有序),且元素可重复
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        traverse1(root,list1);
        traverse2(root,list2);
        int i = 0;
        for (i = 0; i < list1.size(); i++) {
            if(list1.get(i)!= list2.get(i)){
                return false;
            }
//            System.out.println(list1.get(i));
        }
        if(i == list2.size()){
            return true;
        }else {
            return false;
        }
    }



    private static void traverse1(BiTree.BinaryTreeNode root, ArrayList list1) {
        if(root == null){
            list1.add(root);
            return;
        }else {
            list1.add(root.value);
            traverse1(root.left,list1);
            traverse1(root.right,list1);
        }
    }

    private static void traverse2(BiTree.BinaryTreeNode root, ArrayList list2) {
        if(root == null){
            list2.add(root);
            return;
        }else {
            list2.add(root.value);
            traverse2(root.right,list2);
            traverse2(root.left,list2);
        }
    }
}
