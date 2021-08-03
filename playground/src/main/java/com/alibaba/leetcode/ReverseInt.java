package com.alibaba.leetcode;

import java.util.Stack;

/**
 * ReverseInt
 *
 * @author Frank Zhang
 * @date 2021-05-25 8:57 PM
 */
public class ReverseInt {
    public static void main(String[] args) {
        int x  = -1234445;
        String negative = "";
        if (x <0){
            x = Math.abs(x);
            negative = "-";
        }
        String xStr = x +"";
        Stack stack = new Stack();
        for(int i=0; i<xStr.length(); i++){
            stack.push(xStr.charAt(i));
        }
        String revStr = "";
        while (!stack.isEmpty()){
            revStr = revStr + stack.pop();
        }
        System.out.println(negative +revStr);
    }
}
