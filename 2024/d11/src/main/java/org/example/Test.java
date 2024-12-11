package org.example;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("39644108504864");
        BigDecimal b2 = new BigDecimal("22294245516719");
        BigDecimal b3 = new BigDecimal("11651661566042");
        BigDecimal b4 = new BigDecimal("30621612661601");
        BigDecimal b5 = new BigDecimal("13247349525631");
        BigDecimal b6 = new BigDecimal("28928298355070");
        BigDecimal b7 = new BigDecimal("22938365706844");
        BigDecimal b8 = new BigDecimal("54441568412466");
        BigDecimal sum = b1.add(b2);
        sum = sum.add(b3);
        sum = sum.add(b4);
        sum = sum.add(b5);
        sum = sum.add(b6);
        sum = sum.add(b7);
        sum = sum.add(b8);
        System.out.println(sum);
    }
}
