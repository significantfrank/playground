package com.alibaba.polymorphism.strategy;

public class MallardDuck extends Duck {
    public MallardDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }
}
