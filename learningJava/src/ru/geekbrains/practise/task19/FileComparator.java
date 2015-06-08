package ru.geekbrains.practise.task19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileComparator {
    public static void main(String[] args) {
        String path = "src\\ru\\geekbrains\\practise\\task19\\";
        try {
            compareFiles(new File(path + "1.txt"),
                    new File(path + "2.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long compareFiles(File f1, File f2) throws IOException {
        if (f1.length() != f2.length()) {
            System.out.println("Разница длин файлов: " + (f1.length() - f2.length()));
            return f1.length() - f2.length();
        }

        return execute(new BufferedReader(new FileReader(f1.getAbsolutePath())), new BufferedReader(new FileReader(f2.getAbsolutePath())));


    }

    static int execute(final BufferedReader r1, final BufferedReader r2) throws IOException {
        try (BufferedReader b1 = r1) {
            try (BufferedReader b2 = r2) {
                int v1, v2;
                while ((v1 = b1.read()) != -1) {
                    v2 = b2.read();
                    if (v1 != v2) {
                        return v1 - v2;
                    }
                }
                return 0;
            }
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
