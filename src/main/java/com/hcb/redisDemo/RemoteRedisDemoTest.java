package com.hcb.redisDemo;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RemoteRedisDemoTest {

    @Test
    public void redisTester() {
        Jedis jedis = new Jedis("39.104.126.240", 6379, 100000);
        jedis.auth("201061032");
        int i = 0;
        try {
            long start = System.currentTimeMillis();// 开始毫秒数
            while (true) {
                long end = System.currentTimeMillis();
                if (end - start >= 1000) {// 当大于等于1000毫秒（相当于1秒）时，结束操作
                    break;
                }
                i++;
                jedis.set("test" + i, i + "");

            }
        } finally {// 关闭连接
            jedis.close();
        }
        // 打印1秒内对Redis的操作次数
        System.out.println("redis每秒操作：" + (i+1) + "次");
    }

    @Test
    public void redisTester2() {
        Jedis jedis = new Jedis("39.104.126.240", 6379, 100000);
        jedis.auth("201061032");
        int sum=20;
        try {
            for (int i = 0; i < sum; i++) {
                jedis.del("test" + i);
            }

        } finally
        {// 关闭连接
            jedis.close();
        }
        // 打印1秒内对Redis的操作次数
//            System.out.println("redis每秒操作："+i +"次");

    }
}
