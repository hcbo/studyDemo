package com.hcb.algorithm.others;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {

    /**
     * 入队 offer 左入
     * 出队 poll  右出
     * 入栈 push  右入
     * 出栈 pop   右出
     * ArrayDeque的poll和pop实现一样,都是调用pollFirst
     */
    public static void main(String[] args) {
        Deque<Integer> mDeque = new ArrayDeque<Integer>();

        for(int i=0;i<5;i++){
            mDeque.offer(i);
        }

        mDeque.push(100);
        print(mDeque);
        System.out.println(mDeque.poll());
        System.out.println(mDeque.pop());

        System.out.println(mDeque.peek());

        System.out.println("***********集合方式遍历**********");

        //集合方式遍历，元素不会被移除
        for (Integer x : mDeque) {
            System.out.println(x);
        }

        System.out.println("**********遍历队列*************");

        //队列方式遍历，元素逐个被移除
        while (mDeque.peek() != null) {
            System.out.println(mDeque.poll());
        }

        System.out.println("***********进栈操作************");

        mDeque.push(10);
        mDeque.push(15);
        mDeque.push(24);
        print(mDeque);

        System.out.println("*********出栈操作*************");

        System.out.println(mDeque.pop());
    }

    public static void print(Deque<Integer> queue){
        //集合方式遍历，元素不会被移除
        for (Integer x : queue) {
            System.out.println(x);
        }
    }
}