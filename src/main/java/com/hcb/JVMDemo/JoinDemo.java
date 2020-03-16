package com.hcb.JVMDemo;




import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JoinDemo implements Runnable{

    @Override
    public void run() {
        System.out.printf("Beginning data sources loading: %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data sources loading has finished: %s\n",new Date());
    }

    public static void main(String[] args){
        JoinDemo dsLoader = new JoinDemo();
        Thread thread1 = new Thread(dsLoader,"DataSourceThread");

        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Configuration has been loaded: %s\n",new Date());
    }

}