package org.example;

import java.util.*;

public class RobotCrawler {

    private final Area area;
    Queue<Character> moves;
    private Pair robotPosition;

    public RobotCrawler(Area area, Queue<Character> moves) {
        this.area = area;
        List<List<Character>> areaArea = area.getArea();
        for (int i = 0; i < areaArea.size(); i++) {
            List<Character> list = areaArea.get(i);
            for (int j = 0; j < list.size(); j++) {
                Character c = list.get(j);
                if (c.equals('@')) {
                    robotPosition = new Pair(i, j);
                }
            }
        }
        this.moves = moves;

    }


    public Pair getNextMove(Pair p, Character d) {
        int row = p.r();
        int col = p.c();
        List<List<Character>> a = area.getArea();
        // quick hacks
        try {
            if (d.equals('^')) {
                a.get(row - 1).get(col);
                return new Pair(row - 1, col);
            } else if (d.equals('>')) {
                a.get(row).get(col + 1);
                return new Pair(row, col + 1);
            } else if (d.equals('v')) {
                a.get(row + 1).get(col);
                return new Pair(row + 1, col);
            } else {
                a.get(row).get(col - 1);
                return new Pair(row, col - 1);
            }

        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void run() {
        area.show();
        // add all directions to queue
        while (!moves.isEmpty()) {
            Character someDirection = moves.poll();
            List<Pair> result = new ArrayList<>();
            goInDirection(robotPosition, someDirection, result);
            Optional<Pair> isDot = result.stream().filter(pair -> area.getArea().get(pair.r()).get(pair.c()).equals('.')).findAny();
            if (isDot.isPresent()) {
                moveEveryNodeInDirectionAndSetRobotNodePosition(result, someDirection);
            }
            result.clear();
//            area.show();
        }
    }

    private void moveEveryNodeInDirectionAndSetRobotNodePosition(List<Pair> input, Character d) {
        Collections.reverse(input);
        for (Pair pair : input) {
            int row = pair.r();
            int col = pair.c();
            Character current = area.getArea().get(pair.r()).get(pair.c());
            boolean isMove = true;
            if (current.equals('.')){
                isMove = false;
            }
            Character newValue = current == '@' ? '@' : 'O';
            area.getArea().get(pair.r()).set(pair.c(), '.');
            Pair newPair = null;
            if (!isMove){
                continue;
            }
            if (d.equals('^')) {
                newPair = new Pair(row - 1, col);
            } else if (d.equals('>')) {
                newPair = new Pair(row, col + 1);
            } else if (d.equals('v')) {
                newPair = new Pair(row + 1, col);
            } else {
                newPair = new Pair(row, col - 1);
            }
            area.getArea().get(newPair.r()).set(newPair.c(), newValue);
            if (newValue.equals('@')){
                robotPosition = newPair;
            }
        }
    }

    // contain start node each time
    private void goInDirection(Pair pair, Character direction, List<Pair> result) {
        if (pair == null) {
            return;
        }
        Character current = area.getArea().get(pair.r()).get(pair.c());
        if (current.equals('#')) {
            return;
        }
        result.add(pair);
        if (current.equals('.')) {
            return;
        }
        Pair next = getNextMove(pair, direction);
        goInDirection(next, direction, result);
    }
}
