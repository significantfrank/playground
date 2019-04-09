package com.alibaba.craftsman.test;

import com.alibaba.craftsman.metrics.*;
import com.alibaba.craftsman.entity.Member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * MemberTest
 *
 * @author Frank Zhang
 * @date 2018-07-06 9:35 AM
 */
public class MemberTest {
    public static void main(String[] args){
        Member member = buildMember("jack");

        System.out.println(member.getName()+" 的影响力分数是： " + member.getMemberMetric().calculateScore());
    }

    public static Member buildMember(String name) {
        Member member = new Member();
        member.setName(name);

        InfuenceMetric infuenceMetric = buildInfluenceMetric();

        AppMetric appMetric = buildAppMetric();

        MemberMetric memberMetric = new MemberMetric();
        memberMetric.setMember(member);
        memberMetric.setInfuenceMetric(infuenceMetric);
        memberMetric.setAppMetric(appMetric);

        member.setMemberMetric(memberMetric);
        return member;
    }

    private static InfuenceMetric buildInfluenceMetric() {
        InfuenceMetric infuenceMetric =  new InfuenceMetric();

        ATAMetricItem ataMetricItem = new ATAMetricItem(1020);
        ATAMetric ataMetric = new ATAMetric(ataMetricItem);

        SharingMetricItem sharingMetricItem = new SharingMetricItem("Design pattern in entity", SharingScope.TEAM, new Date());
        SharingMetricItem sharingMetricItem2 = new SharingMetricItem("Design pattern in Dept", SharingScope.DEPARTMENT, new Date());
        SharingMetricItem sharingMetricItem3 = new SharingMetricItem("Design pattern in BU", SharingScope.BU, new Date());
        SharingMetric sharingMetric = new SharingMetric();
        sharingMetric.addMetricItem(sharingMetricItem);
        sharingMetric.addMetricItem(sharingMetricItem2);
        sharingMetric.addMetricItem(sharingMetricItem3);

        infuenceMetric.addMetric(ataMetric);
        infuenceMetric.addMetric(sharingMetric);
        return infuenceMetric;
    }

    private static AppMetric buildAppMetric(){
        AppMetric appMetric = new AppMetric();

        AppMetricItem appMetricItem = new AppMetricItem();
        AppComplexityMetricSubItem appComplexityMetricSubItem = new AppComplexityMetricSubItem();
        AppRepeatMetricSubItem appRepeatMetricSubItem = new AppRepeatMetricSubItem((long)0.35, 3000 );
        AppViolationMetricSubItem appViolationMetricSubItem = new AppViolationMetricSubItem();
        appViolationMetricSubItem.setBugNumber(100);
        appViolationMetricSubItem.setBadSmellNumber(2011);
        appViolationMetricSubItem.setFlawNumber(30210);
        appMetricItem.setAppComplexityMetricSubItem(appComplexityMetricSubItem);
        appMetricItem.setAppRepeatMetricSubItem(appRepeatMetricSubItem);
        appMetricItem.setAppViolationMetricSubItem(appViolationMetricSubItem);

        List<AppMetricItem> appMetricItemList = new ArrayList<>();
        appMetricItemList.add(appMetricItem);
        appMetric.setAppMetricItemList(appMetricItemList);

        return appMetric;
    }
}
