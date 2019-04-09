package com.alibaba.polymorphism.strategy;

//把易变的行为，封装起来，使用多态实现策略模式，提供灵活性。基本上所有设计模式的精神就是为了做到OCP。
public interface FlyBehavior {
    public void fly();
}
