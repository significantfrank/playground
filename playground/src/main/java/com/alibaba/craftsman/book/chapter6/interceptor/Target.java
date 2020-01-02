package com.alibaba.craftsman.book.chapter6.interceptor;

/**
 * Target
 *
 * @author Frank Zhang
 * @date 2019-01-31 4:56 PM
 */
public interface Target{
    public Response execute(Request request);
}
