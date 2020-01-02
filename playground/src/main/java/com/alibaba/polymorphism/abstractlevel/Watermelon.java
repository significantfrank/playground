package com.alibaba.polymorphism.abstractlevel;

/**
 * Watermelon
 *
 * @author Frank Zhang
 * @date 2019-08-06 11:52
 */

public class Watermelon extends Fruit{
    //颜色
    private String color;
    //重量
    private long weight;
    //水分
    private int waterDegree;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public int getWaterDegree() {
        return waterDegree;
    }

    public void setWaterDegree(int waterDegree) {
        this.waterDegree = waterDegree;
    }

    @Override
    public boolean isTasty() {
        return isJuicy();
    }

    private boolean isJuicy() {
        return waterDegree > 60;
    }

    public boolean isPremium(){
        return waterDegree > 65 && color.equals("green");
    }

    public boolean isGood(){
        return waterDegree > 60;
    }
}


