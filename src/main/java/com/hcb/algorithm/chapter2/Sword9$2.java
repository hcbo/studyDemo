package com.hcb.algorithm.chapter2;

import java.util.LinkedList;
import java.util.Queue;

public class Sword9$2 {
    public static void main(String[] args) throws Exception {
        MyStack<Character> myStack = new MyStack<>();
        myStack.push('a');
        myStack.push('b');
        myStack.push('c');
        System.out.println(myStack.pop());
        myStack.push('d');
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }
}
class MyStack<T>{
    private Queue<T> queue1;
    private Queue<T> queue2;
    public MyStack(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    public void push(T item){
        if(!queue1.isEmpty()){
            queue1.add(item);
        }else {
            queue2.add(item);
        }
    }
    public T pop() throws Exception {
        if(queue1.isEmpty()&&queue2.isEmpty()){
            throw new Exception("stack size is 0!can not pop!");
        }
        if(!queue1.isEmpty()){
            int count = queue1.size();
            for (int i = 1; i <= count-1; i++) {
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        }else {
            int count = queue2.size();
            for (int i = 1; i <= count-1; i++) {
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        }
    }
}
