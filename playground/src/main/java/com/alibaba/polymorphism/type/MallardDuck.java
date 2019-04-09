package com.alibaba.polymorphism.type;

public class MallardDuck extends DuckType{
    @Override
    public Type getType() {
        return Type.mallard;
    }

    @Override
    public void fly() {
        System.out.println("I am flying");
    }

    @Override
    public void quack() {
        System.out.println("quack");
    }
}
