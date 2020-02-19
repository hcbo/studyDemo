package com.hcb.javafundamental;

import com.alibaba.fastjson.JSON;

public class GenerateDemo {
    public static void main(String[] args) {

        String str = beanToString(new Integer(9));
        System.out.println(str);

    }
    public static <T> String beanToString(T value) {
        if(value == null) {
            return null;
        }

        //Class<?> 中的 ? 是通配符，其实就是表示任意符合泛类定义条件的类，
        // 和直接使用 Class 效果基本一致，但是这样写更加规范，在某些类型转换时可以避免不必要的 unchecked 错误。
        Class<?> clazz = value.getClass();
        if(clazz == int.class || clazz == Integer.class) {
            return ""+value;
        }else if(clazz == String.class) {
            return (String)value;
        }else if(clazz == long.class || clazz == Long.class) {
            return ""+value;
        }else {
            return JSON.toJSONString(value);
        }
    }
    public static <T> T stringToBean(String str, Class<T> clazz) {
        if(str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if(clazz == int.class || clazz == Integer.class) {
            return (T)Integer.valueOf(str);
        }else if(clazz == String.class) {
            return (T)str;
        }else if(clazz == long.class || clazz == Long.class) {
            return  (T)Long.valueOf(str);
        }else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }
}
