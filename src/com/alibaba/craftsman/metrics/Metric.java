package com.alibaba.craftsman.metrics;


/**
 * Metric
 *
 * @author Frank Zhang
 * @date 2018-07-04 1:23 PM
 */
public abstract class Metric implements Measurable{
    protected long weight; //度量所占权重
}
