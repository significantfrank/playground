package com.alibaba.craftsman.book.chapter3;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * ServiceDegrade
 *
 * @author Frank Zhang
 * @date 2019-06-10 18:19
 */
public class ServiceDegrade {

/*    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultUser")
    public User getUserById(Long id){
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, id);
    }

    *//**
     * 在远程服务不可用时，使用降级方法：defaultUser
     *//*
    public User defaultUser(){
        return new User();
    }*/
}


