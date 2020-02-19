package com.hcb.algorithm.chapter3;

public class Sword24 {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};
        MyLinkedList normalList = new MyLinkedList(arr);
        normalList.display();
//        reverseList(normalList);
//        normalList.display();
        // 递归方法 传入的参数一定是节点,因为每个都是平等的
        MyLinkedList.MyListNode head = recurseReverseList(normalList.headNode);
        normalList.headNode = head;
        normalList.display();
    }
    /**
    * @Description: 递归方法
    * @Param: [head]
    * @return: com.hcb.algorithm.chapter3.MyLinkedList.MyListNode
    * @Author: hcb
    * @Date: 2020-02-04
    */
    private static MyLinkedList.MyListNode recurseReverseList(MyLinkedList.MyListNode head) {
        if(head.nextNode == null){
            return head;
        }else {
            MyLinkedList.MyListNode next = head.nextNode;
            head.nextNode = null;
            MyLinkedList.MyListNode newHead = recurseReverseList(next);
            next.nextNode = head;
            return newHead;
        }
    }


    private static void reverseList(MyLinkedList normalList) {
        MyLinkedList.MyListNode prePointer = null;
        MyLinkedList.MyListNode pointer = normalList.headNode;
        MyLinkedList.MyListNode postPoiner = pointer.nextNode;
        while(pointer != null){
            pointer.nextNode = prePointer;
            prePointer = pointer;
            pointer = postPoiner;
            if(postPoiner != null){
                postPoiner = postPoiner.nextNode;
            }else {
                break;
            }
        }
        normalList.headNode = prePointer;

    }
}
