package com.alibaba.lamda;

/**
 * LamdaOriginTest
 *
 * @author Frank Zhang
 * @date 2018-05-02 6:36 PM
 */
public class LamdaOriginTest {
    public static void main(String[] args) {
        Lambda.PrintString("test", (x) -> System.out.println(x));
    }
}

@FunctionalInterface
interface Print<T> {
    public void print(T x);
}

class Lambda {
    public static void PrintString(String s, Print<String> print) {
        print.print(s);
    }

}