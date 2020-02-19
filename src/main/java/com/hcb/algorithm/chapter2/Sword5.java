package com.hcb.algorithm.chapter2;

import java.util.Scanner;

/**
 *
 *
 */
public class Sword5
{
    public static void main( String[] args )
    {
        // 将标准输入的字符串存到字符数组
        char[] target = new char[50];
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int i = 0;
        for ( i = 0; i < str.length(); i++) {
            target[i] = str.charAt(i);
        }
        target[i] = '\0';

        System.out.println(String.valueOf(target));

        int afterPos = 0;
        int beforePos = 0;
        int blankCount = 0;
        for (int j = 0; j < target.length; j++) {
            if(target[j] == '\0'){
                beforePos = j-1;
                break;
            }
            if(target[j] == ' '){
                blankCount++;
            }
        }
        afterPos = beforePos + 2*blankCount;
        while(beforePos >= 0){
            if(target[beforePos] == ' '){
                target[afterPos--] = '0';
                target[afterPos--] = '2';
                target[afterPos--] = '%';
            }else {
                target[afterPos--] = target[beforePos];
            }
            beforePos--;
        }
        System.out.println(String.valueOf(target));
    }
}
