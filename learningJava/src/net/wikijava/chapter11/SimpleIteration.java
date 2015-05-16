package net.wikijava.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SimpleIteration {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3));
        Iterator<Integer> iterator = list.iterator();
        for (int i : list) {
            System.out.println(i);
        }
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            System.out.println(list);
        }

    }
}
