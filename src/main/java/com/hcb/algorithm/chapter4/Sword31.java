package com.hcb.algorithm.chapter4;

import java.util.Stack;

public class Sword31 {
    public static void main(String[] args) {
        int[] inSeq = {1,2,3,4,5};
//        int[] outSeq = {4,5,3,2,1};
        int[] outSeq = {4,3,5,1,2};
        boolean isFit = verifyStackSeq(inSeq,outSeq);
        System.out.println(isFit);
    }

    private static boolean verifyStackSeq(int[] inSeq, int[] outSeq) {
        Stack stack = new Stack();
        int outSeqPos = 0;
        int inSeqPos = 0;
        while (outSeqPos < outSeq.length){
            while (inSeqPos < inSeq.length &&
                    inSeq[inSeqPos] != outSeq[outSeqPos]){
                stack.push(inSeq[inSeqPos]);
                inSeqPos++;
            }
            if(inSeqPos == inSeq.length){
                return false;
            }
            stack.push(inSeq[inSeqPos]);
            inSeqPos++;


            while(!stack.empty()
                    && (int)stack.peek() == outSeq[outSeqPos]){
                stack.pop();
                outSeqPos++;
            }
        }
        return (stack.empty() && inSeqPos == inSeq.length
                && outSeqPos == outSeq.length);

    }
}
