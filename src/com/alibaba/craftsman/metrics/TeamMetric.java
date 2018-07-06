package com.alibaba.craftsman.metrics;

import java.util.List;

/**
 * TeamMetric
 *
 * @author Frank Zhang
 * @date 2018-07-06 9:45 AM
 */
public class TeamMetric extends Metric{

    private List<MemberMetric> memberMetricList;

    public List<MemberMetric> getMemberMetricList() {
        return memberMetricList;
    }

    public void setMemberMetricList(List<MemberMetric> memberMetricList) {
        this.memberMetricList = memberMetricList;
    }

    /**
     * 团队的分数度量，是每一个member的分数加和求平均
     * @return
     */
    @Override
    public double calculateScore() {
        if(memberMetricList == null)
            return 0;
        double scoreSummary = 0;
        for(MemberMetric memberMetric : memberMetricList){
            scoreSummary = scoreSummary + memberMetric.calculateScore();
        }
        return scoreSummary/memberMetricList.size();
    }
}
