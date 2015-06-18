package net.wikijava.chapter14;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {
    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<>();
        List<String> stringList = stringMaker.create();
        System.out.println(stringList);
    }

    List<T> create() {
        return new ArrayList<>();
    }
}