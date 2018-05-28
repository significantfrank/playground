package com.alibaba.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * ForkJoinTest
 *
 * @author Frank Zhang
 * @date 2018-05-28 11:07 AM
 */
public class ForkJoinTest {
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
        ForkJoinPool forkJoinPool = new ForkJoinPool(6);
        forkJoinPool.submit(()->{
            testList.parallelStream().forEach((e)->{
                System.out.println(Thread.currentThread().getName()+"   "+e);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            );
            System.out.println(Thread.currentThread().getName()+"  Finished submiting ");
        }).get();
    }
}

