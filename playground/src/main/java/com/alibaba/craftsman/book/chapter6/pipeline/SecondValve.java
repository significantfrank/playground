package com.alibaba.craftsman.book.chapter6.pipeline;

/**
 * SecondValve
 *
 * @author Frank Zhang
 * @date 2019-05-09 15:33
 */
public class SecondValve extends ValveBase{
    @Override
    public void invoke(String s) {
        s = s.replace("22","second");
        System.out.println("after second Valve handled: s = " + s);
        getNext().invoke(s);
    }
}
