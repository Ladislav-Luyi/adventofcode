package org.example;

import java.util.HashSet;
import java.util.Set;

public class Region {

    private final char regionId;
    Set<Plot> plots = new HashSet<>();
    int area, perimiter;

    public Region(char regionId, Set<Plot> plots, int perimiter) {
        this.regionId = regionId;
        this.plots = plots;
        area = plots.size();
        this.perimiter = perimiter;

        // 1 = 4 per
        // 2 = 6
        // + 1 = 2

    }

    public char getRegionId() {
        return regionId;
    }

    public Set<Plot> getPlots() {
        return plots;
    }

    public void setPlots(Set<Plot> plots) {
        this.plots = plots;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPerimiter() {
        return perimiter;
    }

    public void setPerimiter(int perimiter) {
        this.perimiter = perimiter;
    }

    @Override
    public String toString() {
        return "Region{" +
               "regionIdentificator=" + regionId +
               '}';
    }
}
