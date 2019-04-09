package com.alibaba.polymorphism.type;

public abstract class DuckType {
    Type type;
    public abstract Type getType();
    public abstract void fly();
    public abstract void quack();

    public static DuckType newType(Type type){
        switch (type){
            case model: return new ModelDuck();
            case mallard: return new MallardDuck();
            case superModel: return new SuperModelDuck();
        }
        throw new IllegalArgumentException("Type is not valid");
    }
}
