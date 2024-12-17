package org.example;


import java.util.HashMap;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static HashMap<Character, Integer> reg = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        // not 0,0,0,0,0,0,0,0,0
        reg.putIfAbsent('A', 60589763);
        reg.putIfAbsent('B', 0);
        reg.putIfAbsent('C', 0);

        List<Integer> program = List.of(2,4,1,5,7,5,1,6,4,1,5,5,0,3,3,0);
//        List<Integer> program = List.of(0,1,5,4,3,0);

        int counter = 0;
//        int j = 1;
//        while (j < program.size()){
        for (int j = 1; j < program.size(); j = j + 2) {
            if (counter > 20){
//                break;
            }
//            System.out.println(j);

//            System.out.println("performing ins" + program.get( j - 1 ));

            int instruction = program.get( j - 1 );
            int operand = getNext(program.get( j  ));
//            System.out.println("performing operand " + operand);
            if (instruction == 0){
                adv(operand);
            }else
            if (instruction == 1){
                bxl(program.get(j));
            }else
            if (instruction == 2){
                bst(operand);
            }else
            if (instruction == 4){
                bxc(operand);
            }else
            if (instruction == 5){
                out(operand);
            }else
            if (instruction == 6){
                bdv(operand);
            }else
            if (instruction == 7){
                cdv(operand);
            }else
            if (instruction == 3){
                counter++;
                //TODO the instruction pointer is not increased by 2 after this instruction
                if (reg.get('A') == 0){
                }else {
                    System.out.println("before update " + program.get(j));
                    //TODO is this OK?
                    j = program.get(j) - 1;
                }
            }
            else {
                new RuntimeException();
            }
            counter++;
            System.out.println(sb);
//            j+=2;
        }

        System.out.println(reg);

        System.out.println(sb);




    }

    static int getNext(int i) {
        if (i >= 0 && i < 4) {
            return i;
        }
        char ch = '0';
        if (i == 4) {
            ch = 'A';
        } else if (i == 5) {
            ch = 'B';
        } else if (i == 6) {
            ch = 'C';
        } else {
            // TODO this is 7, it is not matching instructions
            return  i;
//            throw new RuntimeException();
        }
        return reg.get(ch);
    }

    static void adv(int i){
//        System.out.println("i "+ i);
        int numerator = reg.get('A');
        double denominator  = Math.pow(2,i);
//        System.out.println("denominator " + denominator);
        int r = numerator / (int) denominator;
//        System.out.println("value " + r);
        System.out.println("ADV " + reg);
        System.out.println(numerator + " / " + denominator + " = " + r);
        reg.put('A', r);
        System.out.println("ADV " + reg);
    }

    static void bxl(int i){
        int a = reg.get('B');
        int r = a ^ i;
        System.out.println("bxl " + reg);
        System.out.println(a + " ^ " + i + " = " + r);
        reg.put('B', r);
        System.out.println("bxl " + reg);
    }

    // (thereby keeping only its lowest 3 bits) ??
    static void bst(int i){
        int r = i % 8;
        System.out.println("bst " + reg);
        System.out.println(i + " % 8 = " + r);
        reg.put('B', r);
        System.out.println("bst " + reg);
    }

    static void bxc(int i){
        int b = reg.get('B');
        int c = reg.get('C');
        int r = b ^ c;
        System.out.println("bxc " + reg);
        System.out.println(b + " ^ " + c + " = " + r);
        reg.put('B', r);
        System.out.println("bxc " + reg);
    }

    static void out(int i){
        int r = i % 8;

        sb.append(r + ",");
    }

    static void bdv(int i){
        int numerator = reg.get('A');
        double denominator  = Math.pow(2,i);
        int r = numerator / (int) denominator;
        System.out.println("bdv " + reg);
        System.out.println(numerator + " / " + denominator + " = " + r);
        reg.put('B', r);
        System.out.println("bdv " + reg);
    }

    static void cdv(int i){
        int numerator = reg.get('A');
        double denominator  = Math.pow(2,i);
        int r = numerator / (int) denominator;
        System.out.println("bdv " + reg);
        System.out.println(numerator + " / " + denominator + " = " + r);
        reg.put('C', r);
        System.out.println("bdv " + reg);
    }


}