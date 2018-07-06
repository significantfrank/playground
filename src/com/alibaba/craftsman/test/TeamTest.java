package com.alibaba.craftsman.test;

import com.alibaba.craftsman.metrics.MemberMetric;
import com.alibaba.craftsman.metrics.TeamMetric;
import com.alibaba.craftsman.team.Member;
import com.alibaba.craftsman.team.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * TeamTest
 *
 * @author Frank Zhang
 * @date 2018-07-06 9:51 AM
 */
public class TeamTest {
    public static void main(String[] args){
        Team team = buildTeam("创新业务");

        System.out.println(team);
        for(MemberMetric memberMetric : team.getTeamMetric().getMemberMetricList()){
            System.out.println(memberMetric.getMember());
        }
    }

    public static Team buildTeam(String teamName) {
        Member member = MemberTest.buildMember("jack");
        Member member1 = MemberTest.buildMember("frank");
        Member member2 = MemberTest.buildMember("kent");
        Member member3 = MemberTest.buildMember("lucy");

        List<MemberMetric> memberMetricList = new ArrayList<>();
        memberMetricList.add(member.getMemberMetric());
        memberMetricList.add(member1.getMemberMetric());
        memberMetricList.add(member2.getMemberMetric());
        memberMetricList.add(member3.getMemberMetric());

        TeamMetric teamMetric = new TeamMetric();
        teamMetric.setMemberMetricList(memberMetricList);

        Team team = new Team();
        team.setTeamName(teamName);
        team.setTeamLeader(member);
        team.setTeamMetric(teamMetric);
        return team;
    }
}
