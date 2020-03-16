package com.hcb.JVMDemo;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 10个人依次过来,凑够5个就发车
 */
public class CyclicBarrierDemo {

    private final static int NUM = 5;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM,new BarrierAction());
        for (int i = 0; i < 10; i++) {
            new Thread(new CyclicBarrierRunnable(cyclicBarrier,i)).start();

        }

    }


    static class CyclicBarrierRunnable implements Runnable {
        CyclicBarrier barrier1 = null;

        private int no = 0;

        public CyclicBarrierRunnable(CyclicBarrier barrier1, int no) {
            this.barrier1 = barrier1;
            this.no = no;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
                if(no ==4 ||no ==7){
                    Thread.sleep(3000);
                }

                this.barrier1.await();
                System.out.println(Thread.currentThread().getName() + " done!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();

            }

        }
    }

    static class BarrierAction implements  Runnable{

        @Override
        public void run() {
            System.err.println("发车");
        }
    }
}

