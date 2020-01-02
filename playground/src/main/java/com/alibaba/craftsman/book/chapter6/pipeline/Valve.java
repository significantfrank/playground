package com.alibaba.craftsman.book.chapter6.pipeline;

/**
 * Valve
 *
 * @author Frank Zhang
 * @date 2019-05-09 12:27
 */
public interface Valve {
    public Valve getNext();
    public void setNext(Valve v);
    public void invoke(String s);
}
