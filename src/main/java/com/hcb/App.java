package com.hcb;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // 匹配以*结尾的字符串
        System.out.println("hcb*".matches(".*\\*"));
        // 匹配以\作为结尾
        System.out.println("hcb\\".matches(".*\\\\"));

//        double value = -.12e+1;
//        double value = +0;
//        double value = 233.e2;
        double value = 233.-4e2; //不行 ,因为变成233-400

        System.out.println(value);




    }
}
