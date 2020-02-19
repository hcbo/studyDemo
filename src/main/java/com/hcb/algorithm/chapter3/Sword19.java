package com.hcb.algorithm.chapter3;

/**
 * pattern的指针是不会指向'*'的,因为当pattern指针的后一个字符是*时,pattern指针要么不动,
 * 要么向后两位.
 * 同时,控制调用者对于"**"的使用,因为这样没有意义.
 *
 * ".*"可以匹配任意字符串
 *
 * https://blog.csdn.net/hll174/article/details/51001253
 */

public class Sword19 {
    public static void main(String[] args) {
        String str = "aaa";

//        匹配以b作为结尾的字符串
//        String pattern = ".*b";

//        String pattern = ".*a";

////        ".*"能匹配任意字符串
//        String pattern = ".*";

//        String pattern = "ab*ac*a";
        String pattern =  "ab*a";
        boolean isMatch = match(str,pattern);
        System.out.println(isMatch);
    }

    private static boolean match(String str, String pattern) {
        return matchNext(str,0,pattern,0);
    }

    private static boolean matchNext(String str, int strIndex, String pattern, int patternIndex) {
        // 出口
        if(strIndex >= str.length() && patternIndex >= pattern.length()){
            return  true;
        }
        if(patternIndex >= pattern.length() && strIndex < str.length()){
            return false;
        }
        if(strIndex >= str.length() && patternIndex < pattern.length()){
            if(patternIndex+1 >= pattern.length()){
                return false;
            }else {
                if(pattern.charAt(patternIndex+1) == '*'){
                    return matchNext(str,strIndex,pattern,patternIndex+2);
                }else {
                    return false;
                }
            }
        }

        //两个指针均指向字符串中的字符时

        // 当下一个字符不是*
        if(patternIndex+1 >= pattern.length() || pattern.charAt(patternIndex+1) != '*'){
            if(pattern.charAt(patternIndex) == '.' || str.charAt(strIndex) == pattern.charAt(patternIndex)){
                return matchNext(str,strIndex+1,pattern,patternIndex+1);
            }else {
                return false;
            }
        }

        // 下一个是*
        else {
            if(pattern.charAt(patternIndex) == '.' || str.charAt(strIndex) == pattern.charAt(patternIndex)){
                return matchNext(str,strIndex,pattern,patternIndex+2) ||
                        matchNext(str,strIndex+1,pattern,patternIndex+2) ||
                        matchNext(str,strIndex+1,pattern,patternIndex);
            }else {
                return matchNext(str,strIndex,pattern,patternIndex+2);
            }
        }


    }
}
