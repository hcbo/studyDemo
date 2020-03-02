package com.hcb.algorithm.chapter5;


/**
 * O(n)的时间复杂度
 */

import java.util.Arrays;

public class Sward48 {
    public static void main(String[] args) {
        int num = longestSubStringWithoutDuplication("arabcacfr");
        System.out.println(num);
    }
    public static int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        //preIndexs 相当于一个hash表,存储每个字符前一次出现的位置
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];
            if (preI == -1 || curI - preI > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;
            }
            preIndexs[c] = curI;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }
}
