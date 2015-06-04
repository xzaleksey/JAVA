package ru.geekbrains.practise.task16;

public class RleaArchiver {
    public static void main(String[] args) {
        String s = "ТТТТТТТТУУУУУУУТТТТТТТ  ММММННННОООГГООО ПООООООВВВВВТТТТТОООРРООВВ  Т";
        archivate(s);
    }

    static void archivate(String s) {
        String s1 = "";
        char current = s.charAt(0);
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            if (current == tempChar) {
                counter++;
            } else {
                s1 += current;
                s1 += counter;
                counter = 1;
                current = tempChar;
            }
            if (i == s.length() - 1) {
                s1 += current;
                s1 += counter;
            }
        }
        System.out.println(s1);
    }
}
