package com.alibaba.craftsman.metrics;

/**
 * AppViolationMetricSubItem
 *
 * 参考Sonar：http://100.69.204.29:9000/component_issues?id=com.alibaba.crm.app%3Azeus#resolved=false|types=BUG%2CVULNERABILITY%2CCODE_SMELL
 *
 * @author Frank Zhang
 * @date 2018-07-05 5:34 PM
 */
public class AppViolationMetricSubItem extends AbstractAppMetricItem {
    private int bugNumber; //Bug数
    private int flawNumber; //漏洞数
    private int badSmellNumber; //坏味道数

    private String sonarBadSmellURL;

    public int getBugNumber() {
        return bugNumber;
    }

    public void setBugNumber(int bugNumber) {
        this.bugNumber = bugNumber;
    }

    public int getFlawNumber() {
        return flawNumber;
    }

    public void setFlawNumber(int flawNumber) {
        this.flawNumber = flawNumber;
    }

    public int getBadSmellNumber() {
        return badSmellNumber;
    }

    public void setBadSmellNumber(int badSmellNumber) {
        this.badSmellNumber = badSmellNumber;
    }

    public String getSonarBadSmellURL() {
        return sonarBadSmellURL;
    }

    public void setSonarBadSmellURL(String sonarBadSmellURL) {
        this.sonarBadSmellURL = sonarBadSmellURL;
    }

    @Override
    public double calculateScore() {
        return 0;
    }
}
