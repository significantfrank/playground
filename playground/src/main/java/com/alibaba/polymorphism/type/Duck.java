package com.alibaba.polymorphism.type;

public class Duck {

    DuckType duckType;

    public void performQuack(){
        duckType.quack();
    }

    public void performFly(){
        duckType.fly();
    }

    public void swim(){
        System.out.println("All ducks float, even decoys");
    }

    public Duck(DuckType duckType) {
        this.duckType = duckType;
    }

    public void setDuckType(DuckType duckType) {
        this.duckType = duckType;
    }
}
