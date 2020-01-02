package com.alibaba.polymorphism.abstractlevel;

/**
 * Apple
 *
 * @author Frank Zhang
 * @date 2019-08-06 11:51
 */

public class Apple extends Fruit{
    private int sweetDegree;

    @Override
    public boolean isTasty() {
        return isSweet();
    }

    public boolean isSweet(){
        return sweetDegree > 60;
    }
}

