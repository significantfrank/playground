package com.alibaba.craftsman.book.chapter6.pipeline;

/**
 * FirstValve
 *
 * @author Frank Zhang
 * @date 2019-05-09 12:39
 */
public class FirstValve extends ValveBase {
    public void invoke(String s) {
        s = s.replace("11","first");
        System.out.println("after first Valve handled: s = " + s);
        getNext().invoke(s);
    }
}

