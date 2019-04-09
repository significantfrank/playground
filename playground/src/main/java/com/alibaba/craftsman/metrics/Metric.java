package com.alibaba.craftsman.metrics;


/**
 * Metric
 *
 * @author Frank Zhang
 * @date 2018-07-04 1:23 PM
 */
public abstract class Metric implements Measurable{
    protected double weight ; //度量所占权重

    public Metric() {
        this.weight =  0.5; //Dummy Value for testing
    }
}
