package com.alibaba.craftsman.book.chapter6.interceptor;

/**
 * Interceptor
 *
 * @author Frank Zhang
 * @date 2019-01-31 4:35 PM
 */
public interface Interceptor {
    public Response intercept(TargetInvocation targetInvocation);
}
