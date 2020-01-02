package com.alibaba.craftsman.book.chapter6.interceptor;

/**
 * LogInterceptor
 *
 * @author Frank Zhang
 * @date 2019-01-31 4:36 PM
 */
public class LogInterceptor implements Interceptor {

    @Override
    public Response intercept(TargetInvocation targetInvocation) {
        System.out.println("Logging Begin");
        Response response = targetInvocation.invoke();
        System.out.println("Logging End");
        return response;
    }
}
