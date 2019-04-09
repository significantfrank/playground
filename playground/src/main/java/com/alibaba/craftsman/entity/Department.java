package com.alibaba.craftsman.entity;

import java.util.List;

/**
 * Department
 *
 * @author Frank Zhang
 * @date 2018-07-06 9:51 AM
 */
public class Department {
    private List<Team> teamList;

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "teamList=" + teamList +
                '}';
    }
}
