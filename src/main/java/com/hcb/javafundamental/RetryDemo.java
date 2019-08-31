package com.hcb.javafundamental;

public class RetryDemo {
    public static void main(String[] args) {
        retryTest1();
    }

    /**
     * retry 标记在了上层循环中,所以continue继续执行的是上层循环中的内容
     */
    public static void  retryTest1(){
        retry:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(j);
                if(j==3){
                    continue retry;
                }
            }

        }
    }
    /**
     * retry 标记在了上层循环中,所以break跳出的是上层循环
     */
    public static void  retryTest2(){
        retry:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(j);
                if(j==3){
                    break retry;
                }
            }

        }
    }
}
