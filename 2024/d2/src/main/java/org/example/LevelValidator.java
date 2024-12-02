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
        boolean isSafe = true;
        int errorCount = 0;
        int errorIndex = -1;
        for (int i = 1; i < list.size(); i++){
            Integer i1 = list.get(i);
            Integer i2 = list.get(i - 1);
            int r = i1 - i2;
            // assign direction
            if (!validateDirection(r)){
                isSafe = false;
                errorCount++;
                errorIndex = i;
            }
            if (Math.abs(r) < min ||
                Math.abs(r) > max ){
                isSafe = false;
                errorCount++;
                errorIndex = i;
            }
        }
        System.out.println(errorCount);
        boolean isFixable = errorCount == 0;

        return new Report(isSafe, isFixable, errorIndex, list);
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
        // todo is equal important??
        if (r < 0) {
            plusMinus = DIRECTION.MINUS;
        } else {
            plusMinus = DIRECTION.PLUS;
        }
        return plusMinus;
    }

    enum DIRECTION {PLUS, MINUS}


    public static void main(String[] args) {
        Report report = new LevelValidator(1, 3).validateLevels(List.of(1, 3, 2, 4, 5));
        System.out.println(report);
    }


}
