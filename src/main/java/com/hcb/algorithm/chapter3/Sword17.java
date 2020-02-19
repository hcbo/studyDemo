package com.hcb.algorithm.chapter3;

/**
 * 此题用StringBuilder比String好，原因是String为不可变对象
 */
public class Sword17 {
    public static void main(String[] args) {
        int n = 86;
        // 86 位
        StringBuilder sb = new StringBuilder("99999999999999999999999999999999999999999999999999999999999999999999999999999999999911");
        while(sb.length()<=n){
            System.out.println(sb);
            sb = addOne(sb);
        }

    }

    private static StringBuilder addOne(StringBuilder sb) {
        int index = sb.length()-1;
        boolean carryFlag = true;
        while(carryFlag){
            if(index == -1){
                sb.insert(0,'1');
                break;
            }
            sb.replace(index,index+1,alterChar(sb.charAt(index)));
            if(sb.charAt(index)=='0'){
                index--;
            }else {
                carryFlag = false;
            }
        }
        return sb;
    }

    private static String alterChar(char charAt) {
        String res = "";
        if(charAt=='9'){
            res = "0";
        }else {
            res = (char)((int)charAt+1)+"";
        }
        return res;
    }
}
