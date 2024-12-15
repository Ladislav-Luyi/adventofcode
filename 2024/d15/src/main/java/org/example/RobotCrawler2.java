package org.example;

import java.util.*;

public class RobotCrawler2 {

    private final Area2 area;
    Queue<Character> moves;
    private Pair robotPosition;

    public RobotCrawler2(Area2 area, Queue<Character> moves) {
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
            // here adjust
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
//        area.show();
        outer:
        while (!moves.isEmpty()) {
            Character someDirection = moves.poll();
            List<Pair> result = new ArrayList<>();
            goInDirection(robotPosition, someDirection, result);
            Optional<Pair> isDot = result.stream().filter(pair -> area.getArea().get(pair.r()).get(pair.c()).equals('.')).findAny();
            if (isDot.isPresent()) {
                HashSet<Pair> tmpResultOuter = new HashSet<>();
                if (someDirection.equals('^') || someDirection.equals('v')) {
                    Queue<Pair> queue = new ArrayDeque<>(result);
                    HashSet<Pair> processed = new HashSet<>();
                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        if (processed.contains(pair)){
                            continue;
                        }
                        processed.add(pair);
                        List<Pair> tmpResult = new ArrayList<>();
                        Character c = area.getArea().get(pair.r()).get(pair.c());
                        if (c.equals('[')) {
                            goInDirection(new Pair(pair.r(), pair.c() + 1), someDirection, tmpResult);
                            queue.addAll(tmpResult);
                        } else if (c.equals(']')) {
                            goInDirection(new Pair(pair.r(), pair.c() - 1), someDirection, tmpResult);
                            queue.addAll(tmpResult);
                        } else {
                            continue;
                        }

                        Optional<Pair> isDot2 = tmpResult.stream().filter(e -> area.getArea().get(e.r()).get(e.c()).equals('.')).findAny();
                        if (isDot2.isEmpty()) {
                            continue outer;
                        } else {
                            tmpResultOuter.addAll(tmpResult);
                        }
                    }
                    result.addAll(tmpResultOuter);
                }

                moveEveryNodeInDirectionAndSetRobotNodePosition(result, someDirection);
            }
            result.clear();
//            area1.show();
        }
    }


    private void moveEveryNodeInDirectionAndSetRobotNodePosition(List<Pair> input, Character d) {
        sort(input, d);
        for (Pair pair : input) {
            int row = pair.r();
            int col = pair.c();
            Character current = area.getArea().get(pair.r()).get(pair.c());
            boolean isDot = current.equals('.');
            Character newValue = getNextChar(current);
            area.getArea().get(pair.r()).set(pair.c(), '.');
            Pair newPair = null;
            if (isDot) {
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
            if (newValue.equals('@')) {
                robotPosition = newPair;
            }
        }
    }

    private void sort(List<Pair> input, Character d) {
        // if up lowest r
        // if down biggest r
        // if left lowest c
        // if right biggest c

        if (d.equals('^')) {
            input.sort(new RowComparator());

        } else if (d.equals('>')) {
            input.sort(new ColumnComparator());
            Collections.reverse(input);
        } else if (d.equals('v')) {
            input.sort(new RowComparator());
            Collections.reverse(input);
        } else {
            input.sort(new ColumnComparator());
        }
    }

    private Character getNextChar(Character current) {
        if (current.equals('@')) {
            return '@';
        } else if (current.equals('[')) {
            return '[';
        } else {
            return ']';
        }
    }

    private List<Pair> reverseCustom(List<Pair> input) {
        List<Pair> r = new ArrayList<>();
        Pair previous = null;
        for (int i = input.size() - 1; i >= 0; i--) {
            Pair pair = input.get(i);
            Character current = area.getArea().get(pair.r()).get(pair.c());
            if (current.equals(']')) {
                previous = pair;
                continue;
            }
            r.add(pair);
            if (Objects.nonNull(previous)) {
                r.add(previous);
                previous = null;
            }
        }
        return r;
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
