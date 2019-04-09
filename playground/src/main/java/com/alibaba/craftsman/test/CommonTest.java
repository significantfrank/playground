package com.alibaba.craftsman.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CommonTest
 *
 * @author Frank Zhang
 * @date 2018-09-13 7:04 PM
 */
public class CommonTest {
   public static ExecutorService defaultExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1,
            Runtime.getRuntime().availableProcessors() + 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1000));

    public static void main(String[] args) {
        double WEIGHT_PERCENTAGE = 100;
        double weight = 20 / WEIGHT_PERCENTAGE;
        System.out.println(weight);

        defaultExecutor.submit(()->{
            System.out.println(Thread.currentThread().getName()+" hello");
        });

        System.out.println("Finished");
    }
}
