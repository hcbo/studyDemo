package com.hcb.JVMDemo;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader myLoader = ClassLoader.getSystemClassLoader();
        try {
            Class myClass = Class.forName(ClassLoaderDemo.class.getName(),true,myLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    void show(){
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(this.getClass().getClassLoader());

    }


}
