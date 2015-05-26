package ru.geekbrains.practise.task06;

import java.util.Map;
import java.util.TreeMap;

public class Multiply {
    static final int NUMBER = 1000;

    // todo ������� �����������, ���������
    public static void main(String[] args) {
        String a = "999", b = "9999";
        multiply(a, b);
    }

    static void multiply(String a, String b) {
        String result = "";
        int counterA = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();//kluch - eto stepen 1000
        while (a.length() > 0) {//chislo kotoroe umnojaem
            int counterB = 0;
            String lastA = cut(a, false); //obrezaem po 3
            a = cut(a, true);
            String tempB = b;//chislo na kotoroe umnojaem
            while (tempB.length() > 0) {
                String lastB = cut(tempB, false);
                tempB = cut(tempB, true);
                int temp = mult(lastA, lastB);
                int dif = 0;
                if (temp > 999) { //esli bolshe nuzhen perenos
                    dif = temp / NUMBER;
                    treeMap = checkAndPut(treeMap, counterB + counterA + 1, dif);
                }
                treeMap = checkAndPut(treeMap, counterB + counterA, temp - dif * NUMBER);
                counterB++;
            }
            counterA++;
        }
        int treeMapSize = treeMap.size(), counter = 1;
        for (Map.Entry e : treeMap.entrySet()) {
            result = counter != treeMapSize ? String.format("%03d", e.getValue()) + result : e.getValue() + result; //ispravil dobavlenie 00
            counter++;
        }
        System.out.println(result);
    }

    static TreeMap<Integer, Integer> checkAndPut(TreeMap<Integer, Integer> treeMap, int key, int value) {
        if (treeMap.containsKey(key)) {
            int temp = treeMap.get(key) + value;
            treeMap = sdvig(treeMap, key, temp);
        } else {
            treeMap.put(key, value);
        }
        return treeMap;
    }

    static TreeMap<Integer, Integer> sdvig(TreeMap<Integer, Integer> treeMap, int key, int value) {
        if (value > 999) {
            int temp = value / NUMBER;
            treeMap.put(key, value - temp * NUMBER);
            if (treeMap.containsKey(key + 1)) {
                sdvig(treeMap, key + 1, temp + treeMap.get(key + 1));
            } else {
                sdvig(treeMap, key + 1, temp);
            }
        } else {
            treeMap.put(key, value);
        }
        return treeMap;
    }

    static int mult(String a, String b) {
        return Integer.parseInt(a) * Integer.parseInt(b);
    }

    static String cut(String s, boolean fullString) {
        if (s.length() >= 3) {
            return fullString ? s.substring(0, s.length() - 3) : s.substring(s.length() - 3, s.length());
        } else {
            return fullString ? "" : s;
        }
    }
}
