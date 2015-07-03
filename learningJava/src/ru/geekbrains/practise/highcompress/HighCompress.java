package ru.geekbrains.practise.highcompress;

import java.util.HashMap;

public class HighCompress {
    public static void main(String[] args) {
        HashMap<String, Integer> compVoc = new HashMap<>();
        for (int i = 97; i < 102; i++) {
            compVoc.put(String.valueOf((char) i), i - 97);
        }
        HashMap<String, String> decompVoc = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            decompVoc.put(String.valueOf(i), String.valueOf((char) (i + 97)));
        }
        System.out.println(compress("abaabaabaabaabaaba", compVoc));
        System.out.println("abaabaabaabaabaaba");
        System.out.println(decompress("0105768116", decompVoc));
    }

    public static String compress(String s, HashMap<String, Integer> voc) {
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        int length = voc.size();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            current.append(c);
            if (!voc.containsKey(current.toString())) {
                voc.put(current.toString(), length++);
                result.append(voc.get(current.substring(0, current.length() - 1)));
                current.setLength(0);
                current.append(c);
            }
        }


        return result.append(voc.get(current.toString())).toString();
    }

    public static String decompress(String s, HashMap<String, String> voc) {
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        int length = voc.size();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            current.append(c);
            if (!voc.containsKey(current.toString())) {
                String temp = voc.get(current.substring(0, current.length() - 1));//предыдущие символы
                String temp2; //текущие символы
                temp2 = voc.get(String.valueOf(c)) != null ? voc.get(String.valueOf(c)).substring(0, 1) : temp.substring(0, 1); //проверка на повторение одних и тех же символов
                voc.put(String.valueOf(length++), temp + temp2);
                result.append(temp);
                current.setLength(0);
                current.append(c);
            }

        }

        return result.append(voc.get(current.toString())).toString();
    }
}
