package com.alibaba.craftsman.metrics;

import java.util.ArrayList;
import java.util.List;

/**
 * SharingMetric
 *
 * @author Frank Zhang
 * @date 2018-07-04 1:25 PM
 */
public class SharingMetric extends Metric{
    private List<MetricItem> metricItemList = new ArrayList<>();

    public void addMetricItem(MetricItem metricItem){
        metricItemList.add(metricItem);
    }

    @Override
    public long calculateScore() {
        long score = 0;
        for (MetricItem metricItem: metricItemList) {
            score = score + metricItem.calculateScore();
        }
        return score;
    }
}
