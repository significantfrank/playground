package com.alibaba.concurrent;

/**
 * DeadObjectLock
 *
 * @author Frank Zhang
 * @date 2018-05-17 9:38 AM
 */
public class DeadObjectLock {

    public static void main(String[] args){
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread t1 = new Thread(new Work1(obj1, obj2), "t1");
        Thread t2 = new Thread(new Work2(obj1, obj2), "t2");

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

        private Object obj1;
        private Object obj2;

        public Work1(Object o1, Object o2) {
            this.obj1 = o1;
            this.obj2 = o2;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + " trying to lock on " + obj1);
            synchronized (obj1){
                System.out.println(name + " acquired lock on " + obj1);
                doWork();
                System.out.println(name + " trying to lock on " + obj2);
                synchronized (obj2){
                    System.out.println(name + " acquired lock on " + obj2);
                    doWork();
                }
            }
        }
    }

    private static class Work2 implements Runnable {

        private Object obj1;
        private Object obj2;

        public Work2(Object o1, Object o2) {
            this.obj1 = o1;
            this.obj2 = o2;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + " acquiring lock on " + obj2);
            synchronized (obj2){
                System.out.println(name + " acquired lock on " + obj2);
                doWork();
                System.out.println(name + " acquiring lock on " + obj1);
                synchronized (obj1){
                    System.out.println(name + " acquired lock on " + obj1);
                    doWork();
                }
            }
        }
    }
}
