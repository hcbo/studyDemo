package com.hcb.algorithm.chapter2;

/**
 * 红黑树
 */

public class RBTree {

    public RBTreeNode root;

    public static class RBTreeNode<T extends Comparable<T>> {
        public T value;
        public RBTreeNode left;
        public RBTreeNode right;
        public RBTreeNode parent;
        public boolean red ;


        public RBTreeNode(T v) {
            this.left = null;
            this.right = null;
            this.parent = null;
            value = v;
        }
    }
    public static void prePrint(RBTreeNode  bt) {
        if (bt == null) {
            return;
        } else {
            System.out.print(bt.value + " "+bt.red);
            if(bt.parent!= null){
                System.out.println("(parent node:"+bt.parent.value+")");
            }else {
                System.out.println("(parent null)");
            }
            prePrint(bt.left);
            prePrint(bt.right);
        }
    }


    public static void insert(RBTree rbTree,RBTree.RBTreeNode node){
        RBTree.RBTreeNode y = null;
        RBTree.RBTreeNode x = rbTree.root;
        while (x!=null){
            y = x;
            if(node.value.compareTo(x.value)<0){
                x = x.left;
            }else {
                x = x.right;
            }
        }
        node.parent = y;
        if(y == null){
            rbTree.root = node;
        }else if(node.value.compareTo(y.value)<0) {
            y.left = node;
        }else {
            y.right = node;
        }
        node.left = null;
        node.right = null;
        node.red = true;
        insertFixup(rbTree,node);

    }

    private static void insertFixup(RBTree rbTree, RBTreeNode node) {
        if(node.parent == null){
            //case0 node是root
            node.red = false;
            return;
        }else if(node.parent.parent == null){
            return;
        }
        RBTreeNode y = null;
        while(node.parent != null && node.parent.red){
            //如果node的父亲是祖父的左孩子
            if(node.parent == node.parent.parent.left){
                //y 是node的叔叔节点
                y = node.parent.parent.right;
                if(y!=null && y.red){
                    //case1
                    node.parent.red =false;
                    y.red = false;
                    node.parent.parent.red = true;
                    node = node.parent.parent;
                    //执行之后,node的指向向上了两层,仍然指向红色
                }else{
                    if(node == node.parent.right){
                        //case2 triangle型
                        node = node.parent;
                        leftRotate(rbTree,node);
                        //上边的左旋操作执行后,变成了case3 即line型的
                    }
                    //case3 line型
                    node.parent.red = false;
                    node.parent.parent.red = true;
                    rightRotate(rbTree,node.parent.parent);
                    // 直线型执行之后,node的指向的虽然没改变,但是其指向的结点上升了一层
                }


            }
            // 如果node的父亲是祖父的右孩子,逻辑与上面相同,只不过左右交换一下的这种情况
            else {
                y = node.parent.parent.left;
                if(y!=null && y.red){
                    node.parent.red = false;
                    y.red = false;
                    node.parent.parent.red = true;
                    node = node.parent.parent;
                }else {
                    if(node == node.parent.left){
                        //triangle
                        node = node.parent;
                        rightRotate(rbTree,node);
                        //上边执行完,变成line型
                    }
                    //line型
                    node.parent.red = false;
                    node.parent.parent.red = true;
                    leftRotate(rbTree,node.parent.parent);
                }
            }

            rbTree.root.red = false;

        }
    }

    private static void rightRotate(RBTree rbTree, RBTreeNode node) {
        RBTreeNode y = node.left;
        node.left = y.right;
        if(y.right != null){
            y.right.parent = node;
        }
        y.parent = node.parent;
        if(node.parent ==null){
            rbTree.root = y;
        }else if(node == node.parent.right){
            node.parent.right = y;
        }else {
            node.parent.left = y;
        }
        y.right = node;
        node.parent = y;
    }

    private static void leftRotate(RBTree rbTree, RBTreeNode node) {
        RBTreeNode y = node.right;
        node.right = y.left;
        if(y.left != null){
            y.left.parent = node;
        }
        y.parent = node.parent;
        if(node.parent == null){
            rbTree.root = y;
        }else if(node == node.parent.left){
            node.parent.left = y;
        }else {
            node.parent.right = y;
        }
        y.left = node;
        node.parent = y;
    }

    public static void main(String[] args) {
        RBTree rbTree = new RBTree();;
        insert(rbTree,new RBTreeNode(19));
        insert(rbTree,new RBTreeNode(15));
        insert(rbTree,new RBTreeNode(12));
//        prePrint(rbTree.root);
        insert(rbTree,new RBTreeNode(33));

        insert(rbTree,new RBTreeNode(37));
        insert(rbTree,new RBTreeNode(10));

        insert(rbTree,new RBTreeNode(25));
        insert(rbTree,new RBTreeNode(24));
        prePrint(rbTree.root);
    }
}
