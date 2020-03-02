package com.hcb.algorithm.others.debugDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Drop frame 虽然会回退到上层函数栈,但是副作用是会存在的,
 * 对于幂等的函数是没有影响的,因为执行几次结果都一样
 *
 */
public class DropFrameDemo
{
    public static void main( String[] args )
    {

        List list = new ArrayList();
        list.add(1);
        addElem(list);






    }

    private static void addElem(List list) {
        list.add(5);
    }
}
