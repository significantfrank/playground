package com.alibaba.craftsman.book.chapter6.interceptor;


/**
 * AuditInterceptor
 *
 * @author Frank Zhang
 * @date 2019-01-31 4:38 PM
 */
public class AuditInterceptor implements Interceptor{
    @Override
    public Response intercept(TargetInvocation targetInvocation) {
        if(targetInvocation.getTarget() == null) {
            throw new IllegalArgumentException("Target is null");
        }
        System.out.println("Audit Succeeded ");
        return targetInvocation.invoke();
    }
}
