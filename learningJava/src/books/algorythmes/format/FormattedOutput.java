package books.algorythmes.format;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormattedOutput {

    public static void formattedOutput(String s) {
        String[] strings = s.trim().split(" ");
        if (strings.length != 3) {
            return;
        }
        int a = Integer.parseInt(strings[1]);
        int b = Integer.parseInt(strings[2]);
        float c = a / b * 1.0f;
        System.out.format("%s %d %d %.3f", strings[0], a, b, c);
    }

    public static String readLines() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public static void formatLines() {
        String s;
        while ((s = readLines()) != null) {
            formattedOutput(s);
        }
    }

    public static void main(String[] args) {
        formatLines();
    }
}
