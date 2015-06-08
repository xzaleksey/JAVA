package ru.geekbrains.practise.task21;

import java.io.File;

import static ru.geekbrains.practise.task19.FileComparator.compareFiles;

public class DuplicateFileFinder {
    public static void main(String[] args) {
        try {
            File[] files = new File("C:\\git\\JAVA\\learningJava\\src\\ru\\geekbrains\\practise\\task19").listFiles();

            if (files.length > 1) {
                for (int i = 0; i < files.length - 1; i++) {
                    for (int j = i + 1; j < files.length; j++) {
                        System.out.println(files[i].getAbsolutePath() + " " + files[j].getAbsolutePath());
                        compareFiles(files[i], files[j]);

                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Нет такой директории");
        }

    }
}
