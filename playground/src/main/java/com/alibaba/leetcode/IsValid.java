package com.alibaba.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * IsValid
 *
 * @author Frank Zhang
 * @date 2021-05-26 2:33 PM
 */
public class IsValid {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){
        Deque<Character> q = new LinkedList();
        char[] chars = s.toCharArray();
        for(char c: chars){
            if(c == '(' || c=='{' || c=='['){
                q.push(c);
            }
            if(c == ')' && q.peek() == '('){
                q.pop();
            }
            if(c == '}' && q.peek() == '{'){
                q.pop();
            }
            if(c == ']' && q.peek() == '['){
                q.pop();
            }
        }
        return q.isEmpty();
    }
}
