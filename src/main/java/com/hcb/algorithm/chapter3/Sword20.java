package com.hcb.algorithm.chapter3;

/**
 * 该题c++代码位于/Users/hcb/Desktop/cpp_work/project/algorithm/sword20.cpp
 * 在模拟c++代码编写java代码时,需要实现对出入方法的参数的修改,java怎么实现呢?
 * https://blog.csdn.net/sinat_22013331/article/details/51150358
 * 按照上面的博客,我们可以将String的value和pointer进行封装.
 */

public class Sword20 {
    public static void main(String[] args) {
        // true
//        String value = "+123.45e+6";
//        String value = "+123";
//        String value = "5e2";
//        String value = "-123";
//        String value = "3.1416";
        String value = "-1E-16";
        // false
//        String value = "12e";
//        String value = "1a3.14";
//        String value = "1.2.3";
//        String value = "+-5";
//        String value = "12e+4.3";
        boolean flag1 = isNumerical(value);
        boolean flag2 = isNumeric(value);
        System.out.println(flag1);
        System.out.println(flag2);

    }
    private class MyValue{
        String value;
        int pointer;
        public MyValue(String value, int pointer) {
            this.value = value;
            this.pointer = pointer;
        }

    }

    private static boolean isNumerical(String value) {
        MyValue myValue = new Sword20().new MyValue(value,0);
        boolean numeric = false;
        numeric = scanUnsignedInteger(myValue);
        if(myValue.pointer < myValue.value.length() &&
                myValue.value.charAt(myValue.pointer) == '.'){
            myValue.pointer++;
            // 小数点前或小数点不能同时没有Interger,只有一个没有Integer也符合 比如.123  233.
            numeric = scanInteger(myValue) || numeric;
        }

        if(myValue.pointer < myValue.value.length() &&
                (myValue.value.charAt(myValue.pointer) == 'e' ||
                myValue.value.charAt(myValue.pointer) == 'E')){
            myValue.pointer++;
            // e前边和后边必须都有Integer
            numeric = numeric && scanUnsignedInteger(myValue);
        }
        return numeric && myValue.pointer == myValue.value.length();
    }

    private static boolean scanUnsignedInteger(MyValue myValue) {
        if(myValue.pointer >= myValue.value.length()){
            return false;
        }
        if(myValue.value.charAt(myValue.pointer) == '+' ||
                myValue.value.charAt(myValue.pointer) == '-' ){
            myValue.pointer++;
        }
        return scanInteger(myValue);
    }

    private static boolean scanInteger(MyValue myValue) {
        if(myValue.pointer >= myValue.value.length()){
            return false;
        }
        int before = myValue.pointer;
        while(myValue.pointer < myValue.value.length() &&
                myValue.value.charAt(myValue.pointer) >= '0' &&
                myValue.value.charAt(myValue.pointer) <= '9'){
            myValue.pointer++;
        }
        return myValue.pointer > before;
    }


    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0)
            return false;
        return str.matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
