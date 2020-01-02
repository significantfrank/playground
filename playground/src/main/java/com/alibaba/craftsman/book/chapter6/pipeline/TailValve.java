package com.alibaba.craftsman.book.chapter6.pipeline;

/**
 * TailValve
 *
 * @author Frank Zhang
 * @date 2019-05-09 12:29
 */

public class TailValve extends ValveBase {
    public void invoke(String s) {
        s = s.replace("33", "third");
        System.out.println("after tail Valve handled: s = " + s);
    }
}