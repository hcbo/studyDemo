package com.hcb.algorithm.chapter3;

/**
 * 1) 怎么判断链表有环? 维持快慢两个指针,fastStep = 2,slowStap = 1,快的一定会在某一位置与慢的重合.
 * 2) 怎么得到环的入口? 维持先后两个指针,间隔为环的长度,步速一样,都是一步一步走,先出发指针和后出发指针重合的位置就是环的入口.
 * 3) 怎么得到环的长度? 根据第一个问题, 相遇时(即扣了一圈),快指针遍历的节点数目-慢指针遍历的节点数目 就是环中节点的个数,即环的长度.
 */

public class Sword23 {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};
        MyLinkedList normalList = new MyLinkedList(arr);
        normalList.display();
        // 构造题目中的链表
        MyLinkedList cusList = generateCustomList(normalList,4);
//        MyLinkedList cusList = generateCustomList(normalList,8);
//        cusList.display();
        // 先判断是否有环,有环的话把环的长度得到
        int len = getCircleLen(cusList);
        System.out.println(len);
        MyLinkedList.MyListNode enterPointer = getCircleEnter(cusList,len);
        System.out.println(enterPointer.data);

    }

    private static MyLinkedList.MyListNode getCircleEnter(MyLinkedList cusList, int len) {
        if(len == 0){
            return null;
        }
        MyLinkedList.MyListNode prePointer = cusList.headNode;
        MyLinkedList.MyListNode postPointer = cusList.headNode;
        int count = 0;
        while(true){
            prePointer = prePointer.nextNode;
            count++;
            if(count > len){
                postPointer = postPointer.nextNode;
            }
            if(postPointer == prePointer && prePointer != null){
                return postPointer;
            }
        }
    }

    /**
   * @Description: as you see
   * @Param: [cusList]
   * @return: int 如果是0表示没有环,否则表示环长度
   * @Author: hcb
   * @Date: 2020-02-03
   */
    private static int getCircleLen(MyLinkedList cusList) {
        MyLinkedList.MyListNode fastPointer = cusList.headNode;
        MyLinkedList.MyListNode slowPointer = cusList.headNode;
        int count = 0;
        while(fastPointer.nextNode != null && fastPointer.nextNode.nextNode != null){
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
            count++;
            if(slowPointer == fastPointer && slowPointer != null){
                return count*2 - count;
            }
        }
        return 0;
    }

    private static MyLinkedList generateCustomList(MyLinkedList normalList,Integer value) {
        MyLinkedList.MyListNode traversePointer = normalList.headNode;
        MyLinkedList.MyListNode stonePointer = null;
        while(traversePointer.nextNode != null){
            if(traversePointer.data == value){
                stonePointer = traversePointer;
            }
            traversePointer = traversePointer.nextNode;
        }
        // 退出循环后,traversPointer.nextNode为空,但是traversPointer不为空,所以要另外处理
        if(traversePointer.data == value){
            stonePointer = traversePointer;
        }
        traversePointer.nextNode = stonePointer;
        return normalList;
    }




}
