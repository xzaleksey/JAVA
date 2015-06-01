package ru.geekbrains.practise.task17;

public class RleDesarchiver {
    public static void main(String[] args) {
        String s = "Т8У7Т7 2М4Н4О3Г2О3 1П1О6В5Т5О3Р2О2В2";
        desarchivate(s);
    }


    static void desarchivate(String s) {
        String s1 = "";
        for (int i = 0; i < s.length(); i += 2) {
            for (int j = 0; j < Character.getNumericValue(s.charAt(i + 1)); j++) {
                s1 += s.charAt(i);
            }
        }
        System.out.println(s1);
    }
}
