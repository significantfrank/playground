package com.alibaba.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * MinRemoveToMakeValid
 *
 * @author Frank Zhang
 * @date 2021-05-26 12:43 PM
 */
public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        String s = "lee(((t(c)o)de)";
        char[] chars = s.toCharArray();
        Queue<Character> queue = new LinkedList();
        for(char c : chars){
            if(c == '('){
                queue.add(c);
            }
            if(c == ')'){
                if(queue.peek() !=null && queue.peek() == '('){
                    queue.remove();
                }
                else {
                    queue.add(c);
                }
            }
        }
        System.out.println(queue);
    }
}
