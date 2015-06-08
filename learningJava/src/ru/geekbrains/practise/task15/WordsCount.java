package ru.geekbrains.practise.task15;

import java.util.*;

public class WordsCount {
    public static void main(String[] args) {
        countWords("О ОО ООО ОО");
    }

    static void countWords(String s) {
        if (s.length() == 0) {
            System.out.println("Строка пустая");
            return;
        }
        s = s.replaceAll("\\p{Punct}", "").toLowerCase();
        //System.out.println(s);
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (String word : s.split(" ")) {
            if (treeMap.containsKey(word)) {
                treeMap.put(word, treeMap.get(word) + 1);
            } else treeMap.put(word, 1);
        }
        List list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        System.out.println(list);
    }
}
