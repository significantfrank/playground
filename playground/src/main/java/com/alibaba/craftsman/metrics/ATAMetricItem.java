package com.alibaba.craftsman.metrics;

/**
 * ATAMetricItem
 *
 * @author Frank Zhang
 * @date 2018-07-04 3:20 PM
 */
public class ATAMetricItem extends MetricItem{
    private int numberOfThumbUps;

    private static int STEP_SIZE= 50;

    public ATAMetricItem(int numberOfThumbUps) {
        this.numberOfThumbUps = numberOfThumbUps;
    }

    @Override
    public double calculateScore() {

        if (numberOfThumbUps == 0) return 0;

        int score = 1 ;
        while(numberOfThumbUps >= (STEP_SIZE * score)){
            score++;
        }

        return score;
    }
}
