package com.alibaba.polymorphism.abstractlevel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * FruitPicker
 *
 * @author Frank Zhang
 * @date 2019-08-06 11:55
 */

public class FruitPicker {

    public List<Fruit> pickGood(List<Fruit> fruits){
        return fruits.stream().filter(e -> check(e)).
                collect(Collectors.toList());
    }

    private boolean check(Fruit e) {
        return e.isTasty();
    }
}


/*    private boolean check(Fruit e) {
        if(e instanceof Apple){
            if(((Apple) e).isSweet()){
                return true;
            }
        }
        if(e instanceof Watermelon){
            if(((Watermelon) e).isJuicy()){
                return true;
            }
        }
        return false;
    }*/





