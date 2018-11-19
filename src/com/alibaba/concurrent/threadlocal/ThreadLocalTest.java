package com.alibaba.concurrent.threadlocal;

/**
 * ThreadLocalTest
 *
 * @author Frank Zhang
 * @date 2018-11-09 12:34 PM
 */
public class ThreadLocalTest {
    public static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        ParentThread gfg_pt = new ParentThread();
        gfg_pt.start();
    }
}

// Java program to illustrate parent thread, ThreadLocal variable
// by default not available to child thread

class ParentThread extends Thread {
    public static ThreadLocal gfg_tl = new ThreadLocal();
    public void run()
    {

        // setting the new value
        gfg_tl.set("parent data");
        ThreadLocalTest.threadLocal.set("Main data");
        // returns the ThreadLocal value associated with current thread
        System.out.println("Parent  Thread Value :" + gfg_tl.get());
        System.out.println("Main  Thread Value :" + ThreadLocalTest.threadLocal.get());

        ChildThread gfg_ct = new ChildThread();
        gfg_ct.start();
    }
}

class ChildThread extends Thread {
    public void run()
    {

        // returns  the ThreadLocal value associated with current thread
        System.out.println("Child Thread Value :" + ParentThread.gfg_tl.get());
        /* null (parent thread variable
        thread local value is not available to child thread ) */
        System.out.println("Main  Thread Value :" + ThreadLocalTest.threadLocal.get());
    }
}