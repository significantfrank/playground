package com.alibaba.craftsman.metrics;

import java.util.Date;

/**
 * SharingMetricItem
 *
 * @author Frank Zhang
 * @date 2018-07-04 3:20 PM
 */
public class SharingMetricItem extends MetricItem{

    private String sharingTitle;
    private SharingScope sharingScope;
    private Date sharingDate;

    public SharingMetricItem(String sharingTitle, SharingScope sharingScope, Date sharingDate) {
        this.sharingTitle = sharingTitle;
        this.sharingScope = sharingScope;
        this.sharingDate = sharingDate;
    }

    @Override
    public double calculateScore() {
        switch (sharingScope){
            case TEAM: return 1;
            case DEPARTMENT: return 3;
            case BU: return 8;
            case ALIBABA: return 15;
            case COMMUNITY: return 30;
        }
        return 0;
    }
}
