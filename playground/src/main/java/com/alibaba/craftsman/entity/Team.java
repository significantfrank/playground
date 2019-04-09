package com.alibaba.craftsman.entity;

import com.alibaba.craftsman.metrics.TeamMetric;

/**
 * Team
 *
 * @author Frank Zhang
 * @date 2018-07-06 9:40 AM
 */
public class Team {
    private String teamName; //团队名称
    private Member teamLeader;//团队的TL
    private TeamMetric teamMetric;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Member getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(Member teamLeader) {
        this.teamLeader = teamLeader;
    }

    public TeamMetric getTeamMetric() {
        return teamMetric;
    }

    public void setTeamMetric(TeamMetric teamMetric) {
        this.teamMetric = teamMetric;
    }

    @Override
    public String toString() {
        return "Team{" +
                "Team Name=" + teamName +
                ", Team Leader=" + teamLeader.getName() +
                ", Team Metric Score=" + teamMetric.calculateScore() +
                '}';
    }
}
