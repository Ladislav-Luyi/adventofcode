package org.example;

import java.util.List;
import java.util.Objects;

public class Guard {
    List<List<Character>> building;
    Position currentPosition = null;
    Direction currentDirection = null;
    int steps = 0;

    public Guard(List<List<Character>> building) {
        this.building = building;
        for (int i = 0; i < building.size(); i++) {
            List<Character> stages = building.get(i);
            for (int j = 0; j < stages.size(); j++) {
                Character stage = stages.get(j);
                if (stage.equals('^')) {
                    currentPosition = new Position(i, j);
                    currentDirection = Direction.UP;
                }
            }
        }
        if (Objects.isNull( currentPosition )){
            show();
            throw new RuntimeException("Something is wrong current position is null");
        }
    }

    int countSteps() {
        while (makeStep()) {
            if (steps > 50_000_000){
//            if (isCyclic(building.size(), building)){
                throw new LoopException();
            }
            show();
            steps++;
        }
        return steps;
    }

    void show(){
        for (List<Character> list : building) {
            for (Character c : list) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println("########## step " + steps + " direction " + currentDirection);
    }


    boolean makeStep() {
        try {
            
            Position nextPosition = getNextPosition();
            int row = currentPosition.stage();
            int col = currentPosition.tile();
            building.get(row).set(col, 'X');
            currentPosition = nextPosition;
            row = nextPosition.stage();
            col = nextPosition.tile();
            building.get(row).set(col, '^');
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    int countDistinctPositions(){
        int counter = 1;
        for (List<Character> list : building) {
            for (Character c : list) {
                if (c.equals('X')){
                    counter++;
                }
            }
        }
        return counter;
    }


    Position getNextPosition() {
        int row = currentPosition.stage();
        int col = currentPosition.tile();
        if (currentDirection.equals(Direction.UP)) {
            if (building.get(row - 1).get(col).equals('#')) {
                currentDirection = Direction.RIGHT;
                return new Position(row, col + 1);
            } else {
                return new Position(row - 1, col);
            }
        } else if (currentDirection.equals(Direction.RIGHT)) {
            if (building.get(row).get(col + 1).equals('#')) {
                currentDirection = Direction.DOWN;
                return new Position(row + 1, col);
            } else {
                return new Position(row, col + 1);
            }
        } else if (currentDirection.equals(Direction.DOWN)) {
            if (building.get(row + 1).get(col).equals('#')) {
                currentDirection = Direction.LEFT;
                return new Position(row, col - 1);
            } else {
                return new Position(row + 1, col);
            }
        } else
//         (currentDirection.equals(Direction.LEFT)){
            if (building.get(row ).get(col -1).equals('#')) {
                currentDirection = Direction.UP;
                return new Position(row - 1, col); // ??
            } else {
                return new Position(row, col - 1);
            }
    }
}




