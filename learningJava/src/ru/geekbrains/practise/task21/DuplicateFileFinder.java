package ru.geekbrains.practise.task21;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

import static ru.geekbrains.practise.task19.FileComparator.compareFiles;

public class DuplicateFileFinder {
    public static void main(String[] args) {
        try {
            ArrayList<File> files = new ArrayList<>(Arrays.asList(new File(System.getProperty("user.dir") + "\\src\\ru\\geekbrains\\practise\\task19").listFiles()));
            ArrayList<LinkedHashSet> result = new ArrayList<>();
            int size = files.size();
            if (size > 1) {
                while (size != 0) {
                    Iterator<File> iterator = files.iterator();
                    LinkedHashSet<File> linkedHashSet = new LinkedHashSet<>();
                    File file = iterator.next(); //с чем будем сравнивать
                    iterator.remove();
                    linkedHashSet.add(file);
                    while (iterator.hasNext()) {
                        File temp = iterator.next();
                        try {
                            if (compareFiles(file, temp) == 0) {
                                linkedHashSet.add(temp);
                                iterator.remove();
                            }
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    size -= linkedHashSet.size();
                    if (linkedHashSet.size() > 1) {
                        result.add(linkedHashSet);
                    }
                }
                for (LinkedHashSet linkedHashSet : result) {
                    System.out.println(linkedHashSet + " are duplicates");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Нет такой директории");
        }

    }
}
