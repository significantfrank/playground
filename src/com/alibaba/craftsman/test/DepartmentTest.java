package com.alibaba.craftsman.test;

import com.alibaba.craftsman.team.Department;
import com.alibaba.craftsman.team.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * DepartmentTest
 *
 * @author Frank Zhang
 * @date 2018-07-06 10:31 AM
 */
public class DepartmentTest {
    public static void main(String[] args){
        Team team1 = TeamTest.buildTeam("创新业务");
        Team team2 = TeamTest.buildTeam("一达通");
        Team team3 = TeamTest.buildTeam("中供");
        Team team4 = TeamTest.buildTeam("基础平台");

        List<Team> teamList = new ArrayList<>();
        teamList.add(team1);
        teamList.add(team2);
        teamList.add(team3);
        teamList.add(team4);

        Department department = new Department();
        department.setTeamList(teamList);

        for(Team team: department.getTeamList()){
            System.out.println(team);
        }
    }
}
