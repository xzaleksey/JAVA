package net.wikijava.chapter16.writefiles;

import net.wikijava.chapter16.readfiles.BufferedInputFile;

import java.io.*;

public class BasicFileOutput {
    static String file = System.getProperty("user.dir") + "\\src\\net\\wikijava\\chapter16\\writefiles\\BasicFileOutput.out";

    public static void main(String[] args)
            throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read(System.getProperty("user.dir") + "\\src\\net\\wikijava\\chapter16\\writefiles\\BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close();
        // Вывод содержимого файла
        System.out.println(BufferedInputFile.read(file));
    }
} /* (Execute to see output) *///:~