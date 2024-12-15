package org.example;

import java.util.ArrayList;
import java.util.List;

public class Area2 {
    private final List<List<Node>> list;

    public Area2(List<String> input) {
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String lines = input.get(i);
            List<Node> chars = new ArrayList<>();
            String[] split = lines.split("");
            int colCounter = 0;
            for (int j = 0; j < split.length; j++) {
                String s = split[j];
                char c = s.charAt(0);
                if (c == '@') {
                    chars.add(new Node(BoxType.ROBOT, i,colCounter,colCounter));
                    chars.add(new Node(BoxType.EMPTY, i,++colCounter,colCounter));
                } else if (c == '#') {
                    chars.add(new Node(BoxType.WALL, i,colCounter,colCounter));
                    chars.add(new Node(BoxType.WALL, i,++colCounter,colCounter));
                } else if (c == 'O') {
                    Node node = new Node(BoxType.BOX, i, colCounter, ++colCounter);
                    chars.add(node);
                    chars.add(node);
                } else {
                    chars.add(new Node(BoxType.EMPTY, i,colCounter,colCounter));
                    chars.add(new Node(BoxType.EMPTY, i,++colCounter,colCounter));
                }
            }
            list.add(chars);
        }
        this.list = list;
    }

    public List<List<Node>> getArea() {
        return list;
    }

    public void show(){
        for (List<Node> characters : list) {
            for (Node character : characters) {
                System.out.print(character);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("####################################");
    }

//    public int sumOfCoordinates(){
//        int sum = 0;
//        for (int i = 0; i < list.size(); i++) {
//            List<Character> characters = list.get(i);
//            for (int j = 0; j < characters.size(); j++) {
//                Character character = characters.get(j);
//                if (character.equals('O')){
//                    sum += 100 * i + j;
//                }
//            }
//        }
//        return sum;
//    }


}
