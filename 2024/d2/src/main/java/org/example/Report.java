package org.example;

import java.util.List;
import java.util.Objects;

public final class Report {
    private ReportState reportState;
    private final int errorIndex;
    private final List<Integer> levels;

    public Report(ReportState reportState, int errorIndex, List<Integer> levels) {
        this.reportState = reportState;
        this.errorIndex = errorIndex;
        this.levels = levels;
    }

    public ReportState reportState() {
        return reportState;
    }

    public void setReportState(ReportState reportState) {
        this.reportState = reportState;
    }

    public int errorIndex() {
        return errorIndex;
    }

    public List<Integer> levels() {
        return levels;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Report) obj;
        return Objects.equals(this.reportState, that.reportState) &&
               this.errorIndex == that.errorIndex &&
               Objects.equals(this.levels, that.levels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportState, errorIndex, levels);
    }

    @Override
    public String toString() {
        return "Report[" +
               "reportState=" + reportState + ", " +
               "errorIndex=" + errorIndex + ", " +
               "levels=" + levels + ']';
    }

}
