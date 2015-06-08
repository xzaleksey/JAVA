package ru.geekbrains.practise.task17;

public class RleDesarchiver {
    public static void main(String[] args) {
        String s = "Т40111";
        desarchivate(s);
    }


    public static String desarchivate(String s) {
        String s1 = "";
        for (int i = 0; i < s.length(); i += 2) {
            for (int j = 0; j < Character.getNumericValue(s.charAt(i + 1)); j++) {
                s1 += s.charAt(i);
            }
        }
        return s1;
    }
}
