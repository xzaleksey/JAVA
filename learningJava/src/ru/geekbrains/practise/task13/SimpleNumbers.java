package ru.geekbrains.practise.task13;

import java.util.ArrayList;

public class SimpleNumbers {
    public static void main(String[] args) {
        System.out.println(getSimpleNumbers(50));
    }

    static ArrayList<Integer> getSimpleNumbers(int n) {
        ArrayList<Integer> integers = new ArrayList<>();
        outer:
        for (int i = 2; i <= n; i++) {
            for (Integer integer : integers) {
                if (i % integer == 0) continue outer;
            }
            integers.add(i);
        }
        return integers;
    }
}
