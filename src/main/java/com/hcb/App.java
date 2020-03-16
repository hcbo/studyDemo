package com.hcb;

import org.checkerframework.checker.units.qual.C;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public App() {
        System.out.println("构造器调用了");
    }

    public static void main(String[] args ) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        // 匹配以*结尾的字符串
        System.out.println("hcb*".matches(".*\\*"));
        // 匹配以\作为结尾
        System.out.println("hcb\\".matches(".*\\\\"));

//        double value = -.12e+1;
//        double value = +0;
//        double value = 233.e2;
        double value = 233.-4e2; //不行 ,因为变成233-400


        System.out.println(4^6);

        System.out.println(value);
        App app = new App();
        System.out.println(app.hashCode());

        String s = "hello world";
        Field valueFieldOfString = String.class.getDeclaredField("value");
        valueFieldOfString.setAccessible(true);

        char[] value1 = (char[]) valueFieldOfString.get(s);
        value1[5] = '_';
        System.out.println("s = " + s);

        App.class.newInstance();


        byte a=1;

//        a=a+4;
        a+=4;
        System.out.println(a);







    }


}
