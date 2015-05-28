package ru.geekbrains.forksenia;

import ru.geekbrains.practise.task04.LongNumbers;

import java.util.ArrayList;

public class Multiply {
    public static void main(String[] args) {
        String a = "123456789", b = "987654321";
        multiply(a, b);
    }

    static void multiply(String a, String b) {
        String result = "";
        int tempInt = 0;
        int counterA = 0;
        ArrayList<String> results = new ArrayList<>();
        while (a.length() != 0) {
            String lastA = cut(a, false); //obrezaem po 3
            a = cut(a, true);
            String tempB = b;
            results.add("");
            while (tempB.length() != 0) {
                String lastB = cut(tempB, false);
                tempB = cut(tempB, true);
                int temp = mult(lastA, lastB) + tempInt;
                String tempStr;
                if (tempB.length() == 0) { //esli bolshe nuzhen perenos
                    tempStr = temp + "";
                } else if (temp > 999) {
                    tempInt = temp / 1000;
                    tempStr = String.format("%03d", temp - tempInt * 1000);
                } else {
                    tempStr = String.format("%03d", temp);
                }
                results.set(counterA, tempStr + results.get(counterA));
            }
            counterA++;
        }
        for (int i = 0; i < results.size() - 1; i++) {
            String tempStr = cut(results.get(i), true);
            results.set(i, cut(results.get(i), false));
            result = results.get(i) + result;
            if (tempStr.length() > 0) {
                results.set(i + 1, LongNumbers.sum2(results.get(i + 1), tempStr));
            }
        }
        result = results.get(results.size() - 1) + result;
        System.out.println(result);
    }

    static int mult(String a, String b) {
        return Integer.parseInt(a) * Integer.parseInt(b);
    }

    static int sum(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    static String cut(String s, boolean fullString) {
        if (s.length() >= 3) {
            return fullString ? s.substring(0, s.length() - 3) : s.substring(s.length() - 3, s.length());
        } else {
            return fullString ? "" : s;
        }
    }
}
