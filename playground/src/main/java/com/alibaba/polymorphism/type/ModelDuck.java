package com.alibaba.polymorphism.type;

public class ModelDuck extends DuckType
{
    @Override
    public Type getType() {
        return Type.model;
    }

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }

    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
