package com.hcb.algorithm.chapter4;

import java.util.ArrayList;
import java.util.Arrays;

public class Sword38 {

    public static void main(String[] args) {
//        ArrayList<String> strings = myPermutation("abc");
//        ArrayList<String> strings = Permutation("abcb");
//        ArrayList<String> strings = Permutation("bbc");
        ArrayList<String> strings = Permutation2("bbc");
    }



    private static ArrayList<String> ret = new ArrayList<>();

    /**
     * 剑指offer书上的,当有重复元素时,生成的重复序列没有过滤,所以结果会有重复序列
     * @param str
     * @return
     */
    private static ArrayList<String> myPermutation(String str) {
        if (str.length() == 0)
            return ret;
        char[] chars = str.toCharArray();
        backtracking2(chars,0,new StringBuilder());
        return ret;
    }
    private static void backtracking2(char[] chars, int start ,StringBuilder s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for (int i = start; i <chars.length ; i++) {
            char tmp = chars[start];
            chars[start] = chars[i];
            chars[i] = tmp;
            s.append(chars[start]);
            backtracking2(chars,start+1,s);
            s.deleteCharAt(s.length()-1);
            tmp = chars[start];
            chars[start] = chars[i];
            chars[i] = tmp;
        }
    }


    /**
     * 能去除重复序列
     * @param str
     * @return
     */
    public static ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }
    private static void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) /* 保证不重复 */
                continue;
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

    // 另一种解法，也是借助回溯法，不能去除重复序列
    private static ArrayList<String> Permutation2(String s) {
        if (s == null) {
            return null;
        } else {
            ArrayList<String> list = new ArrayList<>();
            char[] chars = s.toCharArray();
            backReaceing(s, 0, list, new StringBuilder());
            return list;
        }
    }
    private static void backReaceing(String s, int start, ArrayList<String> list, StringBuilder sb) {
        if (sb.length() < s.length()) {
            for (int i = 0; i <= start; i++) {
                sb.insert(i, s.charAt(start));
                backReaceing(s, start + 1, list, sb);
                sb.deleteCharAt(i);
            }
        } else {
            list.add(sb.toString());
        }
    }
}
