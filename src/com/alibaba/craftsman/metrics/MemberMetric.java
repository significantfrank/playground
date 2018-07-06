package com.alibaba.craftsman.metrics;

import com.alibaba.craftsman.team.Member;

/**
 * MemberMetric
 *
 * @author Frank Zhang
 * @date 2018-07-05 5:28 PM
 */
public class MemberMetric extends Metric{

    private Member member;

    private InfuenceMetric infuenceMetric;

    private AppMetric appMetric;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public InfuenceMetric getInfuenceMetric() {
        return infuenceMetric;
    }

    public void setInfuenceMetric(InfuenceMetric infuenceMetric) {
        this.infuenceMetric = infuenceMetric;
    }

    public AppMetric getAppMetric() {
        return appMetric;
    }

    public void setAppMetric(AppMetric appMetric) {
        this.appMetric = appMetric;
    }

    @Override
    public double calculateScore() {
        return infuenceMetric.calculateScore() * infuenceMetric.weight
                + appMetric.calculateScore() * appMetric.weight;
    }
}
