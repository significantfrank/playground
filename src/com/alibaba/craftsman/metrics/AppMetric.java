package com.alibaba.craftsman.metrics;

import java.util.List;

/**
 * AppMetric
 *
 * @author Frank Zhang
 * @date 2018-07-05 5:31 PM
 */
public class AppMetric extends AbstractAppMetricItem{

    private List<AppMetricItem> appMetricItemList;

    public List<AppMetricItem> getAppMetricItemList() {
        return appMetricItemList;
    }

    public void setAppMetricItemList(List<AppMetricItem> appMetricItemList) {
        this.appMetricItemList = appMetricItemList;
    }

    /**
     * 应用质量分 = 所有应用质量分 / 应用数量
     * @return 应用质量分
     */
    @Override
    public double calculateScore() {
        if(appMetricItemList == null)
            return 0;
        double scoreSummary = 0;
        for(AppMetricItem appMetricItem : appMetricItemList){
            scoreSummary = scoreSummary + appMetricItem.calculateScore();
        }
        return scoreSummary/appMetricItemList.size();
    }
}
