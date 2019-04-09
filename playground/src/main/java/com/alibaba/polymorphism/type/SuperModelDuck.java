package com.alibaba.polymorphism.type;

public class SuperModelDuck extends DuckType{
    @Override
    public Type getType() {
        return Type.superModel;
    }

    @Override
    public void fly() {
        System.out.println("I am flying powered by Rocket");
    }

    /**
     * SuperModelDuck的quack()和ModelDuck的quack()是一样的，但是却不能复用。
     *
     * 这种多态的方式没有直接把行为抽出来的灵活，而且理解上，strategy的方式也更好理解。
     */
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
