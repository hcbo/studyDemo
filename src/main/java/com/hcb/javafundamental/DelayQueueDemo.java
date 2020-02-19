package com.hcb.javafundamental;

/**
 * https://www.jianshu.com/p/bf9f6b08ba5b
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {

    public static void main(String[] args) throws Exception {
        BlockingQueue<Task> delayqueue = new DelayQueue<>();
        long now = System.currentTimeMillis();
        delayqueue.put(new Task(now+3000));
        delayqueue.put(new Task(now+4000));
        delayqueue.put(new Task(now+6000));
        delayqueue.put(new Task(now+1000));
        System.out.println(delayqueue);

        for(int i=0; i<4; i++) {
            System.out.println(delayqueue.take());
        }

    }

    static class Task implements Delayed {
        long time = System.currentTimeMillis();
        public Task(long time) {
            this.time = time;
        }
        @Override
        public int compareTo(Delayed o) {
            if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else
                return 0;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }
        @Override
        public String toString() {
            return "" + time;
        }
    }
}

