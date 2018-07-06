package com.alibaba.craftsman.metrics;

import com.alibaba.craftsman.team.Member;

import java.util.List;

/**
 * AbstractAppMetricItem
 *
 * @author Frank Zhang
 * @date 2018-07-05 5:53 PM
 */
public abstract class AbstractAppMetricItem extends MetricItem{
    private long appId; //应用id
    private String appName; //应用name
    private Member owner; //应用owner
    private List<Member> coOwners; //应用的共同owners


}
