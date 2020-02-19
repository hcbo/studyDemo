package com.hcb.algorithm.chapter3;

public class Sword22$2 {
    public static void main(String[] args) {
        //        Integer[] arr = {1,2,2,3,4,4,4,5,6,7,7};
        Integer[] arr = {1,2,3,4,5,6};
        MyLinkedList mylist = new MyLinkedList(arr);
        mylist.display();
        showMidElem(mylist);
    }

    private static void showMidElem(MyLinkedList mylist) {
        MyLinkedList.MyListNode fastPointer = mylist.headNode;
        MyLinkedList.MyListNode slowPointer = mylist.headNode;
        int step = 1;
        while(fastPointer != null){
            fastPointer = fastPointer.nextNode;
            step++;
            if(step%2 == 1){
                slowPointer = slowPointer.nextNode;
            }
        }
        System.out.println(slowPointer.data);
    }
}
