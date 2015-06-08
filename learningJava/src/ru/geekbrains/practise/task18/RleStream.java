package ru.geekbrains.practise.task18;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static ru.geekbrains.practise.task16.RleaArchiver.archivate;
import static ru.geekbrains.practise.task17.RleDesarchiver.desarchivate;

public class RleStream {
    public static void main(String[] args) {
        String path = "src\\ru\\geekbrains\\practise\\task18\\";
        try {
            execute(new BufferedReader(new FileReader(path + "1.txt")), true);
            execute(new BufferedReader(new FileReader(path + "2.txt")), false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void execute(final BufferedReader r, boolean archieve) {
        try (BufferedReader bufferedReader = r) {
            readFile(bufferedReader, archieve);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void readFile(BufferedReader reader, boolean archieve) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(archieve ? archivate(line) : desarchivate(line));
            stringBuilder.append("\n");

        }
        System.out.println(stringBuilder.toString());
    }
}
