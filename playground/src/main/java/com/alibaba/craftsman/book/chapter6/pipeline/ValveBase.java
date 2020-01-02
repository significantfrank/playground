package com.alibaba.craftsman.book.chapter6.pipeline;

/**
 * ValveBase
 *
 * @author Frank Zhang
 * @date 2019-05-09 14:31
 */
public abstract class ValveBase implements Valve{
    public Valve next;
    public Valve getNext() {
        return next;
    }

    public void setNext(Valve v) {
        next = v;
    }

    public abstract void invoke(String s);
}
