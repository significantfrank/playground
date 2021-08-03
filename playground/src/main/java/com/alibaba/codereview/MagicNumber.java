package com.alibaba.codereview;

/**
 * MagicNumber
 *
 * 1) 不满足OCP原则，可以把判断抽象出来
 * 2）判断质数有性能问题，不需要source/2, sqrt(source)就可以。
 * @author Frank Zhang
 * @date 2021-02-02 2:24 PM
 */
import java.util.ArrayList;
import java.util.List;

public class MagicNumber {
    public static void main(String[] args) {
        new MagicNumber().find(1000);
    }

    /**
     * 判定正整数是否为对称数
     */
    public Boolean isBalance(int source) {
        if (source < 0) {
            return false;
        }

        char[] charArray = String.valueOf(source).toCharArray();
        int len = charArray.length;
        boolean flag = true;
        for (int i = 0; i < len / 2; i++) {
            if (charArray[i] != charArray[len - 1 - i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 判定是否是质数
     */
    public Boolean isPrime(int source) {
        double tempDouble = Math.sqrt(source);
        int temp = new Double(tempDouble).intValue();
        System.out.println("source:"+source+" tempDouble:" + tempDouble +" temp:"+temp);
        for (int i = 2; i <= temp; i++) {
            if (source % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 查找 maxNumber 同时是质数且对称数的数
     */
    public List<Integer> find(int maxNumber) {
        List<Integer> target = new ArrayList<>(maxNumber + 1);
        for (int i = 2; i < maxNumber; i++) {
            if (isPrime(i) && isBalance(i)) {
                target.add(i);
                System.out.println(i);
            }
        }
        System.out.println(target);
        return target;
    }
}