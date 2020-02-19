package com.hcb.algorithm.chapter4;

public class Sword38$2 {
    public static void main(String[] args) {
        printCombination("abcde",3);
    }

    private static void printCombination(String string, int num) {
        char[] chars = string.toCharArray();
        printCombinationRec(chars,0,num,new StringBuilder());
    }

    private static void printCombinationRec(char[] chars, int start, int num, StringBuilder str) {
        if(str.length() == 3){
            System.out.println(str);
            return;
        }
        for (int j = start; j < chars.length; j++) {
            str.append(chars[j]);
            printCombinationRec(chars,j+1,num-1, str);
            str.deleteCharAt(str.length()-1);
        }
    }
}
