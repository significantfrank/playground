package com.alibaba.polymorphism.strategy;

public class FlyWithRockets implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I am flying with Rockets");
    }
}
