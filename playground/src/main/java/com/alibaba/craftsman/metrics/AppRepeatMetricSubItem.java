package com.alibaba.craftsman.metrics;

/**
 * AppRepeatMetricSubItem
 *
 * 重复度数据可以在Sonar上获取：http://100.69.204.29:9000/overview?id=com.alibaba.crm.app%3Azeus
 *
 * @author Frank Zhang
 * @date 2018-07-05 5:33 PM
 */
public class AppRepeatMetricSubItem extends AbstractAppMetricItem{

    private long repeatCoverageRate; //重复代码覆盖率

    private int repeatCodeBlocks; //重复代码数量

    private String sonarRepeatURL; //sonar的链接

    public AppRepeatMetricSubItem(long repeatCoverageRate, int repeatCodeBlocks) {
        this.repeatCoverageRate = repeatCoverageRate;
        this.repeatCodeBlocks = repeatCodeBlocks;
    }

    public long getRepeatCoverageRate() {
        return repeatCoverageRate;
    }

    public void setRepeatCoverageRate(long repeatCoverageRate) {
        this.repeatCoverageRate = repeatCoverageRate;
    }

    public int getRepeatCodeBlocks() {
        return repeatCodeBlocks;
    }

    public void setRepeatCodeBlocks(int repeatCodeBlocks) {
        this.repeatCodeBlocks = repeatCodeBlocks;
    }

    public String getSonarRepeatURL() {
        return sonarRepeatURL;
    }

    public void setSonarRepeatURL(String sonarRepeatURL) {
        this.sonarRepeatURL = sonarRepeatURL;
    }

    @Override
    public double calculateScore() {
        //积分算法
        return 0;
    }
}
