package com.hcb.algorithm.chapter2;
/**
 * 从键盘读取单个字符
 * 输入：abc空空de空g空空f空空空
 * 先序：abcdegf
 * 中序：cbegdfa
 */

public class Sword8 {
    public static void main(String[] args) {
        BiTree.BinaryTreeNode root = null;
        root = BiTree.createBiTreeWithParent(root);
        BiTree.prePrint(root);

        BiTree.BinaryTreeNode bt = root.left.right;
        BiTree.BinaryTreeNode next = getMidOrderNext(bt);
        if(next == null){
            System.out.println("null");
        }else {
            System.out.println("next: "+next.value);
        }
    }


    private static BiTree.BinaryTreeNode getMidOrderNext(BiTree.BinaryTreeNode bt) {
        if(bt == null){
            System.out.println("invalid input");
            return null;
        }else {
            if(bt.right == null){
                //如果它有父节点
                if(bt.parent !=null) {
                    //如果bt的右结点为空，并且bt是父节点的左子节点，则中序序列的下一个是它的父节点节点
                    if(bt == bt.parent.left){
                        return bt.parent;
                    }else {
                        //如果bt的右结点为空，并且bt是父节点的右子节点，则一直遍历祖先，直到该祖先是.left
                        BiTree.BinaryTreeNode tmp = bt.parent;
                        while(tmp.parent != null){
                            if(tmp == tmp.parent.left){
                                return tmp.parent;
                            }else {
                                tmp = tmp.parent;
                            }
                        }
                        //如果走到根节点,说明它是最右的结点,没有下一个结点
                        return null;
                    }
                }else {
                    return null;
                }


            }else {
                // 下一个就是 右子树的最左边的结点
                BiTree.BinaryTreeNode p = bt.right;
                for(;p.left!=null;p=p.left);
                return p;
            }
        }
    }
}
