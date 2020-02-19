package com.hcb.algorithm.chapter3;

public class Sword22 {
    public static void main(String[] args) {
//        Integer[] arr = {1,2,2,3,4,4,4,5,6,7,7};
        Integer[] arr = {1,2};
        MyLinkedList mylist = new MyLinkedList(arr);
        mylist.display();
        showElemBackwards(mylist,2);
    }

    private static void showElemBackwards(MyLinkedList mylist, int k) {
        if(mylist == null || mylist.headNode == null){
            System.out.println("list have no elements ! ");
        }
        if(k <= 0){
            System.out.println("k must be larger than 0 !");
        }
        MyLinkedList.MyListNode traverseNode = mylist.headNode;
        MyLinkedList.MyListNode pointer = null;
        int count = 0;
        while(traverseNode != null){
            traverseNode = traverseNode.nextNode;
            count++;
            if(pointer != null){
                pointer = pointer.nextNode;
            }
            if(count == k){
                pointer = mylist.headNode;
            }
        }
        if(count < k){
            System.out.println("k is larger than length of the list!");
        } else{
            System.out.println(pointer.data);
        }

    }
}
