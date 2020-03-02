package com.hcb.algorithm.chapter5;

import java.util.Arrays;

/**
 * 可以看成是⼀个排序问题，在⽐较两个字符串 S1 和 S2 的⼤⼩时，应该⽐较的是 S1+S2 和 S2+S1 的⼤ ⼩，如果 S1+S2 < S2+S1，那么应该把 S1 排在前⾯，否则应该把 S2 排在前⾯。
 */

public class Sword45 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++)
            nums[i] = numbers[i] + "";
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
    /*
    传统的写法
	Arrays.sort(str,new Comparator<String>(){
           	@Override
          	public int compare(String s1, String s2) {
            	String c1 = s1 + s2;
            	String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
    });
    */
        String ret = "";
        for (String str : nums)
            ret += str;
        return ret;
    }


    public static void main(String[] args) {
        String str = new Sword45().PrintMinNumber(new int[]{3,32,321});
        System.out.println(str);
    }
}
