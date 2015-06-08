package ru.geekbrains.practise.task20;

import java.io.File;
import java.util.ArrayList;

public class RecursiveFileSearch {
    static ArrayList<File> fileArrayList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(getAllFiles(System.getProperty("user.dir")));
    }

    static ArrayList<File> getAllFiles(String path) {

        File current = new File(path);
        File[] files = current.listFiles();
        System.out.println(current.getAbsolutePath() + "\n");
        try {
            if (files.length > 0) {
                for (File file : files) {
                    System.out.println(file.getName());
                    fileArrayList.add(file);
                }
                System.out.println("\n");
                for (File file : files) {
                    if (file.isDirectory()) {
                        getAllFiles(file.getAbsolutePath());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Директория не найдена");
        }
        return fileArrayList;
    }
}
