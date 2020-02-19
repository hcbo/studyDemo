package com.hcb.algorithm.chapter2;
/**
 * 两个栈模拟一个队列
 */

import java.util.Stack;

public class Sword9 {
    public static void main(String[] args) throws Exception {
        MyQueue<Character> queue = new MyQueue<>();
        queue.appendTail('a');
        queue.appendTail('b');
        queue.appendTail('c');
        System.out.println(queue.deleteHead());
        queue.appendTail('d');
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());

    }
}
class MyQueue<T>{
    private Stack<T> stack1;
    private Stack<T> stack2;
    public MyQueue(){
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }
    public void appendTail(T item){
        stack1.push(item);
    }
    public T deleteHead() throws Exception {
        if(stack2.empty()){
            if(stack1.empty()){
                throw new Exception("queue size is 0!can not pop!");
            }else{
                while(!stack1.empty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }

        }else{
            return stack2.pop();
        }
    }
}
