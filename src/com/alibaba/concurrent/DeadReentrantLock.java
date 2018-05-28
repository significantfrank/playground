package com.alibaba.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * DeadReentrantLock
 *
 * @author Frank Zhang
 * @date 2018-05-17 10:10 AM
 */
public class DeadReentrantLock {


    public static void main(String[] args){
        Lock lck1 = new ReentrantLock();
        Lock lck2 = new ReentrantLock();

        Thread t1 = new Thread(new Work1(lck1, lck2), "t1");
        Thread t2 = new Thread(new Work2(lck1, lck2), "t2");

        t1.start();
        t2.start();
    }

    private static void doWork() {
        try {
            System.out.println(Thread.currentThread().getName()+" is Working...");
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Work1 implements Runnable {

        private Lock lck1;
        private Lock lck2;

        public Work1(Lock lck1, Lock lck2) {
            this.lck1 = lck1;
            this.lck2 = lck2;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + " trying to lock on " + lck1);
            try{
                lck1.lock();
                System.out.println(name + " acquired lock on " + lck1);
                doWork();
                try{
                    System.out.println(name + " trying to lock on " + lck2);
                    lck2.lock();
                    System.out.println(name + " acquired lock on " + lck2);
                    doWork();
                }
                finally {
                    lck2.unlock();
                }
            }
            finally {
                lck1.unlock();
            }
        }
    }

    private static class Work2 implements Runnable {

        private Lock lck1;
        private Lock lck2;

        public Work2(Lock lck1, Lock lck2) {
            this.lck1 = lck1;
            this.lck2 = lck2;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + " trying to lock on " + lck2);
            try{
                lck2.lock();
                System.out.println(name + " acquired lock on " + lck2);
                doWork();
                try{
                    System.out.println(name + " trying to lock on " + lck1);
                    lck1.lock();
                    System.out.println(name + " acquired lock on " + lck1);
                    doWork();
                }
                finally {
                    lck1.unlock();
                }
            }
            finally {
                lck2.unlock();
            }
        }
    }
}
