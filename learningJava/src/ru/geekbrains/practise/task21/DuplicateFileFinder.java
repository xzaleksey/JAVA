package ru.geekbrains.practise.task21;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import static ru.geekbrains.practise.task19.FileComparator.compareFiles;

public class DuplicateFileFinder {
    public static void main(String[] args) {
        try {
            File[] files = new File("C:\\git\\JAVA\\learningJava\\src\\ru\\geekbrains\\practise\\task19").listFiles();
            TreeSet<File> treeSet = new TreeSet<>();
            if (files.length > 1) {
                for (int i = 0; i < files.length - 1; i++) {
                    if (files[i].isFile()) {
                        for (File file : treeSet) {
                            try {
                                if (compareFiles(file, files[i]) == 0) {

                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        treeSet.add(files[i]);
                    }

                }
            }
            System.out.println(treeSet);
        } catch (NullPointerException e) {
            System.out.println("Нет такой директории");
        }

    }
}
