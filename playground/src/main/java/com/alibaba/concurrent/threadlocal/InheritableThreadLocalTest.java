package com.alibaba.concurrent.threadlocal;

/**
 * InheritableThreadLocalTest
 *
 * @author Frank Zhang
 * @date 2018-11-09 12:41 PM
 */
public class InheritableThreadLocalTest {
   private static class ParentThread extends Thread {
        // anonymous inner class  for overriding childValue method.
        public static InheritableThreadLocal gfg_tl = new InheritableThreadLocal() {
            public Object childValue(Object parentValue)
            {
                return "child data";
            }
        };
        public void run()
        {
            // setting the new value
            gfg_tl.set("parent data");
            // parent data
            System.out.println("Parent Thread Value :" + gfg_tl.get());

            InheritableThreadLocalTest.ChildThread gfg_ct = new InheritableThreadLocalTest.ChildThread();
            gfg_ct.start();
        }
    }

     static class ChildThread extends Thread {

        public void run()
        {
            // child data
            System.out.println("Child Thread Value :" + InheritableThreadLocalTest.ParentThread.gfg_tl.get());
        }
    }

    public static void main(String[] args) {
        InheritableThreadLocalTest.ParentThread gfg_pt = new InheritableThreadLocalTest.ParentThread();
        gfg_pt.start();
    }
}
