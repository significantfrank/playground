package com.alibaba.concurrent;

import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;
        import java.util.concurrent.locks.ReentrantLock;

class worker implements Runnable
{
    String name;
    ReentrantLock re;
    public worker(ReentrantLock rl, String n)
    {
        re = rl;
        name = n;
    }
    public void run()
    {
        boolean done = false;
        while (!done)
        {
            //Getting Outer Lock
            boolean ans = re.tryLock();

            // Returns True if lock is free
            if(ans)
            {
                try
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println(Thread.currentThread()+" task name - "+ name
                            + " outer lock acquired at "
                            + ft.format(d)
                            + " Doing outer work");
                    Thread.sleep(1500);

                    // Getting Inner Lock
                    re.lock();
                    try
                    {
                        d = new Date();
                        ft = new SimpleDateFormat("hh:mm:ss");
                        System.out.println(Thread.currentThread()+ " task name - "+ name
                                + " inner lock acquired at "
                                + ft.format(d)
                                + " Doing inner work");
                        System.out.println(Thread.currentThread()+ " Lock Hold Count - "+ re.getHoldCount());
                        Thread.sleep(1500);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    finally
                    {
                        //Inner lock release
                        System.out.println(Thread.currentThread()+ " task name - " + name +
                                " releasing inner lock");

                        re.unlock();
                    }
                    System.out.println(Thread.currentThread()+ " Lock Hold Count - " + re.getHoldCount());
                    System.out.println(Thread.currentThread()+ " task name - " + name + " work done");

                    done = true;
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    //Outer lock release
                    System.out.println("task name - " + name +
                            " releasing outer lock");

                    re.unlock();
                    System.out.println("Lock Hold Count - " +
                            re.getHoldCount());
                }
            }
            else
            {
                System.out.println("task name - " + name +
                        " waiting for lock");
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ReentrantLockTest
{
    static final int MAX_T = 4;
    public static void main(String[] args) throws Exception
    {
        Thread targetThread = new Thread(()->{
            try {
                Thread.currentThread().sleep(1000 * 30 * 30);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        });

        targetThread.start();

        Thread interuptor = new Thread(()->{
            targetThread.interrupt();
        });

        interuptor.start();

        /*
        ReentrantLock rel = new ReentrantLock(true);
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        Runnable w1 = new worker(rel, "Job1");
        Runnable w2 = new worker(rel, "Job2");
        Runnable w3 = new worker(rel, "Job3");
        Runnable w4 = new worker(rel, "Job4");
        pool.execute(w1);
        Thread.sleep(100);
        pool.execute(w2);
        Thread.sleep(100);
        pool.execute(w3);
        Thread.sleep(100);
        pool.execute(w4);
        pool.shutdown();*/
    }
}
