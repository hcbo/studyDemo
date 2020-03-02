package com.hcb.algorithm.chapter6;



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Sword59 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList =
                new Sword59().maxInWindows2(new int[]{2,3,4,2,6,2,5,1},3);

    }

    //最好情况,即数组递增时间复杂度2n,遍历n次,并且每次之前均只有一个需要比较的.
    // 最差情况,(k/2)*n,遍历n次,并且每次之前k/2个需要比较的.
    public ArrayList<Integer> maxInWindows2(int [] num, int size){
        ArrayList<Integer> max = new ArrayList<Integer>();
        if(num==null || num.length<=0 || size<=0 || size>num.length)
            return max;
        ArrayDeque<Integer> indexDeque = new ArrayDeque<Integer>();

        for(int i=0;i<size-1;i++){
            while(!indexDeque.isEmpty() && num[i]> num[indexDeque.getLast()])
                indexDeque.removeLast();
            indexDeque.addLast(i);
        }

        for(int i=size-1;i<num.length;i++){
            while(!indexDeque.isEmpty() && num[i]> num[indexDeque.getLast()])
                indexDeque.removeLast();
            if(!indexDeque.isEmpty() && (i-indexDeque.getFirst())>=size)
                indexDeque.removeFirst();
            indexDeque.addLast(i);
            max.add(num[indexDeque.getFirst()]);
        }

        return max;
    }


    //2(logk)*(n-k)的时间复杂度
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        /* 大顶堆 */
        for (int i = 0; i < size; i++)
            heap.add(num[i]);

        ret.add(heap.peek());

        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            /* 维护一个大小为 size 的大顶堆 */
            // 堆中删除任意一个元素,o(logk)
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
