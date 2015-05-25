package ru.geekbrains.practise.task07;

public class Vocabulary {
    public static void main(String[] args) {
        String[] voc = {"арбуз", "абакан", "абориген", "лето"};
        String s = "Орбуз и абакау пишутся совершенно не так аборигее ! ";
        String[] words = s.split(" ");
        outer:
        for (int i = 0; i < words.length; i++) {
            inner:
            for (String wordFromVoc : voc) {
                if ((words[i].length() - wordFromVoc.length()) == 0) {
                    int differences = 0, index = 0;
                    String lowcaseWord = words[i].toLowerCase();
                    for (int j = 0; j < lowcaseWord.length(); j++) {
                        if (!(words[i].charAt(j) == wordFromVoc.charAt(j))) {
                            differences++;
                            index = j;
                        }
                        if (differences > 1) continue inner;
                    }
                    if (differences == 1) {
                        words[i] = replaceCharAt(words[i], index, Character.isUpperCase(words[i].charAt(index)) ? Character.toUpperCase(wordFromVoc.charAt(index)) : wordFromVoc.charAt(index));
                        continue outer;
                    }
                }
            }
        }
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    public static String replaceCharAt(String s, int pos, char c) {

        return s.substring(0, pos) + c + s.substring(pos + 1);

    }
}