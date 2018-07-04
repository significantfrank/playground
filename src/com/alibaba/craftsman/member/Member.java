package com.alibaba.craftsman.member;

import com.alibaba.craftsman.metrics.*;

import java.util.Date;

/**
 * Member
 *
 * @author Frank Zhang
 * @date 2018-07-04 3:52 PM
 */
public class Member {

    private String name;

    private InfuenceMetric infuenceMetric;

    public static void main(String[] args){
        Member member = new Member();
        member.name = "jack";

        InfuenceMetric infuenceMetric =  new InfuenceMetric();

        ATAMetricItem ataMetricItem = new ATAMetricItem(1020);
        ATAMetric ataMetric = new ATAMetric(ataMetricItem);

        SharingMetricItem sharingMetricItem = new SharingMetricItem("Design pattern in team", SharingScope.TEAM, new Date());
        SharingMetricItem sharingMetricItem2 = new SharingMetricItem("Design pattern in Dept", SharingScope.DEPARTMENT, new Date());
        SharingMetricItem sharingMetricItem3 = new SharingMetricItem("Design pattern in BU", SharingScope.BU, new Date());
        SharingMetric sharingMetric = new SharingMetric();
        sharingMetric.addMetricItem(sharingMetricItem);
        sharingMetric.addMetricItem(sharingMetricItem2);
        sharingMetric.addMetricItem(sharingMetricItem3);

        infuenceMetric.addMetric(ataMetric);
        infuenceMetric.addMetric(sharingMetric);

        member.infuenceMetric = infuenceMetric;

        System.out.println(member.name+" 的影响力分数是： " + member.infuenceMetric.calculateScore());
    }
}
