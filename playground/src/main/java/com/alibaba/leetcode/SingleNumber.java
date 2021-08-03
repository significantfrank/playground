package com.alibaba.leetcode;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

/**
 * SingleNumber
 *
 * @author Frank Zhang
 * @date 2021-05-25 9:11 PM
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};

        HashSet<Integer> resultSet = new HashSet();

        for (int i=0; i<nums.length; i++){
            if(! resultSet.add(nums[i])){
                resultSet.remove(nums[i]);
            }
        }

        resultSet.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(resultSet);
    }
}
