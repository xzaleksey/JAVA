package net.wikijava.chapter11;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        Collections.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);//фиксирует размерность массива
        list.set(1, 99);
        System.out.println(list.get(1));
        //list.add(21); вызовет ошибку
    }
}
