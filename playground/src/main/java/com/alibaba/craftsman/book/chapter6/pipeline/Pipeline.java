package com.alibaba.craftsman.book.chapter6.pipeline;

/**
 * Pipeline
 *
 * @author Frank Zhang
 * @date 2019-05-09 12:28
 */
public interface Pipeline {
    public Valve getHead();
    public Valve getTail();
    public void setTail(Valve v);
    public void addValve(Valve v);
}

