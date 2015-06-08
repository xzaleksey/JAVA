package ru.geekbrains.practise.task19;

import java.io.*;

public class FileComparator {
    public static void main(String[] args) {
        String path = "src\\ru\\geekbrains\\practise\\task19\\";
        compareFiles(new File(path + "1.txt"),
                new File(path + "2.txt"));
    }

    public static void compareFiles(File f1, File f2) {
        try {
            if (f1.length() != f2.length()) {
                System.out.println("Разница длин файлов: " + (f1.length() - f2.length()));
                return;
            }
            execute(new BufferedReader(new FileReader(f1.getAbsolutePath())), new BufferedReader(new FileReader(f2.getAbsolutePath())));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void execute(final BufferedReader r1, final BufferedReader r2) {
        try (BufferedReader b1 = r1) {
            try (BufferedReader b2 = r2) {
                int v1, v2;
                while ((v1 = b1.read()) != -1) {
                    v2 = b2.read();
                    if (v1 != v2) {
                        System.out.println(v1 - v2);
                        return;
                    }
                }
                System.out.println(0);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
