package com.alibaba.craftsman.entity;

import com.alibaba.craftsman.metrics.*;

/**
 * Member
 *
 * @author Frank Zhang
 * @date 2018-07-04 3:52 PM
 */
public class Member {

    private String name;//员工姓名

    private String employeeId;//员工id

    private MemberMetric memberMetric;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberMetric getMemberMetric() {
        return memberMetric;
    }

    public void setMemberMetric(MemberMetric memberMetric) {
        this.memberMetric = memberMetric;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", member Metric Score=" + memberMetric.calculateScore()+
                '}';
    }
}
