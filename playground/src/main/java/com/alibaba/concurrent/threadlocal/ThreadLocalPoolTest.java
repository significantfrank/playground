package com.alibaba.concurrent.threadlocal;

/**
 * ThreadLocalPoolTest
 *
 * @author Frank Zhang
 * @date 2018-11-09 12:47 PM
 */
public class ThreadLocalPoolTest {
    //Global variable
    public static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        threadLocal.set("main data");

        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                threadLocal.set("thread1 data");
                System.out.println("Thread1 : " + threadLocal.get());
            }
        });
        thread1.start();


        System.out.println("Main : " + threadLocal.get());
    }
}
