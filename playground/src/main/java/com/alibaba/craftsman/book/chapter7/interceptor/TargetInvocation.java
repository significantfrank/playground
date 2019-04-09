package com.alibaba.craftsman.book.chapter7.interceptor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TargetInvocation
 *
 * @author Frank Zhang
 * @date 2019-01-31 4:35 PM
 */
public class TargetInvocation {

    private List<Interceptor> interceptorList = new ArrayList<>();
    private Iterator<Interceptor> interceptors;
    private Target target;
    private Request request;

    public Response invoke(){
        if( interceptors.hasNext() ){
            Interceptor interceptor = interceptors.next();
            interceptor.intercept(this);
        }
        return target.execute(request);
    }

    public void addInterceptor(Interceptor interceptor){
        interceptorList.add(interceptor);
        interceptors = interceptorList.iterator();
    }

    public void setRequest(Request request){
        this.request = request;
    }

    public void setTarget(Target target){
        this.target = target;
    }

    public Target getTarget(){
        return target;
    }
}
