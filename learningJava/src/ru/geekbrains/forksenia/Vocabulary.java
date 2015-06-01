package ru.geekbrains.forksenia;

import java.util.Arrays;

/**
 * Created by k.frolova on 29.05.15.
 */
public class Vocabulary {
    String[] voc = new String[]{"арбуз", "ассоциация", "бабушка", "голова", "дерево"};

    public static void main(String[] args) {
        String s = "бабошка съела орбуз a";
        String[] words = s.split(" ");
        Vocabulary vocab = new Vocabulary();
        for (int i = 0; i < words.length; i++) {
            String str = vocab.search(words[i]);
            words[i] = str;
        }
        System.out.println(Arrays.toString(words));
    }

    public String search(String s) {
        int count = 0;
        for (int i = 0; i < voc.length; i++) {
            for (int j = 0; j < voc[i].length(); j++) {
                char chVoc = voc[i].charAt(j);

                if (chVoc == s.charAt(j)) {
                    System.out.println("equals ");
                    if (j == voc[i].length() - 1) {
                        s = voc[i];

                    }

                } else {
                    System.out.println("not equals ");
                    if (count == 2) {
                        count = 0;

                        break;

                    } else {
                        count += 1;
                    }

                }

            }
        }
        return s;
    }
}