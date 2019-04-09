package com.alibaba.java8;

import com.alibaba.tmf.rule.func.annotation.Func;

import java.util.function.Function;

/**
 * FunctionTest
 *
 * @author Frank Zhang
 * @date 2019-01-07 9:22 PM
 */
public class FunctionTest {

    public static class StrToIntClass implements Function<String, Integer>{
        @Override
        public Integer apply(String s) {
            return Integer.parseInt(s);
        }
    }

    public static void main(String[] args) {

        //经典类
        Function<String, Integer> strToIntClass = new StrToIntClass();

        //方法引用
        Function<String, Integer> strToIntMethodRefrence = Integer::parseInt;

        //Lamda
        Function<String, Integer> strToIntLammda  = s -> Integer.parseInt(s);

        //匿名类
        Function<String, Integer>  strToIntAnanymousClass = new Function<String, Integer>(){
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
        System.out.println(strToIntAnanymousClass.apply("4"));
    }
}
