package com.hcb.algorithm.chapter3;

/**
 * 对于链表的问题,通常设置一个没有数据的头结点比较易于编写代码,因为这样做可以把第一个数据节点普通化,
 * 使得它和所有的节点一样都有前驱节点,这尤其是面对删除节点的问题时,很方便.
 */

public class Sword18 {
    public static void main(String[] args) {
//        Integer[] arr = {1,2,2,3,4,4,4,5,6,7,7};
        Integer[] arr = {1,1,1};
        MyLinkedList mylist = new MyLinkedList(arr);
        mylist.display();
//        testDeleteNode(mylist,1);
        testDeleteDuplicatedNodes(mylist);
        mylist.display();
    }

    private static void testDeleteDuplicatedNodes(MyLinkedList mylist) {
        mylist.deleteDuplicatedNodes();
    }

    private static void testDeleteNode(MyLinkedList mylist, Integer toDeleteValue) {
        MyLinkedList.MyListNode toDeleteNode = null;
        MyLinkedList.MyListNode traverseNode = mylist.headNode;
        while(traverseNode != null){
            if(traverseNode.data == toDeleteValue){
                toDeleteNode = traverseNode;
                break;
            }
            traverseNode = traverseNode.nextNode;
        }

        mylist.deleteNode(toDeleteNode);
    }

}

class MyLinkedList<T>{

    class MyListNode<T>{
        public T data;
        public MyListNode nextNode;

        public MyListNode(T data) {
            this.data = data;
        }
    }

    public MyListNode<T> headNode;


    //根据数组创建链表
    public MyLinkedList(T[] arr) {
        for (int i = arr.length-1; i >=0; i--) {
            MyListNode node = new MyListNode(arr[i]);
            //头插法创建链表
            node.nextNode = headNode;
            headNode = node;
        }
    }

    //展示链表元素
    public void display(){
        MyLinkedList.MyListNode pnode = this.headNode;
        while (pnode!=null){
            System.out.print(pnode.data+" ");
            pnode = pnode.nextNode;
        }
        System.out.println();
    }

    //以o(1)删除链表元素,前提toDeleteNode一定是链表中的一个节点
    public void deleteNode(MyListNode toDeleteNode){
        //如果链表只有这一个结点
        if(this.headNode.nextNode == null){
            this.headNode.data = null;
            this.headNode = null;
            toDeleteNode = null;
        }
        //如果删除的是尾结点
        else if(toDeleteNode.nextNode == null){
            MyLinkedList.MyListNode pnode = this.headNode;
            while (pnode!=null){
                if(pnode.nextNode == toDeleteNode){
                    pnode.nextNode = null;
                }
                pnode = pnode.nextNode;
            }
        }
        //其他情况
        else {
            toDeleteNode.data = toDeleteNode.nextNode.data;
            toDeleteNode.nextNode = toDeleteNode.nextNode.nextNode;
        }


    }

    // 这个问题如果链表中有一个非数据的头节点就会很简单
    public void deleteDuplicatedNodes(){
        // 为了操作方便,头插一个无数据的辅助头节点
        MyListNode headNode = new MyListNode(null);
        headNode.nextNode = this.headNode;
        this.headNode = headNode;

        MyListNode preNode = this.headNode;
        MyListNode currentNode = this.headNode.nextNode;
        boolean duplicationFlag = false;

        while(preNode != null){
            while(currentNode!= null && currentNode.nextNode!= null){
                if(currentNode.data == currentNode.nextNode.data){
                    currentNode = currentNode.nextNode;
                    duplicationFlag = true;
                }else {
                    break;
                }
            }
            if(currentNode == null || currentNode.nextNode == null){
                if(duplicationFlag == true){
                    preNode.nextNode = null;
                }
                break;
            }

            if(duplicationFlag){
                preNode.nextNode = currentNode.nextNode;
                currentNode = currentNode.nextNode;
            }else{
                preNode = preNode.nextNode;
                currentNode = currentNode.nextNode;
            }
            duplicationFlag = false;
        }

        //去除辅助节点
        this.headNode = this.headNode.nextNode;
    }







}