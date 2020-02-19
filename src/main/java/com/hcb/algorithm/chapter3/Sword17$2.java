package com.hcb.algorithm.chapter3;

public class Sword17$2 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("-12345");
        StringBuilder sb2 = new StringBuilder("0");
        StringBuilder sb3 = addTwoNum(sb1,sb2);
        System.out.println(sb3);
    }

    private static StringBuilder addTwoNum(StringBuilder sb1, StringBuilder sb2) {
        StringBuilder res = new StringBuilder("");
        int index1 = 0;
        int index2 = 0;
        // 进/借位标记
        int carryFlag = 0;
        // 符号标记
        boolean isPositive = true;
        int posValue = 0;


        // 如果异号,结果为绝对值大的减去绝对值小的,结果的符号位绝对值大的符号位相同
        if((sb1.charAt(0)=='-')^ (sb2.charAt(0)=='-')){
            StringBuilder minuend ;
            StringBuilder subtrahend ;
            //保证符号位跟随绝对值大的,保证被减数绝对值比减数绝对值大,且被减数和减数都去掉负号
            if(absComp(sb1,sb2)>0){
                minuend = new StringBuilder(sb1);
                subtrahend = new StringBuilder(sb2);
                if(sb1.charAt(0)=='-'){
                    isPositive = false;
                    minuend.deleteCharAt(0);
                }else {
                    subtrahend.deleteCharAt(0);
                }
            }else if(absComp(sb1,sb2)==0){
                return res.append('0');
            }else {
                minuend = new StringBuilder(sb2);
                subtrahend = new StringBuilder(sb1);
                if(sb2.charAt(0)=='-'){
                    isPositive = false;
                    minuend.deleteCharAt(0);
                }else {
                    subtrahend.deleteCharAt(0);
                }
            }

            //用0对齐subtrahend
            align(subtrahend,minuend.length()-1,subtrahend.length()-1);

            int index = minuend.length()-1;
            while (index>=0){
               posValue = minuend.charAt(index)-subtrahend.charAt(index)-carryFlag;
               if(posValue<0){
                   posValue = posValue+10;
                   carryFlag = 1;
               }
               else {
                   carryFlag = 0;
               }
               res.insert(0,(char)(posValue+'0'));
               index--;
            }

            if(!isPositive){
                res.insert(0,'-');
            }
            return res;

        }
        // 如果同号
        else {
            int index = 0;
            if(sb1.charAt(0)=='-'){
                sb1.deleteCharAt(0);
                sb2.deleteCharAt(0);
                isPositive = false;
            }
            index1 = sb1.length()-1;
            index2 = sb2.length()-1;
            // 前面用0对齐
            if(index1<index2){
                align(sb1,index1,index2);
                index = index2;
            }else {
                align(sb2,index1,index2);
                index = index1;
            }
            while (index>=0){
                posValue = (sb1.charAt(index)-'0')+(sb2.charAt(index)-'0')+carryFlag;
                if(posValue>=10){
                    carryFlag = 1;
                }else {
                    carryFlag = 0;
                }
                res.insert(0,(char)(posValue%10+'0'));
                index--;
            }
            if(carryFlag==1){
                res.insert(0,(char)(1+'0'));
            }
            if(!isPositive){
                res.insert(0,'-');
            }
        }
        return res;

    }

    private static int absComp(StringBuilder sb1, StringBuilder sb2) {
        StringBuilder s1 = new StringBuilder(sb1);
        StringBuilder s2 = new StringBuilder(sb2);
        // 它们两个肯定是异号
        if(s1.charAt(0)=='-'){
            s1.deleteCharAt(0);
        }else {
            s2.deleteCharAt(0);
        }
        if(s1.length()>s2.length()){
            return 1;
        }else if(s1.length()<s2.length()){
            return -1;
        }else {
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i)>s2.charAt(i)){
                    return 1;
                }else if(s1.charAt(i)<s2.charAt(i)){
                    return -1;
                }else {
                    continue;
                }
            }
            return 0;
        }
    }



    private static void align(StringBuilder sb,int index1,int index2) {
        int times = Math.abs(index1-index2);
        for(int i = 1;i<=times;i++){
            sb.insert(0,'0');
        }
    }
}
