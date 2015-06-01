package ru.geekbrains.practise.task12;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class SortTreeMap {


    public static void main(String[] args) {
        int a[] = new int[40];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(15);
        }
        System.out.println(Arrays.toString(sort(a)));
    }

    static int[] sort(int[] a) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : a) {
            treeMap.put(i, treeMap.containsKey(i) ? treeMap.get(i) + 1 : 1);
        }
        int counter = 0;
        for (Map.Entry<Integer, Integer> e : treeMap.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) {
                a[counter++] = e.getKey();
            }
        }
        return a;
    }
}
