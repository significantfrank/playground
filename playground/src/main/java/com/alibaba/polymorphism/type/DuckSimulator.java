package com.alibaba.polymorphism.type;

public class DuckSimulator {
    public static void main(String[] args) {
        Duck duck = new Duck(DuckType.newType(Type.model));
        duck.performFly();
        duck.performQuack();

        System.out.println("\n After change type ===> \n");

        //不能对单个行为进行替换，取决于Type的行为粒度，综合下来，还是觉得《head head design pattern》的strategy pattern更容易理解，更有弹性，更灵活。
        duck.setDuckType(DuckType.newType(Type.superModel));
        duck.performFly();
        duck.performQuack();
    }
}
