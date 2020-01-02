package com.alibaba.polymorphism.abstractlevel;

/**
 * WatermelonChecker
 *
 * @author Frank Zhang
 * @date 2019-12-17 23:37
 */
public class WatermelonChecker {
    private Watermelon watermelon;

    //判断是不是好瓜
    public boolean isGood(){
        if(watermelon.getWaterDegree() > 70 && watermelon.getColor().equals("deep green")){
            return true;
        }
        return false;
    }
}
