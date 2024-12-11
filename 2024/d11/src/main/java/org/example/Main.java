package org.example;


import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String input = """
77 515 6779622 6 91370 959685 0 9861
            """;
    public static void main(String[] args) {
        ArrayList<Long> list = new ArrayList<>();
        // 164601 too low

        for (String s : input.split("\\s+")) {
            list.add(Long.valueOf(s));
        }
//        System.out.println("before " + list);
        int blinks = 25;
        for (int blink = 0; blink < blinks; blink++) {
            list = compute(list);
//            System.out.println("after " + list);
        }
        System.out.println("final " + list.size());

    }

    private static ArrayList<Long> compute(ArrayList<Long> list) {
        ArrayList<Long> newList = new ArrayList<>();
        for (Long i : list) {
            if (i == 0){
                newList.add(1L);
            }
            else
            if (i.toString().length() % 2 == 0){
                String tmp = i.toString();
                int n = tmp.length();
                String one = tmp.substring(0,n / 2);
                String two = tmp.substring(n / 2);
                one = replaceIfExtraLeadingZero(one);
                two = replaceIfExtraLeadingZero(two);
                newList.add(Long.valueOf(one));
                newList.add(Long.valueOf(two));
            }
            else{
                newList.add( i * 2024 );
            }
        }
        return newList;
    }

    private static String replaceIfExtraLeadingZero(String s) {
        if (s.length() == 1){
            return s;
        }
//        char[] charArray = s.toCharArray();
//        int counter = 0;
//        for (int i = charArray.length - 2; i >=0 ; i--) {
//            char last = charArray[i];
//            char next = charArray[i];
//            if (last == '0' && next == '0'){
//                counter++;
//            }else{
//                return s.substring(0, s.length() - counter);
//            }
//        }
        if (s.matches("^0+$")){
            return "0";
        }
        return s;
    }
}