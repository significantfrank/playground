package com.alibaba.lamda;

/**
 * LamdaImplTest
 *
 * @author Frank Zhang
 * @date 2018-05-02 6:38 PM
 */
public class LamdaImplTest {
    public static void main(String[] args) {
        Lambda2.PrintString("test in impl", new Lambda2.$Lambda$1());
    }
}

@FunctionalInterface
interface Print2<T> {
    public void print(T x);
}

class Lambda2 {
    public static void PrintString(String s, Print2<String> print2) {
        print2.print(s);
    }
    private static void lambda$0(String x) {
        System.out.println(x);
    }
    final static class $Lambda$1 implements Print2 {
        @Override
        public void print(Object x) {
            lambda$0((String)x);
        }
    }

}