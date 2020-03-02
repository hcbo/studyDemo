package com.hcb.algorithm.others.debugDemo;

/**
 * https://stackoverflow.com/questions/27784413/how-to-debug-a-multi-threaded-app-in-intellij
 *
 */

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadDebugDemo {

    private static final int NUM_CLIENTS = 1000;

    static class TestRunnable implements Runnable {
        AtomicInteger lock;
        @Override
        public void run() {
            synchronized (this.lock) {
                int curCounter = this.lock.addAndGet(1);
                System.out.println("Thread: " + Thread.currentThread().getName() + "; Count: " + curCounter);
                if (curCounter >= NUM_CLIENTS) {
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(final String args[]) {
        final AtomicInteger lock = new AtomicInteger(0);
        for (int i = 0; i < NUM_CLIENTS; i++) {
            TestRunnable tr1 = new TestRunnable();
            tr1.lock = lock;
            new Thread(tr1).start();
        }
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main woken up");
        }
    }
}