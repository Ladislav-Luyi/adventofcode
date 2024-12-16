package org.example;

import java.util.*;

public class NodeCrawler {

    private final Area area;
    boolean[][] visited;
    Node current;
    Node finish;

    public NodeCrawler(Area area) {
        this.area = area;
        visited = new boolean[area.getNodes().size()][area.getNodes().get(0).size()];
        List<List<Node>> areaNodes = area.getNodes();
        for (int i = 0; i < areaNodes.size(); i++) {
            List<Node> nodes = areaNodes.get(i);
            for (int j = 0; j < nodes.size(); j++) {
                Node node = nodes.get(j);
                if (node.i() == 'S') {
                    current = new Node(node.r(), node.c(), node.i(), Direction.RIGHT);
                }
                if (node.i() == 'E') {
                    finish = node;
                }
                if (node.i() == '#') {
                    visited[i][j] = true;
                }
            }
        }
    }

    void showVisted() {
        for (boolean[] booleans : visited) {
            for (boolean b : booleans) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }


    public List<Move> getNextMoves(Node start) {
        List<Move> list = new ArrayList<>();

        int row = start.r();
        int col = start.c();
        Direction currentDirection = start.d();

        if (currentDirection.equals(Direction.TOP)) {
            int newRow = row - 1;
            int newCol = col;
            if (isFit(newRow, newCol)) {
                list.add(new Move(getNode(newRow, newCol, Direction.TOP), getPoints(currentDirection, Direction.TOP)));
            }

            newRow = row;
            newCol = col + 1;
            if (isFit(newRow, newCol)) {
                list.add(new Move(getNode(newRow, newCol, Direction.RIGHT), getPoints(currentDirection, Direction.RIGHT)));
            }
            newRow = row;
            newCol = col - 1;
            if (isFit(newRow, newCol)) {
                list.add(new Move(getNode(newRow, newCol, Direction.LEFT), getPoints(currentDirection, Direction.LEFT)));
            }
        }
        if (currentDirection.equals(Direction.RIGHT)) {
            int newRow = row;
            int newCol = col + 1;
            if (isFit(newRow, newCol)) {
                list.add(new Move(getNode(newRow, newCol, Direction.RIGHT), getPoints(currentDirection, Direction.RIGHT)));
            }
            newRow = row - 1;
            newCol = col;
            if (isFit(newRow, newCol)) {
                list.add(new Move(getNode(newRow, newCol, Direction.TOP), getPoints(currentDirection, Direction.TOP)));
            }
            newRow = row + 1;
            newCol = col;
            if (isFit(newRow, newCol)) {
                list.add(new Move(getNode(newRow, newCol, Direction.BOT), getPoints(currentDirection, Direction.BOT)));
            }
        }
        if (currentDirection.equals(Direction.BOT)) {
            int newRow = row + 1;
            int newCol = col;
            if (isFit(newRow, newCol)) {
                list.add(new Move(getNode(newRow, newCol, Direction.BOT), getPoints(currentDirection, Direction.BOT)));
            }
            newRow = row;
            newCol = col + 1;
            if (isFit(newRow, newCol)) {
                list.add(new Move(getNode(newRow, newCol, Direction.RIGHT), getPoints(currentDirection, Direction.RIGHT)));
            }
            newRow = row;
            newCol = col - 1;
            if (isFit(newRow, newCol)) {
                list.add(new Move(getNode(newRow, newCol, Direction.LEFT), getPoints(currentDirection, Direction.LEFT)));
            }
        }
        if (currentDirection.equals(Direction.LEFT)) {
            int newRow = row;
            int newCol = col - 1;
            if (isFit(newRow, newCol)) {
                list.add(new Move(getNode(newRow, newCol, Direction.LEFT), getPoints(currentDirection, Direction.LEFT)));
            }
            newRow = row - 1;
            newCol = col;
            if (isFit(newRow, newCol)) {
                list.add(new Move(getNode(newRow, newCol, Direction.TOP), getPoints(currentDirection, Direction.TOP)));
            }
            newRow = row + 1;
            newCol = col;
            if (isFit(newRow, newCol)) {
                list.add(new Move(getNode(newRow, newCol, Direction.BOT), getPoints(currentDirection, Direction.BOT)));
            }
        }

        return new ArrayList<>( list.stream().filter(move -> area.getNodes().get(move.n().r()).get(move.n().c()).i() != '#').toList());

    }

    private Integer getPoints(Direction currentDirection,
                              Direction newDirection) {
        if (currentDirection.equals(newDirection)) {
            return 1;
        }
        return 1001;
    }

    private Node getNode(int newRow, int newCol, Direction d) {
        List<List<Node>> nodes = area.getNodes();
        Node node = nodes.get(newRow).get(newCol);
        return new Node(node.r(), node.c(), node.i(), d);
    }

    private boolean isFit(int newRow, int newCol) {
        return newRow >= 0 && newRow < area.getNodes().size() && newCol >= 0 &&
               newCol < area.getNodes().get(newRow).size();
    }


    public void run() {
        processTree(current, 0);
        System.out.println(minPoints);
    }


        static int minPoints = Integer.MAX_VALUE;
        private void processTree(Node start, Integer points) {
        visited[start.r()][start.c()] = true;
        if (points > minPoints){
            return;
        }
        if (start.c() == finish.c() && start.r() == finish.r()) {
            if (points < minPoints){
                minPoints = points;
            }
            return;
        }

        List<Move> nextMoves = getNextMoves(start);
//        nextMoves.sort(new ScoreComparator());
        for (Move m : nextMoves) {
            Node next = m.n();
            if (visited[next.r()][next.c()]) {
                continue;
            }
            processTree(next, points + m.points());
            visited[next.r()][next.c()] = false;
        }
//            visited[start.r()][start.c()] = false;

    }
//    private void processTree(Node start, Set<Integer> scores, Integer points) {
//        System.out.println(start);
////        if (visited[start.r()][start.c()]) {
////            return;
////        }
//
//        Deque<Node> q = new LinkedList<>();
//        q.add(start);
//
//        while (!q.isEmpty()) {
//
//            Node currentVertex = q.poll();
//            if (currentVertex.c() == finish.c() && currentVertex.r() == finish.r()) {
//                scores.add(points);
//                return;
//            }
//            visited[currentVertex.r()][currentVertex.c()] = true;
//            List<Move> nextMoves = getNextMoves(start);
//
//            for (Move m : nextMoves) {
//                Node next = m.n();
//                if (visited[next.r()][next.c()]) {
//                    continue;
//                }
//                q.add(next);
//            }
//        }
//    }
}

