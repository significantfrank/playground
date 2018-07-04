package com.alibaba.craftsman.metrics;

import java.util.ArrayList;
import java.util.List;

/**
 * InfuenceMetric
 *
 * @author Frank Zhang
 * @date 2018-07-04 1:24 PM
 */
public class InfuenceMetric extends Metric{
    private List<Metric> metrics = new ArrayList<>();

    public void addMetric(Metric metric){
        metrics.add(metric);
    }

    @Override
    public long calculateScore() {
        long score = 0;
        for (Metric metric : metrics) {
            score = score + metric.calculateScore();
        }
        return score;
    }
}
