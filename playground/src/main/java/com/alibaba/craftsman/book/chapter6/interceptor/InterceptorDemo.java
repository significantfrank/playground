package com.alibaba.craftsman.book.chapter6.interceptor;

/**
 * InterceptorDemo
 *
 * @author Frank Zhang
 * @date 2019-01-31 5:31 PM
 */
public class InterceptorDemo {
    public static void main(String[] args) {
        TargetInvocation targetInvocation = new TargetInvocation();
        targetInvocation.addInterceptor(new LogInterceptor());
        targetInvocation.addInterceptor(new AuditInterceptor());

        targetInvocation.setRequest(new Request());
        targetInvocation.setTarget(request -> {return new Response();});

        targetInvocation.invoke();
    }
}
