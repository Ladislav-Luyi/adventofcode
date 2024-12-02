package org.example;

import java.util.List;

public class LevelValidator {
    int min,max;
    DIRECTION plusMinus = null;

    public LevelValidator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Report validateLevels(List<Integer> list) {
        boolean reportState = true;
        for (int i = 1; i < list.size(); i++){
            Integer i1 = list.get(i);
            Integer i2 = list.get(i - 1);
            int r = i1 - i2;
            // assign direction
            if (!validateDirection(r)){
                reportState = false;
                break;
            }
            if (Math.abs(r) < min ||
                Math.abs(r) > max ){
                reportState = false;
                break;
            }
        }
        return new Report(reportState, list);
    }

    private boolean validateDirection(int r) {
        return getFirstDirection(r) == getCurrentDirection(r);
    }

    private DIRECTION getFirstDirection(
            int r
    ) {
        if (plusMinus == null){
            plusMinus = getCurrentDirection(r);
        }
        return plusMinus;
    }

    private DIRECTION getCurrentDirection(int r) {
        if (r < 0) {
            plusMinus = DIRECTION.MINUS;
        } else {
            plusMinus = DIRECTION.PLUS;
        }
        return plusMinus;
    }

    enum DIRECTION {PLUS, MINUS}


}
