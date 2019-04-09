package com.alibaba.craftsman.metrics;

/**
 * AppMetricItem
 *
 * @author Frank Zhang
 * @date 2018-07-05 5:32 PM
 */
public class AppMetricItem extends AbstractAppMetricItem{

    private AppComplexityMetricSubItem appComplexityMetricSubItem;

    private AppRepeatMetricSubItem appRepeatMetricSubItem;

    private AppViolationMetricSubItem appViolationMetricSubItem;

    public AppComplexityMetricSubItem getAppComplexityMetricSubItem() {
        return appComplexityMetricSubItem;
    }

    public void setAppComplexityMetricSubItem(AppComplexityMetricSubItem appComplexityMetricSubItem) {
        this.appComplexityMetricSubItem = appComplexityMetricSubItem;
    }

    public AppRepeatMetricSubItem getAppRepeatMetricSubItem() {
        return appRepeatMetricSubItem;
    }

    public void setAppRepeatMetricSubItem(AppRepeatMetricSubItem appRepeatMetricSubItem) {
        this.appRepeatMetricSubItem = appRepeatMetricSubItem;
    }

    public AppViolationMetricSubItem getAppViolationMetricSubItem() {
        return appViolationMetricSubItem;
    }

    public void setAppViolationMetricSubItem(AppViolationMetricSubItem appViolationMetricSubItem) {
        this.appViolationMetricSubItem = appViolationMetricSubItem;
    }

    @Override
    public double calculateScore() {
        return appComplexityMetricSubItem.calculateScore() * appComplexityMetricSubItem.weight
                + appRepeatMetricSubItem.calculateScore() * appRepeatMetricSubItem.weight
                + appViolationMetricSubItem.calculateScore() * appViolationMetricSubItem.weight;
    }
}
