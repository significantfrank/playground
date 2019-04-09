package com.alibaba.craftsman.metrics;

/**
 * AppComplexityMetricSubItem
 *
 * @author Frank Zhang
 * @date 2018-07-05 5:34 PM
 */
public class AppComplexityMetricSubItem extends AbstractAppMetricItem {
    @Override
    public double calculateScore() {
        return 1;
    }
}
