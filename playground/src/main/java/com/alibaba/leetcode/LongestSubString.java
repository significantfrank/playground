package com.alibaba.leetcode;

import java.util.HashSet;

/**
 * LongestSubString
 *
 * @author Frank Zhang
 * @date 2021-05-25 7:52 PM
 */
public class LongestSubString {
    public static void main(String[] args) {
        String s = "abcdefddsdd";
        HashSet subString = new HashSet();
        int max = 0;
        for (int i=0; i<s.length(); i++){
            int j = i + 1;
            subString.add(s.charAt(i));
            for (;j<s.length();j++){
                if(!subString.add(s.charAt(j))){
                    if((j-i) > max){
                        max = (j-i);
                    }
                    break;
                }
            }
        }

        System.out.println("LongestSubStringNumber : "+max);
    }
}
