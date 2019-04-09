package com.alibaba.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * ForkJoinTest
 * 所以对这种需要明确的知道一个Batch在何时多线程run结束的问题，只有两种方式
 * 1、通过ThreadLocal对每个容器线程分配一定量的线程。这样采用BlockingQueue和ForkJoinPool都可以做。
 * 2、如果要使用共享线程池，只能通过一个变量来控制何时结束
 *
 * @author Frank Zhang
 * @date 2018-05-28 11:07 AM
 */
public class ForkJoinTest {

    public static void threadSleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> testList = new ArrayList<>();
        testList.add("a");
        testList.add("b");
        testList.add("acd");
        testList.add("aer");
        testList.add("aaa");
        testList.add("bbb");
        testList.add("bbb");
        testList.add("bbb");
        List<String> testList2 = new ArrayList<>();
        testList.add("a2");
        testList.add("b2");
        testList.add("acd2");
        testList.add("aer2");
        testList.add("aaa2");
        testList.add("bbb2");
        testList.add("bbb2");
        testList.add("bbb2");
        ForkJoinPool forkJoinPool = new ForkJoinPool(6);
        Thread workThread1 = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" Started  ");
                try {
                    forkJoinPool.submit(()->{
                        testList.parallelStream().forEach((e)->{
                                    System.out.println(Thread.currentThread().getName()+"   "+e);
                                    threadSleep(100);
                                }
                        );
                    }).get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int i = 5;
                System.out.println(Thread.currentThread().getName()+"   WorkThread1 Finished processing ");
            }
        };



        Thread workThread2 = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" Started  ");
                try {
                    forkJoinPool.submit(()->{
                        testList2.parallelStream().forEach((e)->{
                                    System.out.println(Thread.currentThread().getName()+"   "+e);
                                    threadSleep(1000);
                                }
                        );
                    }).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                int i = 5;
                System.out.println(Thread.currentThread().getName()+" WorkThread2 Finished processing ");
            }
        };
        //ForkJoin Pool不能共享运行，会合并到一起运行，看来只能ThreadLocal的Run了，因为它有steal的特性。
        workThread1.start();
        workThread2.start();
        System.out.println(Thread.currentThread().getName()+" system finished ");
    }
}

