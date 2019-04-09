package com.alibaba.polymorphism.strategy;

public class DuckSimulator {
    public static void main(String[] args) {
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyWithRockets());

        System.out.println("\n After change behavior ===> \n");

        model.performFly();
    }
}
