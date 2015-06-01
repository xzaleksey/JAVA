package ru.geekbrains.practise.task14;

public class Capitalizer {
    public static void main(String[] args) {
        System.out.println(capitalize("ЭТО настояшая пРоверка Бубликов"));
    }

    static String capitalize(String s) {
        s = s.toLowerCase();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
        }
        s = "";
        for (String word : words) {
            s += word + " ";
        }
        return s;
    }
}
