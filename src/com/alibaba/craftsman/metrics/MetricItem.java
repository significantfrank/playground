package com.alibaba.craftsman.metrics;

/**
 * MetricItem
 *
 * @author Frank Zhang
 * @date 2018-07-04 1:23 PM
 */
public abstract class MetricItem implements Measurable{
    protected double weight; //度量所占权重

    public MetricItem() {
        this.weight = 0.5; //Dummy Value for testing
    }
}
