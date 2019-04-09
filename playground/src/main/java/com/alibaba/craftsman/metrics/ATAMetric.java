package com.alibaba.craftsman.metrics;

/**
 * ATAMetric
 *
 * @author Frank Zhang
 * @date 2018-07-04 1:24 PM
 */
public class ATAMetric extends Metric{
    private ATAMetricItem ataMetricItem;

    public ATAMetric(ATAMetricItem ataMetricItem) {
        this.ataMetricItem = ataMetricItem;
    }

    @Override
    public double calculateScore() {
        return ataMetricItem.calculateScore();
    }
}
