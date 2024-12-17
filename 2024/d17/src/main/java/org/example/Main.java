package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static HashMap<Character, Long> reg = new HashMap<>();
    public static void main(String[] args) {

        reg.putIfAbsent('A', 0L);
        reg.putIfAbsent('B', 0L);
        reg.putIfAbsent('C', 0L);

        List<Integer> input = List.of(0,3,5,4,3,0);
        List<Long> program = input.stream().map(Long::valueOf).collect(Collectors.toList());

        long counter = 0;
        while (true){
            reg.put('A', counter);
            List<Long> result = calculate(program);
            if ( result.size() == program.size() && arePartiallyEqual(result, program) ){
                break;
            }
            counter++;
        }
        System.out.println(counter);


    }

    static boolean arePartiallyEqual(List<Long> smaller, List<Long> bigger){
        for (int i = 0; i < smaller.size(); i++) {
            Long l1 = smaller.get(i);
            Long l2 = bigger.get(i);
            if (!l1.equals(l2)){
                return false;
            }
        }
        return true;
    }

    private static List<Long> calculate(List<Long> program) {
        List<Long> longs = new ArrayList<>();

        int counter = 0;
        for (long j = 1; j < program.size(); j = j + 2) {
            if (!arePartiallyEqual(longs, program)){
                return longs;
            }


            if (j > Integer.MAX_VALUE - 2){
                System.out.println("j big number " + j);
            }
            if (counter > 1000000){
                System.out.println("counter big number");
            }
            if (counter > 10000000){
                break;
            }

            long instruction = program.get((int) (j - 1));
            long operand = getNext(program.get((int) j));
            if (instruction == 0){
                adv(operand);
            }else
            if (instruction == 1){
                bxl(program.get((int) j));
            }else
            if (instruction == 2){
                bst(operand);
            }else
            if (instruction == 4){
                bxc(operand);
            }else
            if (instruction == 5){
                out(operand, longs);
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
                    j = program.get((int) j) - 1;
                }
            }
            else {
                throw new RuntimeException();
            }
            counter++;
        }
        return longs;
    }

    static long getNext(long i) {
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
        }
        return reg.get(ch);
    }

    static void adv(long i){
        long numerator = reg.get('A');
        double denominator  = Math.pow(2,i);
        long r = numerator / (int) denominator;
        reg.put('A', r);
    }

    static void bxl(long i){
        long a = reg.get('B');
        long r = a ^ i;
        reg.put('B', r);
    }

    static void bst(long i){
        long r = i % 8;
        reg.put('B', r);
    }

    static void bxc(long i){
        long b = reg.get('B');
        long c = reg.get('C');
        long r = b ^ c;
        reg.put('B', r);
    }

    static void out(long i, List<Long> longs){
        long r = i % 8;
        longs.add(r);
    }

    static void bdv(long i){
        long numerator = reg.get('A');
        double denominator  = Math.pow(2,i);
        long r = numerator / (long) denominator;
        reg.put('B', r);
    }

    static void cdv(long i){
        long numerator = reg.get('A');
        double denominator  = Math.pow(2,i);
        long r = numerator / (long) denominator;
        reg.put('C', r);
    }


}